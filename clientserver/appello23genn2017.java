// primo esercizio

class T1 extends Thread{
  Albero a;
  Object scrittura;
  T1(Albero a, Object scrittura){this.a=a;this.scrittura=scrittura;}
  public void run(){
    // aggiunge qui, dorme, aggiunge quo, print albero
    synchronized(scrittura){ // operazioni di scrittura e lettura assumono il medesimo lock
      a.add("qui");
      Thread.sleep(100);
      a.add("quo");
    }
    a.stampa(); // fuori dal blocco synch perchè la consegna chiede che l'albero possa essere stampato concorrentemente
    // alle stampe di t3 e t2. Quest'ultime, grazie al lock su scrittura, sono tra loro mutualmente esclusive
  }
}

class T2 extends Thread{
  Albero a;
  Object scrittura;
  T2(Albero a, Object scrittura){this.a=a;this.scrittura=scrittura;}
  public void run(){
    // check quo, BIANCO se c'è, NERO else. Dorme, stampa ROSSO
    synchronized(scrittura){
      if(a.presente("quo")) System.out.println("BIANCO");
      else System.out.println("NERO");
      Thread.sleep(100);
      System.out.println("ROSSO");
    }
  }
}


class T3 extends Thread{
  Albero a;
  Object scrittura;
  T3(Albero a, Object scrittura){this.a=a;this.scrittura=scrittura;}
  public void run(){
    // check qui, UNO se c'è, DUE else. Dorme, stampa TRE
    synchronized(scrittura){
      if(a.presente("QUI")) System.out.println("UNO");
      else System.out.println("DUE");
      Thread.sleep(100);
      System.out.println("TRE");
    }
  }
}

public static void main(){
  // Albero a= bla bla...
  // popolamento Albero a
  Object scrittura=new Object();
  T1 t1=new T1(a,scrittura);
  T2 t2=new T2(a,scrittura);
  T3 t3=new T3(a,scrittura);
  t1.start();t2.start();t3.start();
}
// SECONDO esercizio

class AlberoImpl implements Iteratore{

  public Iteratore itera(){
    return new Iteratore(){
      public boolean hasNext(){
        // return figlioSin || figlioDx; // alla C++
        if(figlioSin!=NULL || figlioDx!=NULL) return true;
        return false;
      }
      public String next(){
        if(hasNext()){
          if(figlioSin!=NULL) return figlioSin.info;
          return figlioDx.info;
        }
        return NULL;
      }
    }
  }
}

public static void main(){
  // abbiamo l'albero a popolato ...
  Iteratore it=a.itera();
  while(a.hasNext())
   System.out.println(it.next());
}

// TERZO esercizio
/*
Le classi AlberoImpl e AlberoVuoto dovranno estendere UnicastRemoteObject
*/

// AGGIUNTE ALLA CLASSE AlberoImpl

class AlberoImpl extends UnicastRemoteObject implements Albero{
  public Albero synchronized add(String s){}
}

class T1 extends Thread{
  Albero a;
  T1(Albero a){this.a=a;}
  public void run(){
    a.add("qui");
    Thread.sleep(100);
    a.add("quo");
    a.stampa();
    }
  }
}

class Server{
  public static void main(){
      AlberoImpl a=new AlberoImpl("pippo");
      // popolamento...
      Naming.rebind("remoto",a);
      T1 t1=new T1(a);
      t1.start();
  }
}

// -----------------------------------------------

class T2 extends Thread{
  Albero a;
  Object stampa_client;
  T2(Albero a,Object s){this.a=a;stampa_client=s;}
  public void run(){
    synchronized(stampa_client){
      if(a.presente("quo")) System.out.println("BIANCO");
      else System.out.println("NERO");
      Thread.sleep(100);
      System.out.println("ROSSO");
    }
  }
}

class T3 extends Thread{
  Albero a;
  Object stampa_client;
  T3(Albero a,Object s){this.a=a;stampa_client=s;}
  public void run(){
    synchronized(stampa_client){
      if(a.presente("QUI")) System.out.println("UNO");
      else System.out.println("DUE");
      Thread.sleep(100);
      System.out.println("TRE");
    }
  }
}

class Client{
    public static void main(){
      Albero a=(Albero)Naming.lookup("pippo");
      Object stampa_client=new Object();
      T2 t2=new T2(a,stampa_client);
      T3 t3=new T3(a,stampa_client);
    }

}

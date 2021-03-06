# What this is about

First assignment for the course of Distributed and Concurrent Programming (Programmazione Concorrente e Dstribuita) AA. 2017/2018 

Due delivery: November 17, 2017. h.23:59

## Getting Started

The exercises are build using the Gradle build system which should be available by default in our lab. PCs. 
Below are reported some preliminary (not exhaustive) steps needed to setup up the work environment

### Prerequisites

First, and to be sure, check that the gradle build system is available in your current system by issuing the following command:

```
1. gradle -v
```
if the output is what is expected than proceed with the next step, otherwise refer to 
* [Gradle](https://gradle.org/install/) - Build System
for the installation tips for your system.

The second step is to check whether you have git (version control system) installed in your local environment

```
2. git --version
```
if the output is what is expected than proceed with the next step, otherwise refer to
* [git](https://git-scm.com/downloads ) - Version Control System
for the installation tips for your system.

### Getting the project sources

After you have setup the necessary tools needed to retrieve and build the project go on and clone the repository by issuing a 

```
3. git clone https://pcd1718@bitbucket.org/pcd1718/pcd1718mod1.git
4. cd pcd1718mod1
```

Once you have retrieved and positioned in the right directory you can build the project as follows:

```
5. gradle build
```

Gradle will automatically download the necessary project files and definitions needed for this project to compile (i.e., the JUnit library needed for testing).
If the command was successful, a directory (./classes/) has been created containing the .class files along with the unit test reports.
As you might have noticed, tests fail as you need to fill-in the missing code.

To execute the tests only go on and type:

```
6. gradle test
```


### IDE Import

You can import the project in your favourite IDE by following the available Import Gradle Project-like wizzard.

### The Exercises

The code is commented and you should fill in the missing implementation. The test cases are there to help guide you during the development process.
Pay careful attention to them! You can add additional helper methods if you retain them useful.

You need to delivery the project following the below criteria evenif some (not all) of those tests fail.

## Project Delivery

Below you can find some details regarding exercise delivery and grading strategy

### How
The delivery will happen via email, sent to me following these criteria: 
(1) The email subject adheres to the following format: [pcd] Name Surname Student_Identifier, the textual contents of the email
are not important but you can repeat the subject (e.g., [pcd] pinco palino 123432). 
(2) The source files comprising the 'src' directory the 'settings.gradle' and 'build.gradle' should be wrapped inside a root directory named
according to the format name-surname-studentIdentifier (e.g., pinco-pallino-123432) and compressed. Only the compressed file should be sent through email. 


Directory structure example:

```
pinco-pallino-123432 
│   build.gradle
│   settings.gradle
│
└───src

```

** Note that no external archives should be referenced in you project. **

Failure to meet these criteria can result in you project not being evaluated.

### Grading and Written Exam

As explained during the classes, exercises contribute by a 30% to the final vote. You can sustain the written exam evenif you have not delivered the exercises.
However, each exam session has its own set of exercises, that is, if you sustain the written exam of session X but have not yet delivered the exercises of this session,
you SHOULD (in order to obtain a final vote) deliver the exercises of session X+1.

Session 1 is a special case, the exercises are delivered in a two-step process; first you deliver the first set and after the second one. In the other sessions
you should deliver all the exercises at bulk.

The due delivery for THIS set of exercises is November 17, 2017. h.23:59.



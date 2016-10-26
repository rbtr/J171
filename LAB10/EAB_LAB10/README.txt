Evan Baker
CSC171
LAB TR 0940-1055
TA Stephen Cohen
LAB09

Assignment description: In this lab, we practiced final, Java graphics, and Exceptions.

Instructions to ** BUILD & RUN ** :
A buildscript has been provided in .bat and .sh format. However, this project was built and compiled in IntelliJ - the
runscript uses the complied IntelliJ sources, the buildscript will build in to a different directory and would then the
runscript would need to be modified to point to that for running. The Driver should be complete enough to make that
unneccesary

## TO BUILD ##
This project has already been built and the compiled classes are provided, so this is unnecessary. If you want to build
anyway, see the note above about the runscript.

In the root dir, run:
$ ./build.sh 
or the Windows equivalent.

Examine the contents of this build script to see specific package building implementation.

A runscript has also been provided:

## TO RUN ##
In the root dir (after building), run:
$ ./run.sh
or the Windows equivalent.

The runscript runs the Driver class, which displays a commandline picker for testing everything.

BONUS:
You challenged me to implement my entire Driver in Bash to prevent the JVM from exiting when the GUI windows were
closed. Instead, I've improved the Java Driver to be handle that. I thought this was a better idea - make the Driver
the single entry point to the entire program instead of having options in the runscript.
The GUI sections all inherit from a parent DynamicFrame object that encapsulate some of the common GUI boilerplate, in
compliance with DRY.
In addition to an Exception package that satisfies the requirements of the section, I also made a custom
TestFailedException that my test classes throw on failure.
Full JavaDoc in the doc/ folder.


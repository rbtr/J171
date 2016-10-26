Evan Baker
CSC171
LAB TR 0940-1055
TA Stephen Cohen
LAB09

Assignment description: In this lab, we practiced static, the Singeton pattern, created an isEqual() utility that
performs a shallow camparison of two objects, and Java graphics.


Instructions to ** BUILD & RUN ** :
A buildscript has been provided in .bat and .sh format. 

## TO BUILD ##
In the root dir, run:
$ ./build.sh 
or the Windows equivalent.

Examine the contents of this build script to see specific package building implementation.

A runscript has also been provided

## TO RUN ##
In the root dir (after building), run:
$ ./run.sh
or the Windows equivalent.

The runscript runs the Driver class, which displays a commandline picker for testing all/specific classes.
All classes can be run directly which just runs the default test method.

BONUS: Minimal. There is a test picker in the Driver, which isn't great. I also used the Equalizer to test that the
Logger was a Singleton, but I expect that that was the point of introducing those together. This graphics stuff is out
of my wheelhouse.
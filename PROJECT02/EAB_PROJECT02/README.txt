Evan Baker
CSC171
LAB TR 0940-1055
TA Stephen Cohen
Project 2

Assignment description: In this project, we practiced the MVC design pattern. A implementing a GUI was suggested, but not required (I did not, but have set everything up such that the UserInterface layer could easily be changed - according to the design theory of MVC).


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

The runscript runs the Main class, which (by default) displays a commandline interface to the BankController. I intended to write a GUI interface as well, but since it is not required....

BONUS: The reason I do not have a GUI is that I spent all of my time writing the Model and Controller (and dislike Java Graphic). To make up for it, I've made sure that everything is so well documented that it should be obvious how a GUI would be implemented. To this end, full JavaDoc is provided in the doc/ folder (or by clicking the JAVADOC alias in the home dir).
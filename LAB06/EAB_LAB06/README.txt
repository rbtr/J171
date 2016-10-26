Evan Baker
CSC171
LAB TR 0940-1055
TA Stephen Cohen
LAB06

Assignment description: Practice packaging, protected, and related abilities of Java. Also practice looping, 
testing, and inheritance.

Answer to question: Instantiating Product does not work when called outside of its package because the constructor
is protected.


Instructions to ** BUILD & RUN ** :
A buildscript has been provided in .bat and .sh format (bonus points?). 
NOTE: I haven't actually tested the .bat, but the .sh works as expected.

## TO BUILD ##
In the root dir, run:
$ ./build.sh 
or the Windows equivalent.

Examine the contents of this build script to see specific package building implementation.

A section of the lab requires running a Java program directly. Everything else I implemented in the Tests.
A runscript and a testscript have also been provided (I got tired of typing everything every time).
NOTE: Again, scripts are .bat and .sh, but only the .sh has been tested.

## TO RUN ##
In the root dir (after building), run:
$ ./run.sh
or the Windows equivalent.

Examine the contents of this run script to see specific package running implementation.



Most of the lab was about building Tests on the objects created, and those are where the correctness is determined.
## TO TEST ##
In the root dir (after building), run:
$ ./test.sh
or the Windows equivalent.

Examine the contents of this test script to see specific package testing implementation.

Note: testing is not the most robust because it's entirely static. Dynamically/randomly generating the tested objects
would be more thorough. 


Bonus:
Is that I wrote a buildscript to make this easier not enough?
In several classes (Warehouse, Checkerboard) I used a StringBuilder for efficency when iteratively constructing a 
potentially long string.
I implemented a standard "correct" directory structure with /src and /bin tlds, and...
The test are implemented in their own package(s) that properly import everything necessary.
Good use of final on properties that can be set at instantiation and then should not change.
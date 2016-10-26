Evan Baker
CSC171
LAB TR 0940-1055
TA Stephen Cohen
LAB08

Assignment description: Practice packaging, inheritance, overriding, abstract classes, and interfaces to implement two more advanced List structures.

It makes sense to define add, get, insert, and delete in the interface so that the children of AbstractItems which implement that interface will be required to provide specific implementations. 

In my test class, I passed the Lists as their direct superclass, AbstractItems, to have access to the super's toString() method. Referencing the Lists as EnhancedItems interfaces would have granted access to all of the working methods, but the toString method was important for printing the results of the interface methods.


Instructions to ** BUILD & RUN ** :
A buildscript has been provided in .bat and .sh format. 
NOTE: I haven't actually tested the .bat, but the .sh works as expected.

## TO BUILD ##
In the root dir, run:
$ ./build.sh 
or the Windows equivalent.

Examine the contents of this build script to see specific package building implementation.

A testscript has also been provided 
NOTE: Again, scripts are .bat and .sh, but only the .sh has been tested.

## TO TEST ##
In the root dir (after building), run:
$ ./test.sh
or the Windows equivalent.

Examine the contents of this test script to see specific package running implementation.

The testing class fulfills Section 9 of the Lab. Other tests were not deemed necessary as the other functionality has been testing in the previous lab.

Evan Baker
CSC171
LAB TR 0940-1055
TA Stephen Cohen
LAB06

Assignment description: Practice packaging, inheritance, overriding, abstract classes, and interfaces.

What I have learned about interfaces, abstract classes, and classes that extend or implement both:
Interfaces are classes that only define behavior. They do not provide concrete implementations of the behavior (except in Java 8, where there interfaces can have static methods - though this causes multiple inheritance problems). Abstract classes are "parent" classes. They can define behavior, but they can also provide concrete implementations of behavior (though the child is free to @Override that behavior, in which case the parent behavior is replaced, not just hidden). Classes may only extend from one parent, though they may implement multiple interfaces. In multiple interface inheritance, any method collisions are handled lazily - a single child method satisfies all of the interfaces. Classes that extend or implement can be treated as the parent or interface that they are inheriting from, and now we've arrived at polymorphism.


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

Unless a "Failed" appears, all of the test pass.


Bonus:
Both my ArrayOfItems and my ListOfItems are smart enough to not all getting out of bounds elements - I have them throwing an out of bounds exception which is caught in the tests, providing bespoke error feedback instead of the default Java feedback.
In my ArrayOfItems I used a pointer int to keep track of where in the array operations are happening.
I have used IntelliJ, so I wanted to annotate the Node#getNext() (which is a likely place to get a null return) as @Nullable so the linter would warn anyplace that it was used to do a null check, but I did the labs in a plain text editor (without a linter) and javac doesn't seem to like that annotation.
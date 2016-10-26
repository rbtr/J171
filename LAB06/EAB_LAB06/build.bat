ECHO 'Compiling \products\ package and tests...';
javac -cp src\ -d bin\ src\csc171\lab06\products\*.java;
javac -cp src\ -d bin\ src\csc171\lab06test\products\*.java;

ECHO 'Compiling \warehouse\ package and tests...';
javac -cp src\ -d bin\ src\csc171\lab06\warehouse\*.java;
javac -cp src\ -d bin\ src\csc171\lab06test\warehouse\*.java;

ECHO 'Compiling \checkers\ package and tests...';
javac -cp src\ -d bin\ src\csc171\lab06\checkers\*.java;
javac -cp src\ -d bin\ src\csc171\lab06test\checkers\*.java;
#!/bin/bash

echo 'Compiling /products/ package and tests...';
javac -cp src/ -d bin/ src/csc171/lab06/products/*.java;
javac -cp src/ -d bin/ src/csc171/lab06test/products/*.java;

echo 'Compiling /warehouse/ package and tests...';
javac -cp src/ -d bin/ src/csc171/lab06/warehouse/*.java;
javac -cp src/ -d bin/ src/csc171/lab06test/warehouse/*.java;

echo 'Compiling /checkers/ package and tests...';
javac -cp src/ -d bin/ src/csc171/lab06/checkers/*.java;
javac -cp src/ -d bin/ src/csc171/lab06test/checkers/*.java;

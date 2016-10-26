#!/bin/bash

echo 'Compiling package and tests...'
javac -cp src/ -d bin/ src/csc171/lab08/*.java
javac -cp src/ -d bin/ src/csc171/lab08/tests/*.java
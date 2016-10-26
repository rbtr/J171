#!/bin/bash

echo 'Testing package...'
echo '## TESTING NODE ##'
java -cp bin csc171.lab07.NodeTest
echo ''
echo ''

echo '## TESTING ARRAYOFITEMS ##'
java -cp bin csc171.lab07.ArrayOfItemsTest
echo ''
echo ''

echo '## TESTING LISTOFITEMS ##'
java -cp bin csc171.lab07.ListOfItemsTest
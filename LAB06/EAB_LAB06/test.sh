#!/bin/bash

echo 'Testing /products/ package...';
echo '## TESTING TOY';
echo '';
java -cp bin csc171.lab06test.products.ToyTest;

echo '## TESTING BOOK';
echo '';
java -cp bin csc171.lab06test.products.BookTest;

echo '';
echo 'Testing /warehouse/ package...';
echo '## TESTING WAREHOUSE';
echo '';
java -cp bin csc171.lab06test.warehouse.WarehouseTest;

echo '';
echo 'Testing /checkers/ package...'
echo '## TESTING CHECKERBOARD';
echo '';
java -cp bin csc171.lab06test.checkers.CheckerboardTest;
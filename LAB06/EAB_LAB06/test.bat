ECHO 'Testing \products\ package...';
ECHO '## TESTING TOY';
ECHO '';
java -cp bin csc171.lab06test.products.ToyTest;

ECHO '## TESTING BOOK';
ECHO '';
java -cp bin csc171.lab06test.products.BookTest;

ECHO '';
ECHO 'Testing \warehouse\ package...';
ECHO '## TESTING WAREHOUSE';
ECHO '';
java -cp bin csc171.lab06test.warehouse.WarehouseTest;

ECHO '';
ECHO 'Testing \checkers\ package...'
ECHO '## TESTING CHECKERBOARD';
ECHO '';
java -cp bin csc171.lab06test.checkers.CheckerboardTest;
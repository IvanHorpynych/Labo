
module('Varaibles');

test('Defining a variable', function() {
  var x; // define a variable named x

  equal(__, x, 'What is the default value for variable?');
});

test('Assignment operator', function() {
  var x = 5;

  equal(__, x, 'What value will variable x hold?');
});

test('Defining multiple variables', function() {
  var z, y = x = 5;

  equal(__, x, 'What value will variable x hold?');
  equal(__, y, 'What value will variable y hold?');
  equal(__, z, 'What value will variable z hold?');
});

test('Reassignment', function() {
  var x = 5;

  // You can freely reassign values to variables
  x = 10;

  equal(__, x, 'What value will variable x hold?');
});

test('Multiple assignment', function() {
  var x = 5, y = 10, z = 20;

  x = y = z = 42;

  equal(__, y, 'What value will variable y hold?');
  equal(__, x == y, 'Are all of the variables equal?');
  equal(__, y == z, 'Are all of the variables equal?');
});

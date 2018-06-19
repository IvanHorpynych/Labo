
module('Numbers');

test('Math operators', function() {
  var a = 10, b = 2;

  equal(__, (a + b), 'Use + to add numbers');

  equal(__, (a - b), 'Use - to subtract');

  equal(__, (a * b), 'Use * to multiply');

  equal(__, (a / b), 'Use / to divide');

  equal(__, (a % b), 'Use % (modulo) to get remainder of the division');
});

test('Math assignment shortcuts', function() {
  var a = b = 10;

  // Shortcut assignment are more concise
  // They are avalible for every math operator

  a = a + 5;
  b += 5;

  equal(__, a == b, 'Will a and b be equal?');
});

test('Floating-point numbers', function() {
  var a = 5, b = 5.0;

  equal(__, a == b, 'Will a and b be equal?');
  equal(__, (typeof a) == (typeof b), 'Do a and b have same type?');
});

test('Different bases', function() {
  var a = 15, b = 0xF;

  equal(__, a == b, 'Will a and b be equal?');
  equal(__, (typeof a) == (typeof b), 'Do a and b have same type?');
});

test('Division by zero', function() {
  var divisionByZero = 42 / 0;
  var negativeDivisionByZero = -42 / 0;

  equal(__, divisionByZero, 'What happens when you divide by zero?');
  equal(__, negativeDivisionByZero, 'What if a negative number is divided?');
  equal(__, typeof divisionByZero, 'Is result still considered a number?');
});

test('Failed operations', function() {
  var divisionByString = 42 / 'apple';
  var anotherDivisionByString = 451 / 'farenheit';

  equal(__, isNaN(divisionByString), 'What happens when you attempt to divide by string?');
  equal(__, typeof divisionByString, 'Is result still considered a number?');
  equal(__, divisionByString == anotherDivisionByString, 'Are NaNs equal?');
});

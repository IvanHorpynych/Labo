
module('Type casting');

test('Converting to Number', function() {
  var convertedNumber = Number('42');
  var conversionShortcut = +'42'; // it is considered bad practice
  var conversionAttempt = Number('10 apples');

  equal(__, convertedNumber, 'What is the result of type casting?');
  equal(__, convertedNumber === conversionShortcut, 'Will conversion results match?');
  equal(__, isNaN(conversionAttempt), 'What happens when you attempt to convert a string that doesn\'t look like integer?');
});

test('parseInt() and parseFloat()', function() {
  var parsedNumber = parseInt('42');
  var parsedFromBeginning = parseInt('10 apples');
  var parsedFromEnd = parseInt('apples 10');
  var parsedFloat = parseFloat('5.2');

  equal(__, parsedNumber, 'What is the result of parsing?');
  equal(__, parsedFromBeginning, 'What is the result of parsing?');
  equal(__, isNaN(parsedFromEnd), 'What is the result of parsing?');
  equal(__, parsedFloat, 'What is the result of parsing?');
});

test('How booleans are converted to numbers', function() {
  equal(__, Number(true), 'What is the result of conversion?');
  equal(__, Number(false), 'What is the result of conversion?');
});

test('Converting to String', function() {
  var convertedString = String(42);
  var conversionShortcut = 42 + ''; // considered bad practice

  equal(__, convertedString, 'What is the result of type casting?');
  equal(__, convertedString === conversionShortcut, 'Will conversion results match?');
});

test('String representations', function() {
  equal(__, String(true), 'What is the result of type casting?');
  equal(__, String({}), 'What is the result of type casting?');

  // This uses .toString() method internally

  equal(__, String(true) == (true).toString(), 'Will conversion results match?');
});

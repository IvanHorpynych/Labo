
module('Boolean logic');

test('Boolean literals', function() {
  equal(__, typeof true, 'What is the type of true?');
  equal(__, typeof false, 'What is the type of false?');
});

test('Negation operator', function() {
  equal(__, !true, 'What happens when true is negated?');
  equal(__, !false, 'What happens when false is negated?');
});

test('Conjunction operator', function() {
  equal(__, false && false, 'What is the result of this expression?');
  equal(__, false && true, 'What is the result of this expression?');
  equal(__, true && true, 'What is the result of this expression?');
});

test('Disjunction operator', function() {
  equal(__, false || false, 'What is the result of this expression?');
  equal(__, false || true, 'What is the result of this expression?');
  equal(__, true || true, 'What is the result of this expression?');
});

test('Converting a value to boolean', function() {
  var convertedBoolean = Boolean('string');
  var conversionShortcut = !!'string;'

  equal(__, typeof convertedBoolean, 'What is the type of convertedBoolean?');
  equal(__, convertedBoolean === conversionShortcut, 'Are the results of different conversion methods equal?');
});

test('Truthiness and falseness', function() {
  equal(__, Boolean(0), 'Is 0 truthy?');
  equal(__, Boolean(42), 'Are positive numbers truthy?');
  equal(__, Boolean(-42), 'Are negative numbers truthy?');

  equal(__, Boolean(''), 'Is an empty string truthy?');
  equal(__, Boolean('string'), 'Is non-empty string truthy?');

  equal(__, Boolean(null), 'Is null truthy?');
  equal(__, Boolean(undefined), 'Is undefined truthy?');

  equal(__, Boolean([]), 'Is array truthy?');
  equal(__, Boolean({}), 'Is object truthy?');
});

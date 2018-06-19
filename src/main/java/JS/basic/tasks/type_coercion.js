
module('Type coercion');

// Implicit conversion may happen under some circumstances:

test('Adding different types', function() {
  equal(__, '4' + 2, 'What is the result of adding number to string?');
  equal(__, ('4' + 2) === (4 + '2'), 'Does the order of types matter?');

  equal(__, 41 + true, 'What will the result be?');
});

test('Subtracting different types', function() {
  equal(__, '4' - 2, 'What is the result of subtracting number from string?');
  equal(__, ('4' - 2) === (4 - '2'), 'Does the order of types matter?');

  equal(__, isNaN('10 apples' - 10), 'Will the number be parsed correctly?');

  equal(__, 41 - false, 'What will the result be?');
});

test('Comparing different types', function() {
  equal(__, 2 == '2', 'What is the result of comparsion?');
  equal(__, 2 === '2', 'What is the result of strict comparsion?');
});

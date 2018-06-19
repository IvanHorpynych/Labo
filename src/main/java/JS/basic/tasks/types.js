
module('Types');

test('Main types', function() {
  // There are 5 main types in JavaScript
  // use typeof keyword to get the type of expression

  equal(__, typeof 1, 'What is the type of this expression?');
  equal(__, typeof 'string', 'What is the type of this expression?');
  equal(__, typeof true, 'What is the type of this expression?');
  equal(__, typeof undefined, 'What is the type of this expression?');
  equal(__, typeof {}, 'What is the type of this expression?');
});

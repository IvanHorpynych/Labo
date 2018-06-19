
module('Strings');

test('Literals', function() {
  var singleQuotedString = 'apple';
  var doubleQuotedString = "apple";

  equal(__, singleQuotedString === doubleQuotedString, 'Are the two strings equal?');
});

test('Concatenation', function() {
  var fruit = 'apple';
  var dish = 'pie';

  equal(__, fruit + " " + dish, 'What is the value of fruit + " " + dish?');
});

test('Escape sequence', function() {
  var stringWithAnEscapedCharacter  = '\u0041pple';
  equal('__', stringWithAnEscapedCharacter, 'What is the value of stringWithAnEscapedCharacter?');
});

test('String length', function() {
  var fruit = 'apple';
  equal(__, fruit.length, 'What is the value of fruit.length?');
});

test('Slice', function() {
  var dish = 'apple pie';
  equal(__, dish.slice(0,5), 'What is the value of fruit.slice(0,5)?');
});

test('Characters', function() {
  var fruit = 'apple';

  equal(__, fruit[0], 'What is the value of fruit[0]?');
  equal(__, fruit[0] == fruit.charAt(0), 'Are they equal?');
  equal(__, typeof fruit[0], 'Do single characters have a specific type?');
})

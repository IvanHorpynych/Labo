module('Arrays');

test('Array literal syntax and indexing', function() {
  var favouriteThings = ['cellar door', 42, true]; // note that array elements do not have to be of the same type
  equal(__, favouriteThings[0], 'What is in the first position of the array?');
  equal(__, favouriteThings[1], 'What is in the second position of the array?');
  equal(__, favouriteThings[2], 'What is in the third position of the array?');
});

test('Array type', function() {
  equal(__, typeof [], 'What is the type of an array?');
});

test('length', function() {
  var collection = ['a', 'b', 'c'];
  equal(__, collection.length, 'What is the length of the collection array?');
});

test('splice', function() {
  var daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
  var workingWeek = daysOfWeek.splice(__, __);
  deepEqual([__], workingWeek, 'What is the value of workingWeek?');
  deepEqual([__], daysOfWeek, 'What is the value of daysOfWeek?');
});

test('Stack methods', function() {
  var stack = [];
  stack.push('first');
  stack.push('second');

  equal(__, stack.pop(), 'What will be the first value popped off the stack?');
  equal(__, stack.pop(), 'What will be the second value popped off the stack?');
});

test('Queue methods', function() {
  var queue = [];
  queue.push('first');
  queue.push('second');
  queue.unshift('third');

  equal(__, queue.shift(), 'What will be shifted out first?');
  equal(__, queue.shift(), 'What will be shifted out second?');
});


module('About Asserts');

// Following functions are specific to qunit, test framework used in this task

test('ok', function() {
  ok(__ === true, 'What will satisfy the ok assertion?');
});

test('not ok', function() {
  ok(__ === false, 'What is a false value?');
});

test('equal', function() {
  equal(__, 1 + 1, 'What will satisfy the equal assertion?');
});

test('deepEqual', function() {
  // deepEqual compares objects and arrays
  deepEqual(__, [1, 2, 3], 'What will satisfy the deepEqual assertion?');
  deepEqual(__, {a: 1, b: { c: 3}}, 'What will satisfy the deepEqual assertion?');
});

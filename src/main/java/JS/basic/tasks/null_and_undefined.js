
module('null and undefined');

test('types', function() {
  equal(__, typeof undefined, 'What is the type of undefined?');
  equal(__, typeof null, 'What is the type of null?');
});

test('comparsion', function() {
  equal(__, null == undefined, 'Is null unstrictly equal to undefined?');
});

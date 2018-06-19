
module('Objects');

test('Object literal notation', function() {
  var person = {
    name:'Amory Blaine',
    age:102
  };

  equal(___, person.name, 'What is the person\'s name?');
  equal(___, person.age, 'What is the person\'s age?');
});

test('Dynamically adding properties', function() {
  var person = {};
  person.name = 'Amory Blaine';
  person.age = 102;
  equal(___, person.name, 'What is the person\'s name?');
  equal(___, person.age, 'What is the person\'s age?');
});

test('Adding properties from strings', function() {
  var person = {};
  person['name'] = 'Amory Blaine';
  person['age'] = 102;
  equal(___, person.name, 'What is the person\'s name?');
  equal(___, person.age, 'What is the person\'s age?');
});

test('Adding functions', function() {
  var person = {
    name: 'Amory Blaine',
    age: 102,
    toString: function() {
      return 'I '+ this.name+' am '+this.age+' years old.';  // HINT: use the 'this' keyword to refer to the person object.
    }
  };
  equal(___, person.toString(), 'What should the toString function be?');
});

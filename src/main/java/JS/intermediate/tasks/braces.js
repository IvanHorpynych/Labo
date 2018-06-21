
module('Braces');

/*
Write a function that validates a series of braces.
*/

function validSequence(braces) {
    var atBeginning = "";
    while (braces != atBeginning)
    {
        atBeginning = braces;
        braces = braces
            .replace('()', '')
            .replace('[]', '')
            .replace('{}', '')
            .replace('<>', '');                
    }
    return (braces.length == 0);
}

test('Simple valid cases', function() {
  equal(validSequence(''), true, 'empty string validates');
  equal(validSequence('[]'), true, 'square braces');
  equal(validSequence('()'), true, 'round braces');
  equal(validSequence('{}'), true, 'figure braces');
  equal(validSequence('<>'), true, 'brackets');
});

test('Simple invalid cases', function() {
  equal(validSequence('}'), false, 'invalid case');
  equal(validSequence('({'), false, 'invalid case');
  equal(validSequence('[<]'), false, 'invalid case');
  equal(validSequence('({)}'), false, 'invalid case');
});

test('Final cases', function() {
  equal(validSequence('([](<{}>))'), true, 'valid case');
  equal(validSequence('({[](<{}>}))'), false, 'invalid case');
});

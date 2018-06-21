
module('Adder');

function adder() {
  var sum = arguments[0];
  function aux(b){
    sum += b;
    return aux;
  }
  aux.toString = function(){return sum;}
  return aux;
}

test('adder', function() {
  equal(adder(1), 1, '1');
  equal(adder(1)(1), 2, '2');
  equal(adder(1)(10)(-2), 9, '9');
  equal(adder(10)(20)(30)(40)(50), 150, '150');
});


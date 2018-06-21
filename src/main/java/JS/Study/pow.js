/*
/!*!// ES5
var base = {b: 1};
var ancestor = {a: 2};

ancestor.__proto__ = base;
console.log(ancestor.__proto__ == base);*!/

// ES6
var base = {b: 1};
var ancestor = Object.create(base, {a: 2});
console.log(Object.getPrototypeOf(ancestor) == base);*/


/*
console.log(true === true)


var daysOfWeek = ['Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday', 'Sunday'];
console.log(daysOfWeek.splice(0, 5));
console.log(daysOfWeek);*/



var a = 15, b = 0xF;

console.log(typeof a);
console.log(typeof b);

var convertedBoolean = Boolean('string');
var conversionShortcut = !!'string;';

console.log(convertedBoolean === conversionShortcut);
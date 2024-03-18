//array
const arr = ["apple", 3.14, 1999]

console.log(arr);
console.log(arr[0]);
console.log(arr.length);

console.log(`Length: ${arr.length}`); //3
arr.push("Cherry");
console.log(`Length: ${arr.length}`); //4
console.log(arr);

const array1 = ['a', 'b', 'c'];
for(const element of array1){
    console.log(element);
}

const value = (3>4) ? "more" : "less";

const trees = ["redwood", "oak", "cedar"]

0 in trees;
3 in trees;
"bay" in trees;
"length" in trees;

const mycar = { make: "Honda", year: 2020};
"make" in mycar;
"model" in mycar;

const theDay = new Date(2023, 2, 14);
theDay instanceof Date;

//exercise solution
if (Math.PI + 1 === 3 || Math.PI + 1 === 4) {
    console.log("Error!");
  }
  
  let n=3;
  let upperBound=5;
  let lowerBound=10;
  
  let result = 0;
  if (n > upperBound || n < lowerBound) {
    result = upperBound + lowerBound;
  } else if (n < (upperBound + lowerBound) / 2) {
    result = lowerBound;
  } else {
    result = upperBound;
  }
  
  const obj = { a: 1, b: 2, c: 3 };
  for (const i in obj) {
    console.log(obj[i]);
  }
  
  const iterable = [10, 20, 30];
  for (const value in iterable) {
    console.log(value);
  }
  
  const foo = {bar:5};
  console.log(foo.bar);

  //Arrays: indexOf
  const animals = ['ant', 'bison', 'camel', 'duck', 'elephant'];
  const found = animals.indexOf('camel');
  console.log(found);

  const notFound = animals.indexOf('penguin');
  console.log(notFound);

  inc = animals.includes('camel');
  console.log(inc);
  notinc = animals.includes('penguin');
  console.log(notinc);
  
  //Arrays: slice
  const subs = animals.slice(2,4);
  console.log(subs);

  function func1(a,b){
    return a*b;
  }

  func2 = (a,b) => a * b;

  console.log(func1(3,4));
  console.log(func2(3,4));

//   const func1 = (a, b) => {
// 	if (a > b) {
//   	return a;
//   } else {
//   	return b;
//   }
//   }

// const func2 = (a, b, c) => {
// 	return func1(func1(a, b), func1(b, c));
// }

// const func3 = (func, a, b) => {
// 	const n = func(a, b);
//   return n;
// }

const func4 = (a,b) => (a>b) ? a:b;

const func5 = (a, b, c) => func1(func1(a, b), func1(b, c));

const func6 = (func, a, b) => n = func(a,b);


console.log(func4(3, 5)); // Expected Result: 5
console.log(func5(7, 11, 8)); // Expected Result: 11
console.log(func6(func1, 8, 23)); // Expected Result: 23

//Arrays: sort
const months = ['March', 'April', 'December', 'January'];
months.sort();
console.log(months);

const wush = [1, 30, 4, 21, 10000];
wush.sort(); //sorts as strings
console.log(wush);
//sorting as integer
// Create random array with 10 elements
const arr1 = Array.from({ length: 10 }, () => Math.floor(Math.random() * 100));
console.log(arr1);

// Sort ascending
arr1.sort((a, b) => a > b);
console.log(arr1);

// Sort descending
arr1.sort((a, b) => a < b);
console.log(arr1);

//?? i dont understand this one honestly
const items = [
    { name: "Edward", value: 21 },
    { name: "Sharpe", value: 37 },
    { name: "And", value: 45 },
    { name: "The", value: -12 },
    { name: "Magnetic", value: 13 },
    { name: "Zeros", value: 37 },
  ];
  
  // sort by name
  items.sort((a, b) => {
    const nameA = a.name.toUpperCase(); // ignore upper and lowercase
    const nameB = b.name.toUpperCase(); // ignore upper and lowercase
    if (nameA < nameB) {
      return -1;
    }
    if (nameA > nameB) {
      return 1;
    }
    // names must be equal
    return 0;
  });
  
  console.log(items);

//exercise 3 = showing only odd values
  const arr2 = [1, 4, 9, 16, 25, 36, 49, 64, 81, 100];

// This is how you use Array.map() method to create a new array
// populated with the results of calling a provided function on
// every element in the calling array.
const map1 = arr2.map((x) => x ** 2);
console.log(map1);

// Create a new array `map2` populated with only the odd-value from the
// array `arr`

const map3=[];
const map2 = arr2.map((x) =>
{
if(x%2==1)
{map3.push(x);}
}
);

console.log(map3);

// See the following links for hints.
// https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/map
// https://stackoverflow.com/questions/28607451/removing-undefined-values-from-array

//Error Handling

try {
    throw new TypeError("Oops");
}
catch (e) {
    console.log(e.name); //"TypeError"
    console.log(e.message);
}

try {
    try {
        throw new Error("oops");
    }
    catch (ex) {
        console.error("inner", ex.message);
        throw ex;
    }
    finally {
        console.log("finally"); //immedieately before a control-flow statement(return, throw, break, continue) executed in the try or catch block
    }
} catch (ex){
    console.error("outer", ex.message); 
}

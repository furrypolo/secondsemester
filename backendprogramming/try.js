console.log("hello world");
let faa = 42;
console.log(faa);
let fee = 33;
console.log(faa + fee);
let d;
console.log(d); //undefined type

//type conversion
const number = 10;
const text = number.toString();
console.log(typeof(text));

//template literals
const str1= `string text`;
console.log(str1);

const str2= `string text line 1
string text line 2`;
console.log(str2);

const expression = 42;
const str3 = `string text ${expression} string text`;
console.log(str3);

const str4 = "string text `string` text 'string'";
console.log(str4);

//comparison operators
//== (loose equality) === (strict equality) != !== > >= < <=
//arithemtic operators
//+ - * / % ++ -- **
//bitwise operators
//& | ^ ~ << >> >>>
//logical operators
//&& || !

const c = "42"
const b = 42

console.log(c==b); //loose equality -> true
console.log(c===b); //strict equality -> false

//practice fixing
//case
// const a = BigInt(1.5);

// const sum = 1n + 1;

// foo.substring(1);

// const enum = "Enumerate this string";

// const str = “This looks like a string”;

// const longString = "This is a very long string which needs
//                     to wrap across multiple lines because
//                     otherwise my code is unreadable.";


//solution
const a = BigInt(15);

const sum = 1 + 1;

let foo = 'Hello World'

foo.substring();

const eNum = 'Enumerate this string';

const str = 'This looks like a string';

const longString = `This is a very long string which needs
                    to wrap across multiple lines because
                    otherwise my code is unreadable.`;

//if else
const result=5;

if(result>0){
    console.log("+");
}
else if(result<0){
    console.log("-");
}
else{
    console.log("=");
}

//conditionals:switch

const expr = "Oranges";

switch(expr){
    case "Oranges":
        console.log("Oranges");
        break;
    case "Apples":
        console.log("Apples");
        break;
    default:
        console.log("Unknown fruit");
}

//loops: for
let strit = ' ';

for(let i=0; i<9; i++){
    strit = strit+i;
}

console.log(strit);

//loops: while
let n=0;
while (n<3){
    n++;
}

console.log(n);

//loops: do...while
let resolut = '';
let i = 0;

do{
    i=i+1;
    resolut=resolut+i;
}while(i<5);

console.log(resolut);

//objects
const obj = {
    "key": "value",
    "age": 42,
};

console.log(obj.key);
console.log(obj["age"]);

obj.name = "Alex";
obj["id"] = 9981;

console.log(obj);


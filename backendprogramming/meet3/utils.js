function multiply(a, b){return a*b;}
function square(a){return a**2;}
function divide(a,b){return a/b;}
function functest(a){return a*square(a);}

module.exports = {
    multiply, divide, functest,
}; //export only u want to export. an unexported functions can still be used when its inside exported function
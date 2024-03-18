const currency = require('currency.js');

function calculateTotal(quantity, unitPrice, discountPercentage, taxPercentage) {
	const subtotal = quantity * unitPrice;
  const discount = subtotal * discountPercentage;
  const tax = (subtotal - discount) * taxPercentage;
  return subtotal - discount + tax;
}

const totalPurchase = calculateTotal(5, 2.51, 5.5, 11);
console.log("Total purchase = " + totalPurchase);

const totalPayment = 1000;
console.log("Total payment = " + totalPayment);

const change = totalPayment - totalPurchase;
console.log("Change = " + change);

currency(totalPurchase).add(.01);      

currency(change).subtract(.01); 
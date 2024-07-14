const poloRepository = require('./polo-repository');
const { hashPassword, passwordMatched } = require('../../../utils/password');
const { errorResponder, errorTypes } = require('../../../core/errors');

async function getBalance(id) {
  const user = await poloRepository.getUser(id);
  if (!user) {
    return null;
  }
  return {
    id: user.id,
    name: user.name,
    balance: user.balance,
  };
}

async function createAccount(name, email, password, pin, balance) {
  console.log('inside service');
  const hashedPassword = hashPassword(password);
  const hashedPin = hashPassword(pin);
  console.log('hashing done');
  try {
    console.log('trying');
    await poloRepository.createAccount(
      name,
      email,
      hashedPassword,
      hashedPin,
      balance
    );
  } catch (error) {
    return next(error);
  }
  console.log('done, returning');
  return true;
}

async function matchPassword(id, hashedpassword) {
  const user = await poloRepository.getUser(id);
  return passwordMatched(hashedpassword, user.password);
}

async function matchPin(id, hashedpin) {
  const user = await poloRepository.getUser(id);
  return passwordMatched(hashedpin, user.pin);
}

async function emailIsRegistered(email) {
  try {
    console.log('checking email in service');
    const user = poloRepository.findbyEmail(email);
    console.log(user);
    console.log('finding done');
    if (user) {
      return true;
    }
    return false;
  } catch (error) {
    return next(error);
  }
}

module.exports = {
  getBalance,
  createAccount,
  matchPassword,
  matchPin,
  emailIsRegistered,
};

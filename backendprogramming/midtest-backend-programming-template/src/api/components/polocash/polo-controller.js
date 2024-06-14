const poloService = require('./polo-service');
const { errorResponder, errorTypes } = require('../../../core/errors');
const { hashPassword, passwordMatched } = require('../../../utils/password');
const { User } = require('../../../models');

async function getBalance(req, res, next) {
  try {
    const id = request.params.id;
    const pin = request.body.pin;
    const hashedpin = await hashPassword(pin);
    const check = poloService.matchPin(id, hashedpin);
    if (!check) {
      throw errorResponder(errorTypes.INVALID_PASSWORD, 'Wrong pin');
    }
    const user = await poloService.getBalance(id);
    return response.status(200).json(user);
  } catch (error) {
    return next(error);
  }
}

async function createAccount(request, response, next) {
  try {
    console.log('Inside controller');
    const name = request.body.name;
    const email = request.body.email;
    const password = request.body.password;
    const confirmpassword = request.body.password_confirm;
    const pin = request.body.pin;
    const confirmpin = request.body.pin_confirm;
    const balance = request.body.balance;
    if (password != confirmpassword) {
      throw errorResponder(
        errorTypes.INVALID_PASSWORD,
        'Password confirmation mismatched'
      );
    }
    console.log('checked password');
    if (pin != confirmpin) {
      throw errorResponder(
        errorTypes.INVALID_PASSWORD,
        'Pin confirmation mismatched'
      );
    }
    console.log('pin checked');
    const findemail = poloService.emailIsRegistered(email);
    if (!findemail) {
      throw errorResponder(
        errorTypes.EMAIL_ALREADY_TAKEN,
        'Email already taken, try another one'
      );
    }
    console.log('email checked');
    const success = poloService.createAccount(
      name,
      email,
      password,
      pin,
      balance
    );
    console.log(success);

    if (!success) {
      throw errorResponder(
        errorTypes.UNPROCESSABLE_ENTITY,
        'Failed to create account'
      );
    }
    return response.status(200).json({ name, email, balance });
  } catch (error) {
    return next(error);
  }
}

module.exports = {
  getBalance,
  createAccount,
};

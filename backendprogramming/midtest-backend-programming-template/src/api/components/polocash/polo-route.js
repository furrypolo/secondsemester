const express = require('express');

const authenticationMiddleware = require('../../middlewares/authentication-middleware');
const celebrate = require('../../../core/celebrate-wrappers');
const poloControllers = require('./polo-controller');
const poloValidator = require('./polo-validator');

const route = express.Router();

module.exports = (app) => {
  app.use('/polocash', route);

  //get user balance
  route.get(
    '/:id',
    authenticationMiddleware,
    celebrate(poloValidator.getBalance),
    poloControllers.getBalance
  );

  //create new mbanking account
  route.post(
    '/',
    celebrate(poloValidator.createAccount),
    poloControllers.createAccount
  );
};

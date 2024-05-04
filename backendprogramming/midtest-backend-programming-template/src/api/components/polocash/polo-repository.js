const { polouser, User } = require('../../../models');
const { history } = require('../../../models');

async function getUser(id) {
  return polouser.findbyId(id);
}

async function createAccount(name, email, password, pin, balance) {
  let attempt = 0;
  return polouser.create({
    name,
    email,
    password,
    pin,
    balance,
    attempt,
  });
}

module.exports = {
  getUser,
  createAccount,
};

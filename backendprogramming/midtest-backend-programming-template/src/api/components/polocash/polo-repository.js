const { polouser, User } = require('../../../models');
const { history } = require('../../../models');

async function getUser(id) {
  return polouser.findbyId(id);
}

async function createAccount(name, email, password, pin, balance) {
  console.log('inside repos');
  let attempt = 0;
  const success = polouser.create({
    name,
    email,
    password,
    pin,
    balance,
    attempt,
  });
  console.log(success);
  return success.then((token) => {
    return token;
  });
}

async function findbyEmail(email) {
  console.log('finding by email in repos');
  return polouser.findOne({ email }).then((token) => {
    return token;
  });
}

module.exports = {
  getUser,
  createAccount,
  findbyEmail,
};

const { User } = require('../../../models');

/**
 * Get user by email for login information
 * @param {string} email - Email
 * @returns {Promise}
 */
async function getUserByEmail(email) {
  return User.findOne({ email });
}

async function getUser(id) {
  console.log(User.findById(id));
  return User.findById(id);
}

module.exports = {
  getUserByEmail,
  getUser,
};

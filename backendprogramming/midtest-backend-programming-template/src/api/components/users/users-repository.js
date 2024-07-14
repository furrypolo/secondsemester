const { User } = require('../../../models');
const { errorResponder, errorTypes } = require('../../../core/errors');

/**
 * Get a list of users
 * @returns {Promise}
 */
async function getUsers() {
  try {
    return User.find({});
  } catch (error) {
    return next(error);
  }
}

/**
 * Get user detail
 * @param {string} id - User ID
 * @returns {Promise}
 */
async function getUser(id) {
  return User.findById(id);
}

/**
 * Create new user
 * @param {string} name - Name
 * @param {string} email - Email
 * @param {string} password - Hashed password
 * @returns {Promise}
 */
async function createUser(name, email, password) {
  const today = new Date();
  last_attempt = today.toISOString();
  attempt = 0;
  return User.create({
    name,
    email,
    password,
    attempt,
    last_attempt,
  });
}

/**
 * Update existing user
 * @param {string} id - User ID
 * @param {string} name - Name
 * @param {string} email - Email
 * @returns {Promise}
 */
async function updateUser(id, name, email) {
  return User.updateOne(
    {
      _id: id,
    },
    {
      $set: {
        name,
        email,
      },
    }
  );
}

async function updateAttempt(id, attempt, last_attempt) {
  console.log('in the updating');
  console.log(id);
  console.log(attempt);
  console.log(last_attempt);
  return User.updateOne(
    {
      _id: id,
    },
    {
      $set: {
        attempt,
        last_attempt,
      },
    }
  ).then((token) => {
    return token;
  });
}

/**
 * Delete a user
 * @param {string} id - User ID
 * @returns {Promise}
 */
async function deleteUser(id) {
  return User.deleteOne({ _id: id });
}

/**
 * Get user by email to prevent duplicate email
 * @param {string} email - Email
 * @returns {Promise}
 */
async function getUserByEmail(email) {
  return User.findOne({ email });
}

/**
 * Update user password
 * @param {string} id - User ID
 * @param {string} password - New hashed password
 * @returns {Promise}
 */
async function changePassword(id, password) {
  return User.updateOne({ _id: id }, { $set: { password } });
}

module.exports = {
  getUsers,
  getUser,
  createUser,
  updateUser,
  updateAttempt,
  deleteUser,
  getUserByEmail,
  changePassword,
};

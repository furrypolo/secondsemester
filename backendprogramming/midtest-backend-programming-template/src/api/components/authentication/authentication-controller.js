const { errorResponder, errorTypes } = require('../../../core/errors');
const authenticationServices = require('./authentication-service');
const authenticationRepository = require('./authentication-repository');
const usersRepository = require('C:/Users/Lenovo/repos/secondsemester/backendprogramming/midtest-backend-programming-template/src/api/components/users/users-repository.js');
const { User } = require('../../../models');
const { last_attempt } = require('../../../models/users-schema');

/**
 * Handle login request
 * @param {object} request - Express request object
 * @param {object} response - Express response object
 * @param {object} next - Express route middlewares
 * @returns {object} Response object or pass an error to the next route
 */
async function login(request, response, next) {
  const { email, password } = request.body;

  try {
    const user = await authenticationRepository.getUserByEmail(email);
    const id = user.id;
    const today = new Date();
    console.log('in the lil controller');
    console.log(user.email);
    const minute = today.getMinutes() - user.last_attempt.getMinutes();
    console.log(minute);
    console.log(user.attempt);
    if (
      user.attempt < 5 ||
      user.last_attempt.getYear() < today.getYear() ||
      user.last_attempt.getMonth() < today.getMonth() ||
      user.last_attempt.getDate() < today.getDate() ||
      minute >= 30 ||
      (minute <= 0 && minute >= -30)
    ) {
      const loginSuccess = await authenticationServices.checkLoginCredentials(
        email,
        password
      );
      if (user.attempt == 5) {
        const attempt = (user.attempt = 0);
        usersRepository.updateAttempt(id, attempt, today);
      }
      if (!loginSuccess) {
        const attempt = user.attempt + 1;
        console.log(attempt);
        usersRepository.updateAttempt(id, attempt, today);
        if (attempt == 5) {
          throw errorResponder(
            errorTypes.INVALID_CREDENTIALS,
            'Wrong email or password, limit reached'
          );
        } else {
          throw errorResponder(
            errorTypes.INVALID_CREDENTIALS,
            'Wrong email or password'
          );
        }
      } else {
        console.log('looking at the attempt');
        console.log('in the date thingy');
        let last_attempt = today.toISOString();
        let attempt = 0;
        console.log(last_attempt);
        fin = await usersRepository.updateAttempt(id, attempt, last_attempt);
        console.log(fin);
      }
      return response.status(200).json(loginSuccess);
    } else {
      throw errorResponder(errorTypes.FORBIDDEN, 'Too many attempts');
    }

    // Check login credentials
  } catch (error) {
    return next(error);
  }
}

module.exports = {
  login,
};

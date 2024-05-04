module.exports = {
  getBalance: {
    body: {
      name: joi.string().min(1).max(100).required().label('Name'),
      pin: joiPassword.number().min(6).max(6).required().label('Pin'),
    },
  },

  createAccount: {
    body: {
      name: joi.string().min(1).max(100).required().label('Name'),
      email: joi.string().email().required().label('Email'),
      password: joiPassword
        .string()
        .minOfSpecialCharacters(1)
        .minOfLowercase(1)
        .minOfUppercase(1)
        .minOfNumeric(1)
        .noWhiteSpaces()
        .onlyLatinCharacters()
        .min(6)
        .max(12)
        .required()
        .label('Password'),
      password_confirm: joi.string().required().label('Password confirmation'),
      pin: joiPassword.number().min(6).max(6).required().label('Pin'),
      pin_confirm: joi.number().required().label('Pin confirmation'),
    },
  },
};

const usersSchema = {
  name: String,
  email: String,
  password: String,
  attempt: Number,
  last_attempt: Date,
};

const polousersSchema = {
  name: String,
  password: String,
  pin: Number,
  balance: Number,
  attempt: Number,
};

const historySchema = {
  type: String,
  total: Number,
  from_to: String,
};

module.exports = usersSchema;

const mongoose = require('mongoose');
mongoose.connect('mongodb://localhost:27017/')

const db = mongoose.connection
db.once('open', () => {
    console.log('connected to MongoDB')
})

module.exports = mongoose.connection
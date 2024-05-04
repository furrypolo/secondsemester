const mongoose = require('mongoose');
const db = require("./db.js")

const memberSchema = mongoose.Schema({
    name: String,
    email: String,
    credit: Number,
});

const Member = mongoose.model("Member", memberSchema);

const member = new Member({
    name: 'Stacy',
    email: 'Stacy@gmail.com',
    credit: '171800',
})
member
    .save()
    .then((savedMember) => {
        console.log('Data member berhasil disimpan:', savedMember)
    })
    .catch((error) => {
        console.error('Terjadi kesalahan saat menyimpan data member:', error)
    })

    function fetchMembers(){
        Member.find({})
            .then((members) => {
                console.log('Daftar semua member:', members)

                return Member.find({name: 'Greg' })
            })

            .then((greg) => {
                console.log('Data Greg:',greg)

                return Member.find({name: 'Stacy', credit: {$gte: 100000}})
            })
    }
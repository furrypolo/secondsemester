const express = require('express');
const app = express();
const port = 3000;

app.get('/', (req, res)=>{
    res.send('apasih brenda');
});

app.listen(port, () => {
    console.log(`App listening on port ${port}`);
});

// //request param
// app.get('/:id', (req, res) => {
//     console.log(req.params.id);
// });

// app.get('/users/:id/:user_id', (req, res) => {
//     console.log(req.params.id);
//     console.log(req.params.user_id);
// })

//http://localhost:3000/users?id=123&username=test

//request query
app.get(
    '/users',
    (req, res) => {
        const id = req.query.id;
        const username = req.query.username;

        res.send(`id: ${id}; username: ${username}`);
    },
)

// //Sending JSON Response
// //Get list of users
// route.get('/', (request, response) =>{
//     const users = [{
//         id: '1',
//         username: 'admin',
//         fullname: 'Administrator',
//     },{
//         id: '2',
//         username: 'user001',
//         fullname: 'User 001',
//     }];
//     return response.status(200).json(users);
// })
// const fs = require('fs'); //import library to read files

// try{
//     const stats = fs.statSync('./test.txt'); //. means the folder we're in, / means directory
//     console.log(stats);
// } catch(err){
//     console.log(err);
// }

// const http = require('http');
// const hostname = '127.0.0.1'; // or localhost
// const port = 2519; //kalo gaada ga jalan, kalo portnya lagi kepake juga misal run trus run lagi sebelum brenti, dia gabisa jalan
// //bebas angkanya selama ga kepake sama system kita sendiri

// const server = http.createServer((req, res) => {
//   res.statusCode = 200; //200 means okay, 404 something, 500 something
//   res.setHeader('Content-Type', 'text/plain');
//   res.end('Hello World\n');
// });

// server.listen(port, hostname, () => {
//   console.log(`Server running at http://${hostname}:${port}/`);
// });

const http = require('http');

const routes = {
  '/info': '<h1>Info Page</h1>', //different page for different directory url
  '/about': '<h1>Learn More About Us</h1>',
  '/contact': '<h1>Contact Us</h1>',
};

const port = 3000;
const app = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/html');

  if (routes[req.url]) {
    res.end(routes[req.url]);
  } else {
    res.end('<h1>Welcome!</h1>');
  }
});

app.listen(port);
console.log(`Server running on port number: ${port}`);

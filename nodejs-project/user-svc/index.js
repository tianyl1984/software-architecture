const http = require('http');
const url = require('url');
const os = require('os');
const echoClient = require('./echo_client');

const port = 3002;

const server = http.createServer((req, resp) => {
    let data = '';
    req.addListener('data', (chunk) => {
        data += chunk;
    });
    req.addListener('end', async () => {
        const result = {};
        result.host = os.hostname();
        result.echo = await echoClient.echo('abcd');
        resp.writeHead(200, { 'Content-Type': 'application/json' });
        resp.end(JSON.stringify(result));
    });
}).listen(port);

server.on('error', err => {
    console.error('出错', err);
});

server.on('listening', () => {
    console.log('listening');
});

console.log(`start...${port}`);

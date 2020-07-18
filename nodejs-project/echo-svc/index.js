const http = require('http');
const url = require('url');
const os = require('os');

const port = 3001;

const server = http.createServer((req, resp) => {
    console.log(`remote ip:${req.connection.remoteAddress}`);
    console.log(req.url);
    console.log(req.method);
    console.log(req.headers);
    // console.log(`${req.headers['x-forwarded-for']}`);
    let data = '';
    req.addListener('data', (chunk) => {
        data += chunk;
    });
    req.addListener('end', () => {
        const urlObj = url.parse(req.url, true);
        const query = urlObj.query;
        const result = {};
        if (query && query.msg) {
            result.msg = query.msg.toUpperCase();
        }
        result.host = os.hostname();
        result.ip = getIp();
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

function getIp(){
    const interfaces = os.networkInterfaces();
    const ips = [];
    for (const key in interfaces) {
        interfaces[key].forEach(function(detail){
            if (detail.family === 'IPv4') {
                ips.push(`${key}:${detail.address}`);
            }
        });
    }
    return ips.join(',');
}

console.log(`start...${port}`);

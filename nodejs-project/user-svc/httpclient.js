const https = require('https');
const http = require('http');

function _getClient(url) {
    return url.startsWith('https://') ? https : http;
}

function _get(url) {
    return new Promise((resolve, reject) => {
        _getClient(url).get(url, (resp) => {
            let data = '';
            resp.on('data', (chunk) => {
                data += chunk;
            });
            resp.on('end', () => {
                resolve(data);
            });
        }).on('error', (err) => {
            console.error(err);
            reject(err);
        });
    });
}

module.exports = {
    get: _get
};

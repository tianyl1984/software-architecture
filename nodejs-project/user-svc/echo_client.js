const httpclient = require('./httpclient');

async function _echo(str) {
    if (!str) { str = ''};
    const url = `http://echo-service.default.svc.cluster.local/echo?msg=${str}`;
    try {
        const resp = await httpclient.get(url);
        console.log(resp);
        return JSON.parse(resp);
    } catch (e) {
        console.log(e);
        return {error : e.toString()};
    }
}

module.exports = {
    echo: _echo
};

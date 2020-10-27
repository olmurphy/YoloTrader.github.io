// Please see documentation at https://docs.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

// Write your Javascript code.






const socket = new WebSocket('wss://ws.finnhub.io?token=bto7e0f48v6vfu04ub10');

// Connection opened, Subscribe

socket.addEventListener('open', function (event) {
    socket.send(JSON.stringify({ 'type': 'subscribe', 'symbol': 'TSLA' }))
    socket.send(JSON.stringify({ 'type': 'subscribe', 'symbol': 'BINANCE:BTC/USD' }))
    //socket.send(JSON.stringify({ 'type': 'subscribe', 'symbol': 'IC MARKETS:1' }))
});

// Listen for messages
socket.addEventListener('message', function (event) {
    console.log('Message from server ', event.data);
});

// Unsubscribe
var unsubscribe = function (symbol) {
    socket.send(JSON.stringify({ 'type': 'unsubscribe', 'symbol': symbol }))

}


curl - X GET https://api.stocktwits.com/api/2/search.json?access_token=<access_token> 'q=stocktwits'


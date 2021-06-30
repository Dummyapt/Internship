window.onload = function() {
    $('#products').load("productList");
};
setInterval(function() {
    $('#products').load("productList");
}, 30_000);
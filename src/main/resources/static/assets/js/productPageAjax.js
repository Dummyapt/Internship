$('#orderModal').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget);

    const productId = button.data('product-id'),
        productCurrentPrice = button.data('product-current-price'),
        productName = button.data('product-name'),
        productCommodity = button.data('product-commodity'),
        productPower = parseFloat($(".valueInput" + productId).val()).toFixed(2),
        productPrice = productCurrentPrice * productPower,
        productCustomer = button.data('customer');

    $('#productId').text(productId);
    $('#productCurrentPrice').text(productCurrentPrice);
    $('#productName').text(productName);
    $('#productCommodity').text(productCommodity);
    $('#productPower').text(productPower);
    $('#productPrice').text(parseFloat(productPrice).toFixed(2));
    $('#customer').text(productCustomer)
});

$("#confirmOrder").on("click", function(e) {
    e.preventDefault();

    $.ajax({
        type: "POST",
        url: "/confirmOrder",
        data: {
            "id" : $('#productId').text(),
            "power" : $('#productPower').text(),
            "cost" : $('#productPrice').text(),
            "user" : $('#customer').text()
        },

        success: async function() {
            $('#orderConfirmation').load("orderSuccess");
            await new Promise(r => setTimeout(r, 2_000));
            $('#cancelOrder').click();
            await new Promise(r => setTimeout(r, 500));
            location.reload();
        },

        error: async function() {
            $('#orderConfirmation').load("orderError");
            await new Promise(r => setTimeout(r, 2_000));
            $('#cancelOrder').click();
            await new Promise(r => setTimeout(r, 500));
            location.reload();
        }
    })
});
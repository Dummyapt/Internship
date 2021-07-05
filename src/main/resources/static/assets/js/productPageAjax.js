$('#orderModal').on('show.bs.modal', function (event) {
    const button = $(event.relatedTarget);

    const productId = button.data('productid');
    const productCurrentPrice = button.data('productcurrentprice');
    const productName = button.data('productname');
    const productCommodity = button.data('productcommodity');
    const productPower = $(".valueInput" + productId).val();
    const productPrice = productCurrentPrice * productPower;
    const productCustomer = button.data('customer');

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
let ctx = $('#chart');
let arr = [
    $('#1').text(),
    $('#2').text(),
    $('#3').text(),
    $('#4').text(),
    $('#5').text(),
    $('#6').text()
];

new Chart(ctx, {
    type: 'bar',
    data: {
        labels: ['Peak', 'Spot', 'Flex (Gas)', 'Time', 'Flex (Electricity)', 'Solid'],
        datasets: [{
            label: '# of Orders',
            data: arr,
            backgroundColor: [
                'rgba(246,98,129,0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)'
            ],
            borderColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 1
        }]
    },

    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
window.onload = function() {
    fetchPayments();
};

function fetchPayments() {
    fetch('/api/payments/all')
        .then(response => response.json())
        .then(data => {
            populateTable(data);
        })
        .catch(error => {
            console.error('Error fetching payments:', error);
        });
}

function populateTable(payments) {
    var tableBody = document.getElementById('tableBody');

    payments.forEach(function(payment) {
        var row = document.createElement('tr');
        row.innerHTML = `
            <td>${payment.id}</td>
            <td>${payment.time}</td>
            <td>${payment.placeName}</td>
            <td>${payment.category}</td>
            <td>${payment.price}</td>
        `;
        tableBody.appendChild(row);
    });

    // 테이블 행 클릭 이벤트 핸들러 등록
    var tableRows = document.querySelectorAll("#paymentsTable tbody tr");
    tableRows.forEach(function(row) {
        row.addEventListener("click", rowClickHandler);
    });
}


function rowClickHandler(event) {
    var clickedRow = event.currentTarget;
    toggleRowColor(clickedRow);
}


function toggleRowColor(row) {
    row.classList.toggle("selected");
}
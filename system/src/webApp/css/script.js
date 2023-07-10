document.getElementById("invoice-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission

  // Retrieve form values
  var invoiceNumber = document.getElementById("invoice-number").value;
  var date = document.getElementById("date").value;
  var customerName = document.getElementById("customer-name").value;
  var items = document.getElementById("items").value;
  var subtotal = document.getElementById("subtotal").value;
  var tax = document.getElementById("tax").value;
  var total = document.getElementById("total").value;

  // Generate invoice output
  var invoiceOutput = `Invoice Number: ${invoiceNumber}
Date: ${date}

Customer Name: ${customerName}

Items:
${items}

Subtotal: $${subtotal}
Tax: $${tax}
Total: $${total}`;

  // Display the generated invoice output
  var invoiceOutputContainer = document.createElement("div");
  invoiceOutputContainer.classList.add("invoice-output");
  invoiceOutputContainer.textContent = invoiceOutput;
  document.body.appendChild(invoiceOutputContainer);
});
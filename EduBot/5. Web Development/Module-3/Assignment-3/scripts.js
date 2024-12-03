// Function to display an alert message when index.html page loads
window.onload = function() {
    alert("Welcome to my website!");
};

// Function to log "Page loaded" to the console when the page is fully loaded
document.addEventListener("DOMContentLoaded", function() {
    console.log("Page loaded");
});

// Function to generate a random color
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

// Event listener for the button click
document.getElementById("changeColorButton").addEventListener("click", function() {
    var paragraph = document.getElementById("changeText");
    paragraph.style.color = getRandomColor();
});

// DOM Manipulation
document.addEventListener("DOMContentLoaded", function() {
    const changeTextButton = document.getElementById("changeTextButton");
    const paragraph = document.getElementById("dynamicParagraph");

    changeTextButton.addEventListener("click", function() {
        paragraph.textContent = "New Text";
    });
});

// Event Handling
document.addEventListener("DOMContentLoaded", function() {
    const addButton = document.getElementById("addButton");
    const aboutList = document.getElementById("aboutList");

    addButton.addEventListener("click", function() {
        const newItem = document.createElement("li");
        newItem.textContent = "New Item";
        aboutList.appendChild(newItem);
    });
});

// Event listener for form submission
document.addEventListener("DOMContentLoaded", function() {
    const contactForm = document.getElementById("contactForm");
    const contactSubmitButton = document.getElementById("contactSubmitButton");

    contactForm.addEventListener("submit", function(event) {
        if (event.submitter === contactSubmitButton) {
            const fullName = document.getElementById("fullName").value.trim();
            const email = document.getElementById("email").value.trim();
            const message = document.getElementById("message").value.trim();

            // Check if any field is empty
            if (fullName === "" || email === "" || message === "") {
                alert("Please fill in all fields.");
                event.preventDefault(); // Prevent form submission
            }
        }
    });
});

// Functions and Scope
function calculateAverage(numbers) {
    const sum = numbers.reduce((total, num) => total + num, 0);
    return sum / numbers.length;
}

document.addEventListener("DOMContentLoaded", function() {
    const numbers = [10, 20, 30, 40, 50];
    const average = calculateAverage(numbers);
    const resultElement = document.getElementById("averageResult");
    resultElement.textContent = "Average: " + average;
});

(function() {
    const currentDate = new Date();
    const footerElement = document.getElementById("footer");
    footerElement.textContent = "Current Date and Time: " + currentDate.toLocaleString();
})();

// Arrow Functions and Higher-Order Functions
document.addEventListener("DOMContentLoaded", function() {
    const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];

    const evenNumbers = numbers.filter(num => num % 2 === 0);
    const evenNumbersList = document.getElementById("evenNumbersList");
    evenNumbersList.textContent = "Even Numbers: " + evenNumbers.join(", ");
});

document.addEventListener("DOMContentLoaded", function() {
    const numbers = [1, 2, 3, 4, 5];

    function square(num) {
        return num * num;
    }

    function applyFunctionToElements(callback, arr) {
        return arr.map(callback);
    }

    const squaredNumbers = applyFunctionToElements(square, numbers);
    const squaredNumbersList = document.getElementById("squaredNumbersList");
    squaredNumbersList.textContent = "Squared Numbers: " + squaredNumbers.join(", ");
});

// Local Storage
document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("contactForm");

    form.addEventListener("submit", function(event) {
        const fullName = document.getElementById("fullName").value;
        const email = document.getElementById("email").value;
        const message = document.getElementById("message").value;

        localStorage.setItem("fullName", fullName);
        localStorage.setItem("email", email);
        localStorage.setItem("message", message);
    });

    const storedFullName = localStorage.getItem("fullName");
    const storedEmail = localStorage.getItem("email");
    const storedMessage = localStorage.getItem("message");

    const fullNameInput = document.getElementById("fullName");
    const emailInput = document.getElementById("email");
    const messageInput = document.getElementById("message");

    fullNameInput.value = storedFullName || "";
    emailInput.value = storedEmail || "";
    messageInput.value = storedMessage || "";
});

// Session Storage
document.addEventListener("DOMContentLoaded", function() {
    sessionStorage.setItem("sessionInfo", "User session information");
    const sessionInfo = sessionStorage.getItem("sessionInfo");
    const sessionInfoElement = document.getElementById("sessionInfo");
    sessionInfoElement.textContent = sessionInfo;
});

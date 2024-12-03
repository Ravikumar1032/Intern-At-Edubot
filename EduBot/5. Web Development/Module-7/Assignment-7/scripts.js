document.addEventListener('DOMContentLoaded', () => {
    fetchData();

    const form = document.getElementById('contactForm');
    if (form) {
        form.addEventListener('submit', handleFormSubmit);
    }
});

function fetchData() {
    const xhr = new XMLHttpRequest();
    xhr.open('GET', 'data.json', true);
    xhr.onload = function () {
        if (this.status === 200) {
            const data = JSON.parse(this.responseText, reviverFunction);
            displayData(data);
        }
    };
    xhr.send();
}

function reviverFunction(key, value) {
    // Modify data as needed
    if (key === 'score') {
        return value + 5; // example modification
    }
    return value;
}

function displayData(data) {
    const contentDiv = document.getElementById('content');
    if (contentDiv) {
        // Handle nested JSON objects
        contentDiv.innerHTML = generateHTML(data);
    }
}

function generateHTML(data) {
    let html = '<ul>';
    for (const key in data) {
        if (typeof data[key] === 'object') {
            html += `<li>${key}: ${generateHTML(data[key])}</li>`;
        } else {
            html += `<li>${key}: ${data[key]}</li>`;
        }
    }
    html += '</ul>';
    return html;
}

function handleFormSubmit(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const jsonObject = {};
    formData.forEach((value, key) => {
        jsonObject[key] = value;
    });

    const jsonString = JSON.stringify(jsonObject, replacerFunction, 2);
    console.log('Form Data as JSON:', jsonString);
}

function replacerFunction(key, value) {
    // Filter or modify data before sending it
    if (key === 'email' && !value.includes('@')) {
        return undefined; // example filter
    }
    return value;
}

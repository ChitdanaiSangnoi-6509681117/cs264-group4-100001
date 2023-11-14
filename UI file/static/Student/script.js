function login() {
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    const requestData = {
        'UserName': username,
        'PassWord': password
    };

    const headers = {
        'Content-Type': 'application/json',
        'Application-Key': 'TUd51dd72f117b8e57c8ec711c23de8603cef65bc4c3b728c192db6edc36e36d3f738ab23131b9f7e0507ce384f881e0cb'
    };

    fetch('https://restapi.tu.ac.th/api/v1/auth/Ad/verify', {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(requestData)
    })
    .then(response => {
        if (response.status === 200) {
            return response.text();
        } else {
            throw new Error('Non-200 status code: ' + response.status);
        }
    })
    .then(text => {
        console.log('Response Text:', text); // Log the response text for debugging
        return JSON.parse(text);
    })
    .then(data => {
        if (data.status === true) {
            console.log(JSON.stringify(data));
            alert('Authentication successful 4!');
            if (data.type == 'student') {
                console.log('Save Student data ' + data.username);
                saveStudentData(reorderJSON(data));
                window.location.href='student_welcome.html';
            }
        } else {
            alert('Authentication failed. Please check your credentials.');
        }
    })
    .catch(error => {
        console.error('API request error:', error);
    });
}

function reorderJSON(input) {
    return {
        "userName": input.username,
        "statusid": input.statusid,
        "statusname": input.tu_status,
        //"prefixname": "Mr",
        "displayname_th": input.displayname_th,
        "displayname_en": input.displayname_en,
        "email": input.email,
        "department": input.department,
        "faculty": input.faculty
    };
}

function saveStudentData(requestData) {
    const headers = {
        'Content-Type': 'application/json',
    };

    fetch('http://localhost:8080/api/saveStudent', {
        method: 'POST',
        headers: headers,
        body: JSON.stringify(requestData)
    })
    .then(response => {
        if (response.status === 200) {
            return response.text();
        } else {
            throw new Error('Non-200 status code: ' + response.status);
        }
    })
    .then(text => {
        console.log('Response Text:', text); // Log the response text for debugging
        return JSON.stringify(text);
    })
    .then(data => {
        console.log(data);

    })
    .catch(error => {
        console.error('API request error:', error);
    });
}

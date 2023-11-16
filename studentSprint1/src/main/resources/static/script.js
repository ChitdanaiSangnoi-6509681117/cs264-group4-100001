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
            alert('Authentication successful!');
            if (data.type == 'student') {
                console.log('Save Student data ' + data.username);
                saveStudentData(reorderJSON(data));
                //nextPage();
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

function checkStudentExistence(username) {
    return fetch(`http://localhost:8080/api/findStudentId?username=${username}`)
        .then(response => {
            if (response.ok) {
                return response.json();
            } else {
                throw new Error('Network response was not ok.');
            }
        })
        .catch(error => {
            console.error('Error checking student existence:', error);
        });
}

function saveStudentData(requestData) {
    const headers = {
        'Content-Type': 'application/json',
    };

    console.log("requestData.userName = "+requestData.userName);
    // Check if the student already exists
    checkStudentExistence(requestData.userName)
        .then(existingStudentData => {
            console.log("THE FINAL DATA IS :"+JSON.stringify(existingStudentData));
            if (!existingStudentData || Object.keys(existingStudentData).length === 0) {
                // Student with the given username doesn't exist, proceed to save data
                fetch('http://localhost:8080/api/saveStudent', {
                    method: 'POST',
                    headers: headers,
                    body: JSON.stringify(requestData)
                })
                .then(response => {
                    if (response.ok) {
                        return requestData;
                    } else {
                        throw new Error('Non-200 status code: ' + response.status);
                    }
                })
                .then(data => {
                    console.log('Response Data:', data); // Log the response data for debugging
                    localStorage.setItem('studentData', JSON.stringify(data)); // Save data to localStorage
                    nextPage();
                })
                .catch(error => {
                    console.error('API request error:', error);
                });
            } else {
                // Student already exists, do something (you can handle this case as needed)
                console.log('Student already exists:', (JSON.stringify(requestData)));
                // For example, you can store the existing data or perform other actions
                localStorage.setItem('studentData', JSON.stringify(requestData));
                nextPage();
            }
        });
}
function nextPage(){
    window.location.href = 'student_welcome.html';
}
const loginForm = document.getElementById("login-form");
const loginButton = document.getElementById("login-form-submit");
const loginErrorMsg = document.getElementById("login-error-msg");

loginButton.addEventListener("click", (e) => {
    e.preventDefault();
    const email = loginForm.email.value;
    const pass = loginForm.password.value;
	const obj = { email: email, password: pass };

	const data = Object.assign(obj);
	console.log(data);
	
    var json = JSON.stringify(data);

    var xhr = new XMLHttpRequest();
	const url='http://localhost:8082/api/user/login';
    xhr.open("POST", url);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(json);
    
})
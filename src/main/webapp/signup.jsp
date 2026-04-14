<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Signup</title>

<style>
body {
    font-family: Arial;
    background: linear-gradient(135deg, #43cea2, #185a9d);
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    background: white;
    padding: 30px;
    border-radius: 10px;
    width: 320px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.2);
}

h2 { text-align: center; }

input {
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border-radius: 5px;
    border: 1px solid #ccc;
}

button {
    width: 100%;
    padding: 10px;
    background: #43cea2;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

button:hover {
    background: #36b18f;
}

a {
    display: block;
    text-align: center;
    margin-top: 10px;
}
</style>

</head>

<body>

<div class="container">
    <h2>Signup</h2>

    <form action="signup" method="post">
        <input type="text" name="username" placeholder="Choose Username" required>
        <input type="password" name="password" placeholder="Choose Password" required>
        <button type="submit">Create Account</button>
    </form>

    <a href="login.jsp">Already have account? Login</a>
</div>

</body>
</html>
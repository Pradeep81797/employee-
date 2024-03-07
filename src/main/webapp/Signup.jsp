<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            margin: 150px;
        }

        .signup-container {
            width: 300px;
            margin: auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .signup-container input {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
        }

        .signup-container button {
            background-color: #4caf50;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="signup-container">
    <h2>Signup</h2>
    <form action="Signupdb.jsp" method="post">
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" required>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required>

        <label for="mobile">Mobile Number:</label>
        <input type="text" id="mobile" name="mobileno" required>

        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <label for="accno">Account Number:</label>
        <input type="text" id="accno" name="accno" required>

        <button type="submit">Signup</button>
    </form>
</div>

</body>
</html>

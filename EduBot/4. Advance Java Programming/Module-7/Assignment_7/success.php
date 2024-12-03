<!DOCTYPE html>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <h2>Registration Successful</h2>
    <?php
    session_start();
    if (isset($_SESSION['name']) && isset($_SESSION['email'])) {
        $name = htmlspecialchars($_SESSION['name']);
        $email = htmlspecialchars($_SESSION['email']);
        echo "<p>Welcome, $name!</p>";
        echo "<p>Your email: $email</p>";
    } else {
        echo "<p>No session data found. Please register again.</p>";
    }
    ?>
</body>
</html>

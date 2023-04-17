<?php
if (isset($_POST['name']) && isset($_POST['email']) && isset($_POST['password'])) {
    require_once "conn.php";
    require_once "validate.php";
    $name = validate($_POST['name']);
    $email = validate($_POST['email']);
    $password = password_hash(validate($_POST['password']), PASSWORD_DEFAULT); // Use password_hash

    $stmt = $conn->prepare("INSERT INTO users (name, email, password) VALUES (?, ?, ?)");
    $stmt->bind_param("sss", $name, $email, $password);

    if ($stmt->execute()) {
        echo "success";
    } else {
        echo "failure";
    }
}
?>

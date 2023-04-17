<?php
if (isset($_POST['email']) && isset($_POST['password'])) {
    require_once "conn.php";
    require_once "validate.php";
    $email = validate($_POST['email']);
    $submitted_password = validate($_POST['password']);

    $stmt = $conn->prepare("SELECT * FROM users WHERE email=?");
    $stmt->bind_param("s", $email);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result->num_rows > 0) {
        $user = $result->fetch_assoc();

        if (password_verify($submitted_password, $user['password'])) { // Use password_verify
            echo "success";
        } else {
            echo "failure";
        }
    } else {
        echo "failure";
    }
}
?>

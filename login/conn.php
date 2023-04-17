<?php
$server = "localhost";
$username = "root";
$password = "";
$database = "water_supply_mgmt_user";
$conn = new mysqli($server, $username, $password, $database);
if($conn->connect_error){
    die("Connection failed: ". $conn->connect_error);
}
?>
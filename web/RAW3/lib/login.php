<?php
include 'connection.php';
session_start(); // Starting Session
$error=''; // Variable To Store Error Message
if (isset($_POST['login'])) {
    if (empty($_POST['username']) || empty($_POST['password'])) {
        $error = "Username And/Or Password is invalid";
    }
    else
    {
// Define $username and $password
        $username=$_POST['username'];
        $password=$_POST['password'];
// To protect MySQL injection for Security purpose
        $username = stripslashes($username);
        $password = stripslashes($password);
        $username = mysqli_real_escape_string($con, $username);
        $password = mysqli_real_escape_string($con, $password);
// SQL query to fetch information of registerd users and finds user match.
        $query = mysqli_query($con, "select * from rentawheeldb.member where password='$password' AND username='$username'");
        $rows = mysqli_num_rows($query);
        if ($rows == 1){
            $_SESSION['login_user']=$username; // Initializing Session
            header("location: ../pages/dashboard.php"); // Redirecting To Services
        }
        else {
            $error = "Username or password is incorrect";
        }
    }
}
?>
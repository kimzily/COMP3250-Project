<!DOCTYPE HTML>

<?php

include 'connection.php';

 if(isset($_POST["uname"])&&isset($_POST["password"])&&isset($_POST["email"])){
     $username=$_POST["uname"];
     $password= $_POST["password"];
     $email=$_POST["email"];
     $firstname=$_POST["firstname"];
     $lastname=$_POST["lastname"];
     $phonenumber=$_POST["PhoneNumber"];
     $dpnumber=$_POST["DPNumber"];
     echo $username;
     echo $password;
     echo $email;
     echo $firstname;
     echo $lastname;
     echo $phonenumber;
     echo $dpnumber;
     $sql = "INSERT INTO member(username, password, email, firstname, lastname, PhoneNumber, DPNumber) VALUES('$username', '$password', '$email', '$firstname', '$lastname', '$phonenumber', '$dpnumber')";
    if (mysqli_query($con, "INSERT INTO member(username, password, email, firstname, lastname, PhoneNumber, DPNumber) VALUES('$username', '$password', '$email', '$firstname', '$lastname', '$phonenumber', '$dpnumber')")) echo " Registration Successful!";
    else echo " Could not insert into database!";
 }
else echo "SQL injection detected!";
echo '<script>alert("You are now a member!");</script>';
header('Location: ../pages/login.php');

?>
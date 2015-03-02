<!DOCTYPE HTML>

<?php
    $con=mysqli_connect("localhost","root","", "rentawheeldb");
    if (mysqli_connect_errno())
    {
        echo "Failed to connect to MySQL: " . mysqli_connect_error();
    }
    else echo "Connection to db Successful"
?>

<?php
/**
 * Created by PhpStorm.
 * User: Bryan
 * Date: 4/14/15
 * Time: 11:13 PM
 */
include 'connection.php';
include 'session.php';

$carid = $_POST['carid'];
$user = mysqli_query($con,"SELECT memberid FROM rentawheeldb.member WHERE username='$login_session'");
$row=mysqli_fetch_assoc($user);
$memberid = $row["memberid"];
$query1 = mysqli_query($con, "UPDATE rentawheeldb.rentalcar SET availability = 'Rented' WHERE carid = '$carid'");
$query2 = mysqli_query($con, "INSERT INTO rentawheeldb.reserved (memberid, carid) VALUES ('$memberid', '$carid')");
header("location: ../pages/dashboard.php");




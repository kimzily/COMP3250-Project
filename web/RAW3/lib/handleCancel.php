<?php
/**
 * Created by PhpStorm.
 * User: Bryan
 * Date: 4/15/15
 * Time: 12:21 AM
 */
include 'connection.php';
include 'session.php';

$carid = $_POST['carid'];
$user = mysqli_query($con,"SELECT memberid FROM rentawheeldb.member WHERE username='$login_session'");
$row=mysqli_fetch_assoc($user);
$memberid = $row["memberid"];
$query1 = mysqli_query($con, "UPDATE rentawheeldb.rentalcar SET availability = 'Available' WHERE carid = '$carid'");
$query2 = mysqli_query($con, "DELETE FROM rentawheeldb.reserved WHERE memberid = '$memberid' AND carid = '$carid'");
header("location: ../pages/dashboard.php");

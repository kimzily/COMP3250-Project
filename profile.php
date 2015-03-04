<!DOCTYPE html>
<head>


    </head>
	<title> <?php echo $firstname ; ?> <?php echo $lastname ; ?>s Profile  </title>
</head>


<?php
require 'connection.php';
// check for form submission

//if (isset($_GET['username'])){
	//$username = $_GET['username'];
	$username = 'user';
	$userquery = mysqli_query($con, "SELECT * FROM memberInfo WHERE username ='$username' ") or die("The query could not be completed. Please try again later".mysqli_error($con));
	if (mysqli_num_rows($userquery) != 1){
		die("That username could not be found");
	}
	while ($row = mysqli_fetch_array($userquery, MYSQL_ASSOC)){
		$id = $row['id'];
		$firstname = $row['firstname'];
		$lastname = $row['lastname'];
		$email = $row['email'];
		$dbusername = $row['username'];
		$address = $row['address'];
		$phone = $row['phone'];

	}

  if($username != $dbusername){

    die ("There has been a fatal error");

  }


?>
<?php
//}
$empty = '';

if(isset($_POST['delete1'])){
	echo "button2 pressed";
	$sql = "UPDATE memberInfo SET `address` = '$empty'  WHERE id= $_POST[hidden] ";
	$res = mysqli_query($con,$sql) or die("Could not remove address".mysqli_error($con));
		echo "<meta http-equiv='refresh' content='0;url=profile.php'>";
};
if(isset($_POST['delete'])){
	echo "button1 pressed";
	$sql = "UPDATE memberInfo SET `phone` = '$empty'  WHERE id= $_POST[hidden] ";
		$res = mysqli_query($con,$sql) or die("Could not remove phone number".mysqli_error($con));
		echo "<meta http-equiv='refresh' content='0;url=profile.php'>";
};

?>


<h2>User Profile</h2>
<form name='form' method='post' action= 'profile.php' >
<table>
   <tr><td>First Name:</td><td><?php echo $firstname ; ?></td></tr><br />

   <tr><td>Last Name:</td><td><?php echo $lastname; ?></td></tr><br />

   <tr><td>Email:</td><td><?php echo $email; ?></td></tr><br />

   <tr><td>Phone Number:</td><td><?php echo $phone;echo "<td>" . "<input type='submit' name='delete' value='remove'> " . " </td>" ?><br/></td></tr><br />

   <tr><td>Address:</td><td><?php echo $address; echo "<td>" . "<input type= 'submit' name='delete1' value='remove'>  " . " </td>" ?><br/></td></tr><br />


   <tr><td></td><td><input type="hidden" name="hidden" value=" <?php echo $id ; ?>"></br>


   

</table>

</form>
<form name='form' method='post' action= 'edit.php' >
<tr><td></td><td><input type="hidden" name="hidden" value=" <?php echo $id ; ?>"></br>

<input type="submit" name="update" value="Edit My User Profile"  >
</form>
</body>

</html>





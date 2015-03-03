<!DOCTYPE html>
<head>


        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>ICOT Sign Up</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <style>
			.error {color: #FF0000;}
            body {
                padding-bottom: 20px;
				padding-top: 35px;
            }
			
		</style>
		
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">

        <script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
		
    </head>
	<title> <?php echo $firstname ; ?> <?php echo $lastname ; ?>s Profile  </title>
</head>


<?php
// check for form submission

//if (isset($_GET['username'])){
	//$username = $_GET['username'];
	$username = 'user1';
	$userquery = mysql_query("SELECT * FROM memberInfo WHERE username ='$username' ") or die("The query could not be completed. Please try again later");
	if (mysql_num_rows($userquery) != 1){
		die("That username could not be found");
	}
	while ($row = mysql_fetch_array($userquery, MYSQL_ASSOC)){
		$id = $row['memberid'];
		$firstname = $row['firstname'];
		$lastname = $row['lastname'];
		$email = $row['email'];
		$dbusername = $row['username'];
		$address = $row['address'];
		$phone = $row['phone'];

	}

  if(username != $dbusername){

    die ("There has been a fatal error");

  }


?>
<?php
//}

if(isset($_POST['delete1'])){
$sql = "UPDATE memberInfo SET address = ''  WHERE memberid= '$_POST[hidden]'";
		$res = mysql_query($sql) 
                                    or die("Could not remove address".mysql_error());
		echo "<meta http-equiv='refresh' content='0;url=profile.php'>";
};
if(isset($_POST['delete'])){
$sql = "UPDATE memberInfo SET phone = ''  WHERE memberid= '$_POST[hidden]'";
		$res = mysql_query($sql) 
                                    or die("Could not remove phone number".mysql_error());
		echo "<meta http-equiv='refresh' content='0;url=profile.php'>";
};

?>


<h2>User Profile</h2>
<form name='form' method='post' action= 'profile.php' >
<table>
   <tr><td>First Name:</td><td><?php echo $firstname ; ?></td></tr><br />

   <tr><td>Last Name:</td><td><?php echo $lastname; ?></td></tr><br />

   <tr><td>Email:</td><td><?php echo $email; ?></td></tr><br />

   <tr><td>Phone Number:</td><td><?php echo $phone;echo "<td>" . "<input type='submit' name='delete' value='remove' onclick ='form.action ='profile.php'; return true;'' > " . " </td>" ?><br/></td></tr><br />

   <tr><td>Address:</td><td><?php echo $address; echo "<td>" . "<input type= 'submit' name='delete1' value='remove' onclick ='this.form.target= '_blank'; return true; ''>  " . " </td>";?><br/></td></tr><br />


   <tr><td></td><td><input type="hidden" name="hidden" value="$id"></br>

   

</table>


<input type="submit" name="update" value="Edit My User Profile" onclick = form.action = 'edit.php'; return true; >
</form>
</body>

</html>





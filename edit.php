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


  <script>
function validateAll(){
  var x=document.forms["form"]["fname"].value;
  if (x==null || x==""){
						alert("First name must be filled out");
						return false;
  }
  x=document.forms["form"]["lname"].value;
  if (x==null || x==""){
						alert("Last name must be filled out");
						return false;
  }
  x=document.forms["form"]["email"].value;
  if (x==null || x==""){
						alert("Email must be filled out");
						return false;
	}

  if(x.indexOf("@") < 1 || x.indexOf(".") < 1 ) {
						alert("Invalid email address. It must contain @ and . ");
						return false;

  }


  x=document.forms["form"]["phone"].value;
  if (x!=""){
  	 
    var phoneno = /^\d{10}$/;
    alert("");
    if (x.value.match(phoneno)) {
   		alert("The phone number contains illegal characters.");
        return false;
        
    } else if (!(stripped.length == 10)) {
    	alert("The phone number is too short.");
        return false;
        
    	} 
  }

 }


function validatePhone(fld) {
    var error = "";
    var stripped = fld.value.replace(/[\(\)\.\-\ ]/g, '');     

   
   if (isNaN(parseInt(stripped))) {
        return false;
        
    } else if (!(stripped.length == 10)) {
        return false;
        
    } 
}
</script>









<?php
 include 'connection.php';

if (isset($_GET['edit'])){
	$id = $_GET['edit'];


		$userquery = mysql_query("SELECT * FROM members WHERE id='$id'");
		while ($row = mysql_fetch_array($userquery, MYSQL_ASSOC)){
			$id = $row['memberid'];
			$firstname = $row['firstname'];
			$lastname = $row['lastname'];
			$email = $row['email'];
			$dbusername = $row['username'];
			$address = $row['address'];
			$phone = $row['phone'];

		}	
 
	if( isset($_POST['fname'] ) )
	{
		$newFName = $_POST['fname'];
		$newLName = $_POST['lname'];
		$newEmail = $_POST['email'];
		$newAddress = $_POST['address'];
		$newPhone = $_POST['phone'];


		$sql = "UPDATE members SET firstname='$newFName' , lastname='$newLName', email = '$newEmail', address = '$newAddress' , phone = '$newPhone' WHERE id='$id'";
		$res = mysql_query($sql) 
                                    or die("Could not update".mysql_error());
		echo "<meta http-equiv='refresh' content='0;url=profile.php'>";
	}
}
 
?>



<h2>Profile Update</h2>
<p><span class="error">* Denotes a required field </span></p> </br>
<form name="form" method="post" action="profile.php" onsubmit="return validateAll();">
<table>
   <tr><td>*First Name:</td><td><input type="text" name="fname" value="<?php echo $fname;?>"></br>
   <span class="error">* <?php echo $nameErr;?></span></td></tr>

   <tr><td>*Last Name:</td><td><input type="text" name="lname" value="<?php echo $lname;?>"></br>
   <span class="error">* <?php echo $nameErr;?></span></td></tr>

   <tr><td>*Email:</td><td><input type="text" name="email" value="<?php echo $email;?>"></br>
   <span class="error">* <?php echo $nameErr;?></span></td></tr>

   <tr><td>Phone Number:</td><td><input type="text" name="phone" value="<?php echo $phone;?>"></br>
   
   <tr><td>Address:</td><td><input type="text" name="address" value="<?php echo $address;?>"></br>
   
 
 </table>
 </br>
 </br>
</br>
   <button type="submit" name="update" value="Update" class="btn btn-primary">Update</button>
   
</form>


</html>















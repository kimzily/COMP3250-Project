<!DOCTYPE html>

 <head>
        
		
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
  if (x!="0"){
  	if (x.length != 10){
      alert("Invalid phone number");
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
 require'connection.php';

//if (isset($_GET['edit'])){
//	$id = $_GET['edit'];
  $id = '1';

		$userquery = mysqli_query($con,"SELECT * FROM memberInfo WHERE id='$id'") or die("The query could not be completed. Please try again later".mysqli_error($con));
		while ($row = mysqli_fetch_array($userquery, MYSQL_ASSOC)){
      $dbusername = $row['username'];
			$id = $row['id'];
			$fname = $row['firstname'];
			$lname = $row['lastname'];
			$email = $row['email'];
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


		$sql = "UPDATE memberInfo SET firstname='$newFName' , lastname='$newLName', email = '$newEmail', address = '$newAddress' , phone = '$newPhone' WHERE id='$id'";
		$res = mysqli_query($con,$sql) 
                                    or die("Could not update".mysqli_error($con));
		echo "<meta http-equiv='refresh' content='0;url=profile.php'>";
	}
//}
 
?>



<h2>Profile Update</h2>
<p><span class="error">* Denotes a required field </span></p> </br>
<p><span class="error">In order to update information simply change the information and click "Update" </span></p> </br>
<form name="form" method="post" action="edit.php" onsubmit="return validateAll();">
<table>
   <tr><td>*First Name:</td><td><input type="text" name="fname" value="<?php echo $fname;?>"></br>
   

   <tr><td>*Last Name:</td><td><input type="text" name="lname" value="<?php echo $lname;?>"></br>
   

   <tr><td>*Email:</td><td><input type="text" name="email" value="<?php echo $email;?>"></br>
 

   <tr><td>Phone Number:</td><td><input type="number" name="phone" value="<?php echo $phone;?>"></br>
   

   <tr><td>Address:</td><td><input type="text" name="address" value="<?php echo $address;?>"></br>
   
 
 </table>
 </br>
 </br>
</br>
   <button type="submit" name="update" value="Update" class="btn btn-primary">Update</button>
   
</form>


</html>




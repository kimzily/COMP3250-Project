<?php



$email = "" ;
$username = "";
$password = "";

if (isset($_POST['submit'])) {


// connect to db 
  include (connect.php)

  $email = stripslashed($_POST['email']);
  $email = strip_tags($email);
  $email = mysqli_real_escape_string($dbc, $email);



  $username = stripslashed($_POST['username']);
  $username = strip_tags($username);
  $username= mysqli_real_escape_string($dbc, $username;

  $password = $_POST['password'];
  $password = mysqli_real_escape_string($dbc, $password);


  
  // Check for empty fields
  if (empty($email) || empty($username) || empty($password)) {
    $errors[]= 'One or more of the Required Fields is missing.'
  }
  else{

    $query = "SELECT email FROM database WHERE email = '$email' " ;
    $result = mysqli_query($dbc, $query) or die(mysqli_error($dbc)) ;
    if (mysqli_num_rows($result) > 0) {
      echo "<br/> Sorry this email already exists." ;
    }

    else {
      $query = "SELECT username FROM rentawheeldb WHERE username = '$username' " ;
      $result = mysqli_query($dbc, $query) or die(mysqli_error($dbc)) ;

      if (mysqli_num_rows($result) > 0) {
        echo "<br/> Sorry this username already exists." ;
      }

      else {
       $query = "INSERT INTO database (username, email, password)" . 
              "VALUES ('$username', '$email' , '$password')" ;


        // Query the db
        $result = mysqli_query($dbc, $query) or die(mysqli_error($dbc)) ;
        if ($result ==1){
          echo "<br/> You have been successfully added to our memberlist." ;

        }

        else {
          echo "<br/> An error has occurred ." ; // This is NOT good
        }
      }

    }
  }
  
}
  //End of validation 


?>




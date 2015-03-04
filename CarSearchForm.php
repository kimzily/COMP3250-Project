<!DOCTYPE html>
<?php
    ?>

<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Rent-A-Wheel</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<link rel="stylesheet" href="css/bootstrap.min.css">
<style>
body {
    padding-bottom: 20px;
}
</style>
<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">

<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>
</head>

<!--[if lt IE 7]>
<p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
<![endif]-->



<script>
function validate(){
  var x = document.forms["form"]["location"].value;
  var y = document.forms["form"]["cost"].value;
  var z = document.forms["form"]["model"].value;

  if ((x==null || x=="") &&
      (y==null || y=="") &&
      (z==null || z==""))
  {
    alert("You must enter at least one search criteria");
    return false;
  } else {
    return true
  }
}
</script>
<body style="background-color:black;">

<nav class="navbar navbar-fixed-top" role="navigation">
<div class="navbar-collapse navbar-inner">
<ul class="nav navbar-nav">
<li><a href="index.php">Home</a></li>
<li class="a"><a href="signup.php">Register</a></li>
<li><a href="contact.php">Contact</a></li>
<li><a href="about.php">About</a></li>
</ul>
</div><!-- /.navbar-collapse -->
</nav>
<div class="jumbotron" style="background-color:black;">
</br>
<div class="container" style="background-color:white;">
<h1>Search:</h2>
<form name="form" method="post" action="CarSearchPost.php" onsubmit="return validate();">
<table>
   <tr><td>Location:</td><td><input type="text" name="location"></td></tr>
   <tr><td>Cost:</td><td><input type="text" name="cost"></td></tr>
   <tr><td>Model:</td><td><input type="text" name="model"></td></tr>
 </table>
 </br>
   <button type="submit" name="submit" value="Submit" class="btn btn-primary">Submit</button>

</form>
</div>
</div>
</body>

</html>

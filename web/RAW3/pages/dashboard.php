<?php
/**
 * Created by PhpStorm.
 * User: Bryan
 * Date: 4/14/2015
 * Time: 2:46 PM
 */

include '../lib/session.php';
include '../lib/connection.php';
?>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>RAW</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <script>
        function post(path, params, method) {
            method = method || "post"; // Set method to post by default if not specified.

            // The rest of this code assumes you are not using a library.
            // It can be made less wordy if you use one.
            var form = document.createElement("form");
            form.setAttribute("method", method);
            form.setAttribute("action", path);

            for(var key in params) {
                if(params.hasOwnProperty(key)) {
                    var hiddenField = document.createElement("input");
                    hiddenField.setAttribute("type", "hidden");
                    hiddenField.setAttribute("name", key);
                    hiddenField.setAttribute("value", params[key]);

                    form.appendChild(hiddenField);
                }
            }

            document.body.appendChild(form);
            form.submit();
        }



    </script>

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="profile.php"><?php echo $login_session; ?>'s Profile</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="../lib/logout.php">Logout</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>

<!-- Page Content -->
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Rent A Wheel
            </h1>
        </div>

    </div>
    <!-- /.row -->

    <!-- Content Row -->
    <div class="row">
        <?php

        $query="SELECT * FROM rentawheeldb.rentalcar where availability = 'Available'";
        $result=mysqli_query($con, $query);
        ?>



            <div class="panel panel-default">
                <div class="panel-heading">
                    Vehicles Available For Rent:
                </div>
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                            <tr>
                                <th>Car ID</th>
                                <th>Manufacturer</th>
                                <th>Model</th>
                                <th>Availability</th>
                                <th>Rental Cost (per day)</th>
                                <th>Reservation</th>
                            </tr>
                            </thead>
                            <tbody>

            <?php
            if(mysqli_num_rows($result)<=0) { ?>
            <tr class="odd gradeX">
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
                            <td>-</td>
            </tr>
                <p>We're sorry to inform you that we are either experiencing a technical difficulty or we do not currently have any vehicles for rent. Sorry for the inconvenience.</p>
            <?php }
            else{
            while($row = mysqli_fetch_assoc($result)) {
                $f1 = $row['carid'];
                $f2 = $row['manufacturer'];
                $f3 = $row['model'];
                $f4 = $row['availability'];
                $f5 = $row['rentalcost'];
            ?>
                        <tr class="odd gradeX">
                            <td><?php echo $f1; ?></td>
                            <td><?php echo $f2; ?></td>
                            <td><?php echo $f3; ?></td>
                            <td><?php echo $f4; ?></td>
                            <td><?php echo $f5; ?></td>
                            <td><button class="btn btn-primary" onclick="post('../lib/handlePost.php', {carid: '<?php echo $f1; ?>'});">Reserve</button></td>
                        </tr>
            <?php }} ?>
                        </tbody>
                    </table>
                </div>
            </div>



    </div>
    <!-- /.row -->







    <hr>

        <?php
        $user = mysqli_query($con,"SELECT memberid FROM rentawheeldb.member WHERE username='$login_session'");
        $row=mysqli_fetch_assoc($user);
        $memberid = $row["memberid"];
        $query=mysqli_query($con, "SELECT * FROM rentawheeldb.reserved where memberid = '$memberid'");
        ?>


        <div class="panel panel-default">
            <div class="panel-heading">
                Vehicles Reserved By You:
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="dataTable_wrapper">
                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                        <thead>
                        <tr>
                            <th>Car ID</th>
                            <th>Manufacturer</th>
                            <th>Model</th>
                            <th>Reservation</th>
                        </tr>
                        </thead>
                        <tbody>

                        <?php

                        if(mysqli_num_rows($query)<=0) { ?>
                            <tr class="odd gradeX">
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                                <td>-</td>
                            </tr>
                            <p>You did not reserve any vehicles.</p>
                        <?php }
                        else{
                            while($row1 = mysqli_fetch_assoc($query)){
                            $carid = $row1['carid'];
                            $result=mysqli_query($con, "SELECT * FROM rentawheeldb.rentalcar where carid = '$carid'");
                            while($row = mysqli_fetch_assoc($result)) {
                                $y1 = $row['carid'];
                                $y2 = $row['manufacturer'];
                                $y3 = $row['model'];
                                ?>
                                <tr class="odd gradeX">
                                    <td><?php echo $y1; ?></td>
                                    <td><?php echo $y2; ?></td>
                                    <td><?php echo $y3; ?></td>
                                    <td><button class="btn btn-primary" onclick="post('../lib/handleCancel.php', {carid: '<?php echo $y1; ?>'});">Cancel</button></td>
                                </tr>
                            <?php }}} ?>
                        </tbody>
                    </table>
                </div>
            </div>



        </div>
        <!-- /.row -->






    <!-- Footer -->
    <footer>
        <div class="row">
            <div class="col-lg-12">
                <p>Copyright &copy; R.A.W 2015</p>
            </div>
        </div>
    </footer>

</div>
<!-- /.container -->

<!-- jQuery -->
<script src="../js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>

<!-- Contact Form JavaScript -->
<!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
<script src="../js/jqBootstrapValidation.js"></script>
<script src="../js/contact_me.js"></script>

</body>

</html>

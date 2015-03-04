<!DOCTYPE HTML>

<?php

require 'connection.php';

$sql = "SELECT * FROM rentawheeldb.cars WHERE ";

$count = 0;

if (isset($_POST["location"])) {
    $location = $_POST["location"];
    $sql = $sql . "location='$location' ";

    $count = $count + 1;
}

if (isset($_POST["cost"]) && $_POST["cost"] != '') {
    $cost = $_POST["cost"];

    if ($count > 0) {
        $sql = $sql . "AND cost='$cost'";
    } else {
        $sql = $sql . "cost='$cost'";
    }
}

if (isset($_POST["model"]) && $_POST["cost"] != '') {
    $model= $_POST["model"];

    if ($count > 0) {
        $sql = $sql . "AND model='$model'";
    } else {
        $sql = $sql . "model='$model'";
    }
}

$response = mysqli_query($con, $sql);
if (! $response) {
    echo "\nQuery Unsuccessful\n";
    echo "$sql\n";
} else {

echo "
<!DOCTYPE html>
<html>
    <head>
        <title>Car Search</title>
    </head>
    <body>
        <table>
            <tr>
                <th>Name</th>
                <th>Colour</th>
                <th>Cost</th>
                <th>Location</th>
                <th>Model</th>
            </tr>
";

while ($row = mysql_fetch_assoc($response)) {
    $a = "<td>" . $row["name"] . "</td>";
    $b = "<td>" . $row["colour"] . "</td>";
    $c = "<td>" . $row["cost"] . "</td>";
    $d = "<td>" . $row["location"] . "</td>";
    $e = "<td>" . $row["model"] . "</td>";

    echo "<tr>
            $a
            $b
            $c
            $d
            $e
        </tr>";
}

echo "
        </table>
    </body
</html>
";
}
?>

<?php

    include('connect.php');
    
    $fname=$_POST["firstname"];
    $lname=$_POST["lastname"];
    $email=$_POST["email"];
    $mobile=$_POST["mobile"];
    $pass=$_POST["password"];
    
    if($fname=="" && $lname=="" && $email=="" && $mobile=="" && $pass=="")
    {
        echo '0';
    }
    else
    {
        $sql ="Insert into Inventory_Register(firstname,lastname,email,mobile,password) values ('$fname','$lname','$email','$mobile','$pass')";
        
        $ex=mysqli_query($con,$sql);
    }

?>
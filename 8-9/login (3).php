<?php
    
    include('connect.php');
    
    $mob=$_REQUEST["mobile"];
    $pass=$_REQUEST["password"];
    
    $sql="select * from Inventory_Register where mobile='$mob' and password ='$pass'";
    
    
    $ex=mysqli_query($con,$sql);
    
    $no=mysqli_num_rows($ex);
    
    
    if($no>0)
    {
    $fet=mysqli_fetch_object($ex);
    echo json_encode(['code'=>200]);
    }
    else
    {
    echo "0";
    }

?>
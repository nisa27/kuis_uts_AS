<?php 
 

 //Mendapatkan Nilai ID
 $id = $_GET['id'];
 
 //Import File Koneksi Database
 require_once('connect.php');
 
 //Membuat SQL Query
 $sql = "DELETE FROM tb_minimarket WHERE id=$id;";
 
 
 //Menghapus Nilai pada Database 
 if(mysqli_query($con,$sql)){
 echo 'Berhasil Menghapus Minimarket';
 }else{
 echo 'Gagal Menghapus Minimarket';
 }
 
 mysqli_close($con);
 ?>
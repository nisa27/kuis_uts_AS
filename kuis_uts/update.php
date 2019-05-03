<?php 
 
    if($_SERVER['REQUEST_METHOD']=='POST'){
        //MEndapatkan Nilai Dari Variable 
        $id = $_POST['id'];
        $kode = $_POST['kode'];
        $nama = $_POST['nama'];
        $alamat = $_POST['alamat'];
        $nohp = $_POST['nohp'];
        
        //import file koneksi database 
        require_once('koneksi.php');
        
        //Membuat SQL Query
        $sql = "UPDATE tb_minimarket SET kode = '$kode', nama = '$nama', alamat = '$alamat', nohp = '$nohp' WHERE id = $id;";
        
        //Meng-update Database 
        if(mysqli_query($con,$sql)){
        echo 'Berhasil Update Data Minimarket';
        }else{
        echo 'Gagal Update Data Minimarket';
        }
        
        mysqli_close($con);
    }
?>
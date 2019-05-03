<?php
 
    if($_SERVER['REQUEST_METHOD']=='POST'){
        
        //Mendapatkan Nilai Variable
        $kode = $_POST['kode'];
        $nama = $_POST['nama'];
        $alamat = $_POST['alamat'];
        $nohp = $_POST['nohp'];
        
        //Pembuatan Syntax SQL
        $sql = "INSERT INTO tb_minimarket (kode,nama,alamat,nohp) VALUES ('$kode','$nama','$alamat','$nohp')";
        
        //Import File Koneksi database
        require_once('connect.php');
        
        //Eksekusi Query database
        if(mysqli_query($con,$sql)){
        echo 'Berhasil Menambahkan Minimarket';
        }else{
        echo 'Gagal Menambahkan Minimarket';
        }
        
        mysqli_close($con);
    }
?>
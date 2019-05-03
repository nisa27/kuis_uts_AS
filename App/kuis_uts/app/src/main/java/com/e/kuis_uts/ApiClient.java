package com.e.kuis_uts;




public class ApiClient {

   //Dibawah ini merupakan Pengalamatan dimana Lokasi Skrip CRUD PHP disimpan
    //Pada tutorial Kali ini, karena kita membuat localhost maka alamatnya tertuju ke IP komputer
    //dimana File PHP tersebut berada
    //PENTING! JANGAN LUPA GANTI IP SESUAI DENGAN IP KOMPUTER DIMANA DATA PHP BERADA
    public static final String URL_ADD="http://192.168.43.33/kuis_uts/add.php";
    public static final String URL_GET_ALL = "http://192.168.43.33/kuis_uts/show_all.php";
    public static final String URL_GET_EMP = "http://192.168.43.33/kuis_uts/show.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.43.33/kuis_uts/update.php";
    public static final String URL_DELETE_EMP = "http://192.168.43.33/kuis_uts/delete.php?id=";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_MM_ID = "id";
    public static final String KEY_MM_KODE = "kode";
    public static final String KEY_MM_NAMA = "nama";
    public static final String KEY_MM_ALAMAT = "alamat";
    public static final String KEY_MM_NOHP = "nohp";

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_KODE = "kode";
    public static final String TAG_NAMA = "nama";
    public static final String TAG_ALAMAT= "alamat";
    public static final String TAG_NOHP = "nohp";

    //ID MM(MiniMarket)
    public static final String MM_ID = "mm_id";
}

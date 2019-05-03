package com.e.kuis_uts;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Dibawah ini merupakan perintah untuk mendefinikan View
    private EditText editTextKode;
    private EditText editTextNama;
    private EditText editTextAlamat;
    private EditText editTextKontak;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi dari View
        editTextKode = (EditText) findViewById(R.id.editTextKode);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextKontak = (EditText) findViewById(R.id.editTextKontak);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Dibawah ini merupakan perintah untuk Menambahkan Minimarket (CREATE)
    private void addMinimarket(){

        final String kode = editTextKode.getText().toString().trim();
        final String nama = editTextNama.getText().toString().trim();
        final String alamat= editTextAlamat.getText().toString().trim();
        final String nohp = editTextKontak.getText().toString().trim();

        class AddMinimarket extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Menambahkan...","Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(ApiClient.KEY_MM_KODE,kode);
                params.put(ApiClient.KEY_MM_NAMA,nama);
                params.put(ApiClient.KEY_MM_ALAMAT,alamat);
                params.put(ApiClient.KEY_MM_NOHP,nohp);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(ApiClient.URL_ADD, params);
                return res;
            }
        }

        AddMinimarket ae = new AddMinimarket();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addMinimarket();
        }

        if(v == buttonView){
            startActivity(new Intent(this,ShowAll.class));
        }
    }
}
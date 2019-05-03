package com.e.kuis_uts;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;



public class Show extends AppCompatActivity implements View.OnClickListener{

    private EditText editTextId;
    private EditText editTextKode;
    private EditText editTextNama;
    private EditText editTextAlamat;
    private EditText editTextKontak;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        Intent intent = getIntent();

        id = intent.getStringExtra(ApiClient.MM_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextKode = (EditText) findViewById(R.id.editTextKode);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextKontak = (EditText) findViewById(R.id.editTextKontak);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editTextId.setText(id);

        getMinimarket();
    }

    private void getMinimarket(){
        class GetMinimarket extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Show.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(ApiClient.URL_GET_EMP,id);
                return s;
            }
        }
        GetMinimarket ge = new GetMinimarket();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(ApiClient.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            int kode = c.getInt(ApiClient.TAG_KODE);
            String nama = c.getString(ApiClient.TAG_NAMA);
            String alamat= c.getString(ApiClient.TAG_ALAMAT);
            String nohp = c.getString(ApiClient.TAG_NOHP);

            editTextKode.setText(kode);
            editTextNama.setText(nama);
            editTextAlamat.setText(alamat);
            editTextKontak.setText(nohp);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateMinimarket(){
        final String kode = editTextKode.getText().toString().trim();
        final String nama = editTextNama.getText().toString().trim();
        final String alamat = editTextAlamat.getText().toString().trim();
        final String nohp = editTextKontak.getText().toString().trim();

        class UpdateMinimarket extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Show.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Show.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(ApiClient.KEY_MM_ID,id);
                hashMap.put(ApiClient.KEY_MM_KODE,kode);
                hashMap.put(ApiClient.KEY_MM_NAMA,nama);
                hashMap.put(ApiClient.KEY_MM_ALAMAT,alamat);
                hashMap.put(ApiClient.KEY_MM_NOHP,nohp);

                RequestHandler rh = new RequestHandler();

                String s = rh.sendPostRequest(ApiClient.URL_UPDATE_EMP,hashMap);

                return s;
            }
        }

        UpdateMinimarket ue = new UpdateMinimarket();
        ue.execute();
    }

    private void deleteMinimarket(){
        class DeleteMinimarket extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Show.this, "Updating...", "Tunggu...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(Show.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequestParam(ApiClient.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteMinimarket de = new DeleteMinimarket();
        de.execute();
    }

    private void confirmDeleteMinimarket(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Apakah Kamu Yakin Ingin Menghapus Data ini?");

        alertDialogBuilder.setPositiveButton("Ya",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteMinimarket();
                        startActivity(new Intent(Show.this,ShowAll.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("Tidak",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateMinimarket();
        }

        if(v == buttonDelete){
            confirmDeleteMinimarket();
        }
    }
}
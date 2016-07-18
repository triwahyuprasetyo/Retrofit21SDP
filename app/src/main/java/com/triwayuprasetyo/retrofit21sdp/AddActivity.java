package com.triwayuprasetyo.retrofit21sdp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AddActivity extends AppCompatActivity {
    ProgressDialog pd;
    private EditText editTextNama, editTextAlamat, editTextUsername, editTextPassword;
    private Button buttonAddSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);
        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        buttonAddSave = (Button) findViewById(R.id.buttonAddSave);
        buttonAddSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AnggotaWrapper.Anggota a = new AnggotaWrapper.Anggota();
                a.setNama(editTextNama.getText().toString());
                a.setAlamat(editTextAlamat.getText().toString());
                a.setUsername(editTextUsername.getText().toString());
                a.setPassword(editTextPassword.getText().toString());

                Log.d("SDP", "Anggota :: " + a.getNama());
                Log.d("SDP", "Anggota :: " + a.getAlamat());
                Log.d("SDP", "Anggota :: " + a.getUsername());
                Log.d("SDP", "Anggota :: " + a.getPassword());

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://triwahyuprasetyo.xyz/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                AnggotaService service = retrofit.create(AnggotaService.class);

                Call<Void> call = service.tambahPostAnggota(a.getNama(),
                        a.getUsername(),
                        a.getPassword(),
                        a.getAlamat(),
                        a.getLatitude(),
                        a.getLongitude(),
                        a.getFoto());
                call.enqueue(new Callback<Void>() {
                                 @Override
                                 public void onResponse(Call<Void> call, Response<Void> response) {
                                     Toast.makeText(getApplicationContext(), "Success : " + response.message(), Toast.LENGTH_SHORT).show();
//
//                                     for (AnggotaWrapper.Anggota anggota : response.body().getAnggota()) {
//                                         Log.d("SDP", "Anggota :: " + anggota.getId());
//                                         Log.d("SDP", "Anggota :: " + anggota.getNama());
//                                         Log.d("SDP", "Anggota :: " + anggota.getAlamat());
//                                         Log.d("SDP", "Anggota :: " + anggota.getUsername());
//                                         Log.d("SDP", "Anggota :: " + anggota.getPassword());
//                                         Log.d("SDP", "=======================================");
//                                     }
                                 }

                                 //
//
                                 @Override
                                 public void onFailure(Call<Void> call, Throwable t) {
                                     Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
                                     Log.i("SDP ERROR", t.getMessage());
                                 }
                             }

                );
            }
        });
    }
}


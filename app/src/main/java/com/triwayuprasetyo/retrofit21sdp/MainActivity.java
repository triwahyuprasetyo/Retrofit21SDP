package com.triwayuprasetyo.retrofit21sdp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button buttonAddAnggota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAddAnggota = (Button) findViewById(R.id.buttonAddAnggota);
        buttonAddAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AddActivity.class);
                startActivity(i);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://triwahyuprasetyo.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AnggotaService service = retrofit.create(AnggotaService.class);

        Call<AnggotaWrapper> call = service.listAnggota();
        call.enqueue(new Callback<AnggotaWrapper>() {
            @Override
            public void onResponse(Call<AnggotaWrapper> call, Response<AnggotaWrapper> response) {
                Toast.makeText(getApplicationContext(), "Success : " + response.message(), Toast.LENGTH_SHORT).show();

                for (AnggotaWrapper.Anggota anggota : response.body().getAnggota()) {
                    Log.d("SDP", "Anggota :: " + anggota.getId());
                    Log.d("SDP", "Anggota :: " + anggota.getNama());
                    Log.d("SDP", "Anggota :: " + anggota.getAlamat());
                    Log.d("SDP", "Anggota :: " + anggota.getUsername());
                    Log.d("SDP", "Anggota :: " + anggota.getPassword());
                    Log.d("SDP", "=======================================");
                }
            }

            @Override
            public void onFailure(Call<AnggotaWrapper> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

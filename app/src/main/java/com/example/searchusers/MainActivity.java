package com.example.searchusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    RecyclerView rv;
    MyAdapter adapter;
    ArrayList<GithubUser> list=new ArrayList<>();

    private static final String api="https://api.github.com/search/users?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName=findViewById(R.id.etName);
        rv=findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        adapter=new MyAdapter(this, list);
        rv.setAdapter(adapter);
    }

    public void btnClicked(View view) {
        if(view.getId()==R.id.btnSearch){

            String name=etName.getText().toString();
            if(name.equals("")){
                Toast.makeText(MainActivity.this, "Enter Name!", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                makeCall(api+name);
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Some Error Occurred!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makeCall(String url) throws Exception {
        OkHttpClient client=new OkHttpClient();
        final Request request=new Request.Builder().url(url).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Toast.makeText(MainActivity.this, "Network Error!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String result=response.body().string();

                Gson gson=new Gson();
                final ApiResult apiResult=gson.fromJson(result, ApiResult.class);

                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list.clear();
                        list.addAll(Arrays.asList(apiResult.getItems()));
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}

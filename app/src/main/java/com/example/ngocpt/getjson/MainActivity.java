package com.example.ngocpt.getjson;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ngocpt.getjson.adapter.ProductAdapter;
import com.example.ngocpt.getjson.model.Products;
import com.example.ngocpt.getjson.service.APIService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RecyclerView.LayoutManager mLayoutManager;
    private List<Products> productList;
    private ProductAdapter productAdapter;
    String TAG = MainActivity.class.getSimpleName();
    String URL_GET_PRODUCT = "http://dev.androidcoban.com/blog/";
    private Button btnGetData;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnGetData=findViewById(R.id.btn_getdata);
        recyclerView=findViewById(R.id.recycler_view);
        btnGetData.setOnClickListener(this);
    }

    private void addControl() {
        recyclerView.setHasFixedSize(true);
        // Create 2 col
        mLayoutManager = new GridLayoutManager(MainActivity.this, 2);
     //   productList = new ArrayList<>();
        productAdapter = new ProductAdapter(productList, MainActivity.this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(mLayoutManager);
    }

    private void getAllProduct() {
        Log.e(TAG, "getAllProduct: ");
        productList = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_GET_PRODUCT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call<List<Products>> call = apiService.getAllProduct();
        call.enqueue(new Callback<List<Products>>() {

            @Override
            public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                List<Products> productsList = response.body();
                for (int i = 0; i<productsList.size() ; i++) {
                    productList.add(productsList.get(i));
                    Log.e(TAG, "onResponse:" + productList.get(i).getProductName());
                }
                addControl();
            }

            @Override
            public void onFailure(Call<List<Products>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getdata:
                getAllProduct();
                break;
            default:
                break;
        }
    }
}

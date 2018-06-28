package com.example.ngocpt.getjson.service;

import com.example.ngocpt.getjson.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ngoc.pt on 28/06/2018.
 */

public interface APIService {
    @GET("getallproducts.php")
    Call<List<Products>> getAllProduct();
}

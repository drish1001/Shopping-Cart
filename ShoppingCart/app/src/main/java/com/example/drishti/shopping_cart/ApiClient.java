package com.example.drishti.shopping_cart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiClient {
    String BASE_URL = "https://bitnami-39xfosdmxa.appspot.com/";

    @GET("get-items")
    Call<List<PhoneList>> getPhoneItems();

    @GET("get-items")
    Call<List<PhoneList>> getPhoneItems(@Query("manufacturer") String manufacturer,
                                        @Query("model") String model,
                                        @Query("min-price") String min,
                                        @Query("max-price") String max);
    @GET("getSalesRecords")
    Call<List<Sales>> getSales();

    @GET("buy")
    Call<Purchase> getBuyer(@Query("model") String model,
                            @Query("username") String username,
                            @Query("qty") String quantity);

}

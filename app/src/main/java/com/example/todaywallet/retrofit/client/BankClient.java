package com.example.todaywallet.retrofit.client;

import com.example.todaywallet.retrofit.client.service.AuthService;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Date;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BankClient {
    private static final String PROD = ApiShinHan.SHIN_HAN_BANK_API;

    private static ApiClient instance;
    private MyInterceptor interceptor;

    private int userId;
    private final AuthService authService;

    /*
    private final AuthService authService;
    private final AssetService assetService;
    private final UserService userService;
    private final StickService stickService;

     */

    public BankClient() {
        interceptor = new MyInterceptor();

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateDeserializer())
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS")
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        OkHttpClient okHttp = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(String.format("http://%s:3001/", PROD))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttp)
                .build();

        authService = retrofit.create(AuthService.class);
        /*
        authService = retrofit.create(AuthService.class);
        assetService = retrofit.create(AssetService.class);
        userService = retrofit.create(UserService.class);
        stickService = retrofit.create(StickService.class);
        */

    }

    public static ApiClient getInstance() {
        if (instance == null) {
            synchronized (ApiClient.class) {
                if (instance == null) {
                    instance = new ApiClient();
                }
            }
        }
        return instance;
    }


    public void setToken(String token){
        interceptor.setToken(token);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public boolean isLoggedIn(){
        return getUserId() != 0;
    }
}
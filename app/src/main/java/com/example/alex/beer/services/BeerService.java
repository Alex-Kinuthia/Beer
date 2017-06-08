package com.example.alex.beer.services;


import com.example.alex.beer.models.Beer;
import com.example.alex.beer.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by alex on 6/4/17.
 */

public class BeerService {
    public static void findBeers(String name, Callback callback){
        OkHttpClient client = new OkHttpClient();

//        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.BEER_API_KEY);
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new SigningInterceptor(consumer))
//                .build();


//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new SigningInterceptor(consumer))
//                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BEER_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.BEER_QUERY_PARAMETER, name);
        String url = urlBuilder.build().toString();

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Beer> processResults(Response response) {
        ArrayList<Beer> beers = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject beerJSON = new JSONObject(jsonData);
                JSONArray dataJSON = beerJSON.getJSONArray("data");
                for (int i = 0; i < dataJSON.length(); i++) {
                    JSONObject brewaryJSON = dataJSON.getJSONObject(i);
                    String id = brewaryJSON.getString("id");
                    String name = brewaryJSON.getString("name");
                    String description = brewaryJSON.getJSONObject("style").getString("description");
                    String abv = brewaryJSON.getString("abv");
                    String styleId = brewaryJSON.getString("styleId");
                    String isOrganic = brewaryJSON.getString("isOrganic");
                    String status = brewaryJSON.getString("status");
                    String label = brewaryJSON.optJSONObject("labels").optString("large");
                    String updateDate =brewaryJSON.optJSONObject("updateDate").toString();
                    String createDate =brewaryJSON.optJSONObject("createDate").toString();

                    Beer beer = new Beer(id, name, abv, styleId, isOrganic, status, description, label, createDate, updateDate);
                    beers.add(beer);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return beers;
    }
}
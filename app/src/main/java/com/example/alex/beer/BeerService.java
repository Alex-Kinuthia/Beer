package com.example.alex.beer;


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
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

import static android.R.attr.rating;


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
                    JSONObject breweryJSON = dataJSON.getJSONObject(i);
                    String id = breweryJSON.getString("id");
                    String name = breweryJSON.getString("name");
                    String description = breweryJSON.getJSONObject("styles").getString("description");
                    String abv = breweryJSON.getString("abv");
                    String styleId = breweryJSON.getString("styleId");
                    String isOrganic = breweryJSON.getString("isOrganic");
                    String status = breweryJSON.getString("status");

                    Beer beer = new Beer(id, name, description, abv, styleId,
                            isOrganic, status);
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
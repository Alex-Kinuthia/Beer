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
    private static OkHttpClient client = new OkHttpClient();
    public static void findBeers(String name, Callback callback) {
//        OkHttpClient client = new OkHttpClient.Builder()
//                .build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.BEER_API_KEY);
        urlBuilder.addQueryParameter(Constants.NAME_QUERY_PARAMETER, name);
        urlBuilder.addQueryParameter("format", "json");
        String url = urlBuilder.build().toString();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static ArrayList<Beer> processResults(Response response) {
        ArrayList<Beer> beers = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject beerJSON = new JSONObject(jsonData);
                JSONArray dataJSON = beerJSON.getJSONArray("wines");
                for (int i = 0; i < dataJSON.length(); i++) {
                    JSONObject brewaryJSON = dataJSON.getJSONObject(i);
                    String name = brewaryJSON.optString("name");
                    String winery = brewaryJSON.getString("winery");
                    String varietal = brewaryJSON.getString("varietal");
                    String price = brewaryJSON.getString("price");
                    String vintage = brewaryJSON.getString("vintage");
                    String type = brewaryJSON.getString("type");
                    String link = brewaryJSON.getString("link");
                    String region = brewaryJSON.getString("region");
                    String image = brewaryJSON.getString("image");

                    Beer beer = new Beer( name, winery, varietal, price, vintage, type, link, region, image);
                    beers.add(beer);
//                    if (!imageUrl.isEmpty()){
//                        beer.setImageUrl(imageUrl);
//                    }
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
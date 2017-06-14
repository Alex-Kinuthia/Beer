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
    public static void findBeers(String name, Callback callback){


//        OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(Constants.BEER_API_KEY);
//
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new SigningInterceptor(consumer))
//                .build();


//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(new SigningInterceptor(consumer))
//                .build();
        String base_url = String.format("%s/quicksearch/ingredients/%s/", Constants.BEER_BASE_URL, name);
        HttpUrl.Builder urlBuilder = HttpUrl.parse(base_url).newBuilder();
//        urlBuilder.addQueryParameter(Constants.BEER_QUERY_PARAMETER, name);
        urlBuilder.addQueryParameter(Constants.BEER_API_KEY_QUERY_PARAMETER, Constants.BEER_API_KEY);
//        String url = urlBuilder.build().toString() + name + Constants.BEER_API_KEY_QUERY_PARAMETER
//                + Constants.BEER_API_KEY;
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
                JSONArray dataJSON = beerJSON.getJSONArray("result");
                for (int i = 0; i < dataJSON.length(); i++) {
                    JSONObject brewaryJSON = dataJSON.getJSONObject(i);
                    String name = brewaryJSON.optString("name");
                    String id = brewaryJSON.optString("id");
                    String type = brewaryJSON.optString("type");
                    String isJuicy = brewaryJSON.optString("isJuicy");
                    String isBaseSpirit = brewaryJSON.optString("isBaseSpirit");
                    String isAlcoholic = brewaryJSON.optString("isAlcoholic");
                    String isCarbonated = brewaryJSON.optString("isCarbonated");
                    String description = brewaryJSON.optString("description");
                    Beer beer = new Beer( name, id, type, isJuicy , isBaseSpirit, isAlcoholic, isCarbonated, description);
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
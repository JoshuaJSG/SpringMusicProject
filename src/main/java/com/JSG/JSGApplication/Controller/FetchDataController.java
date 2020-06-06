package com.JSG.JSGApplication.Controller;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FetchDataController {

    private List<String> albums = new ArrayList<>();
    public List<String> songs = new ArrayList<>();
    public String baseUrl = "https://itunes.apple.com/search?term=";


    public List<String> searchArtistbyName(String artistName){
        String usedArtistName = "";
        List<String> namesArrayWithPlus = new ArrayList<>();
        String[] splitArtistNameArray = artistName.split(" ");

        if (splitArtistNameArray.length==1){
            usedArtistName = artistName;
        } else {
            for (int i = 0; i <splitArtistNameArray.length-1; i++) {
                String namesWithPlus = splitArtistNameArray[i] +"+"+splitArtistNameArray[splitArtistNameArray.length-1];
                namesArrayWithPlus.add(namesWithPlus);
            }
            usedArtistName = getItemsFromList(namesArrayWithPlus);
        }

        String newUrl = baseUrl+usedArtistName;
        System.out.println(newUrl);
        try {
            fetchUrl(newUrl);
        } catch (Exception e) {
            System.out.println("Error making request to URL: " +newUrl+"\n"+ e.getLocalizedMessage());
            e.printStackTrace();
        }
        return songs;
    }


    public void cleanSongs(){
        songs = new ArrayList<>();
    }


    private String getItemsFromList(List<String> array){
        String names = "";
        for (String name : array) {
            names+=name;
        }
        return names;
    }


    private String fetchUrl(String urlString) throws Exception{
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        rd.close();
        parseJSON(result.toString());
        return result.toString();
    }


    private void parseJSON(String httpResponse){
        String name = "";
        String albumName = "";
        String trackName = "";
        String jsonString = httpResponse.toString();
        JSONObject obj = new JSONObject(jsonString);
        JSONArray contributorsArray = obj.getJSONArray("results");
        for (int i = 0; i < contributorsArray.length()-1; i++) {
            name = contributorsArray.getJSONObject(0).getString("artistName");
            trackName = contributorsArray.getJSONObject(i).getString("trackName");
//            albumName = contributorsArray.getJSONObject(i+1).getString("collectionName");
            albums.add(albumName);
            songs.add(trackName);
        }
        System.out.println("Artist: "+name+ "\nSongs:");
        System.out.println();
        loopList(songs);
    }

    private void loopList(List<String> musicList){
        for (String music : musicList) {
            System.out.println(music);
        }
    }
}


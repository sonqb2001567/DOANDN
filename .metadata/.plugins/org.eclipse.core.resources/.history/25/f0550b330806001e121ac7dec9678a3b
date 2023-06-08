package com.example.demo.api;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.MoisDTO;
import com.example.demo.DTO.TempDTO;
import com.example.demo.Service.MoisService;
import com.example.demo.Service.TempService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Component
public class APIRequest {

    @Value("${adafruit.io.username}")
    private String username;

    @Value("${adafruit.io.key}")
    private String key;

    @Autowired
    private TempService tempService;
    
    @Autowired
    private MoisService moisService;
    
    private final String baseUrl = "https://io.adafruit.com/api/v2/";

    public String getFeedData(String feedName) throws IOException {
        String url = baseUrl + username + "/feeds/" + feedName + "/data";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-AIO-Key", key);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JsonElement element = JsonParser.parseString(response.toString());
        JsonArray jsonArray = element.getAsJsonArray();
        
        ArrayList<JsonObject> list = new ArrayList<>();
        for (JsonElement jsonElement : jsonArray) {
            list.add(jsonElement.getAsJsonObject());
        }
        return list.toString();
    }
    
    public String getLastData(String feedName) throws IOException, ParseException {
        String url = baseUrl + username + "/feeds/" + feedName + "/data/last";
        
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-AIO-Key", key);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String line;
        StringBuilder response = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        JsonElement element = JsonParser.parseString(response.toString());
        JsonObject tempJO = element.getAsJsonObject();
        JsonObject jsonObject= new JsonObject();
        jsonObject.addProperty("areaid", 1);
        jsonObject.addProperty("rectime", tempJO.get("created_at").getAsString());
        
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        java.util.Date pasDate = formatter.parse(jsonObject.get("rectime").getAsString());
        Timestamp timestamp = new Timestamp(pasDate.getTime());
        
        if (feedName.equals("bbc-temp")) {
        	jsonObject.addProperty("temp", tempJO.get("value").getAsString());
        	TempDTO tempDTO = new TempDTO();
        	tempDTO.setAreaid(jsonObject.get("areaid").getAsInt());
        	tempDTO.setRectime(timestamp);
        	tempDTO.setTemp(jsonObject.get("temp").getAsFloat());
        	tempService.addTemp(tempDTO);
        }
        
        if (feedName.equals("bbc-moisture")) {
        	jsonObject.addProperty("mois", tempJO.get("value").getAsString());
        	MoisDTO moisDTO = new MoisDTO();
        	moisDTO.setAreaid(jsonObject.get("areaid").getAsInt());
        	moisDTO.setRectime(timestamp);
        	moisDTO.setMois(jsonObject.get("mois").getAsFloat());
			moisService.addMois(moisDTO);
        }
        
        return jsonObject.toString();
    }
    
    public void sendData(String feedName, Map<String, Object> data) throws IOException {
        String url = baseUrl + "/" + username + "/feeds/" + feedName + "/data";

        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("X-AIO-Key", key);
        connection.setDoOutput(true);

        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), StandardCharsets.UTF_8);
        Gson gson = new Gson();
        writer.write(gson.toJson(data));
        writer.flush();
        writer.close();

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            StringBuilder errorMessage = new StringBuilder();
            String line;
            while ((line = errorReader.readLine()) != null) {
                errorMessage.append(line);
            }
            errorReader.close();
            throw new IOException("Failed to send data to feed. Response code: " + responseCode + ", Error message: " + errorMessage);
        }

        BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = responseReader.readLine()) != null) {
            response.append(line);
        }
        responseReader.close();
        System.out.println("Data sent successfully to feed " + feedName + ": " + response.toString());
    }

}

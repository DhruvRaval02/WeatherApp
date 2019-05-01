package com.example.dhruv.weatherapp;


import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText zipCode;
    URL information;
    URLConnection connectInformation;
    InputStream inputStream;
    BufferedReader bufferedReader;
    String zip = "";
    String jsonInformation = "";

    JSONObject weatherPresentInfo;
    JSONObject weatherPresent;
    JSONObject descriptionPresent;
    JSONObject weatherTriOne;
    JSONObject descriptionTriOne;
    JSONObject weatherTriTwo;
    JSONObject descriptionTriTwo;
    JSONObject weatherTriThree;
    JSONObject descriptionTriThree;
    JSONObject weatherTriFour;
    JSONObject descriptionTriFour;
    JSONObject weatherTriFive;
    JSONObject descriptionTriFive;

    Button getWeather;
    ImageView currentImage;
    TextView quote;
    TextView currentTemp;
    TextView currentForecast;

    TextView timeTriOne;
    TextView timeTriTwo;
    TextView timeTriThree;
    TextView timeTriFour;
    TextView timeTriFive;
    ImageView imageTriOne;
    ImageView imageTriTwo;
    ImageView imageTriThree;
    ImageView imageTriFour;
    ImageView imageTriFive;
    TextView tempMinTriOne;
    TextView tempMinTriTwo;
    TextView tempMinTriThree;
    TextView tempMinTriFour;
    TextView tempMinTriFive;
    TextView tempMaxTriOne;
    TextView tempMaxTriTwo;
    TextView tempMaxTriThree;
    TextView tempMaxTriFour;
    TextView tempMaxTriFive;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentImage = findViewById(R.id.currentImage);
        quote = findViewById(R.id.ID_quote);
        currentTemp = findViewById(R.id.ID_currentTemperature);
        currentForecast = findViewById(R.id.ID_currentForecast);

        timeTriOne = findViewById(R.id.ID_timeTriOne);
        timeTriTwo = findViewById(R.id.ID_timeTriTwo);
        timeTriThree = findViewById(R.id.ID_timeTriThree);
        timeTriFour = findViewById(R.id.ID_timeTriFour);
        timeTriFive = findViewById(R.id.ID_timeTriFive);

        imageTriOne = findViewById(R.id.ID_imageTriOne);
        imageTriTwo = findViewById(R.id.ID_imageTriTwo);
        imageTriThree = findViewById(R.id.ID_imageTriThree);
        imageTriFour = findViewById(R.id.ID_imageTriFour);
        imageTriFive = findViewById(R.id.ID_imageTriFive);

        tempMinTriOne = findViewById(R.id.ID_minTempTriOne);
        tempMinTriTwo = findViewById(R.id.ID_minTempTriTwo);
        tempMinTriThree = findViewById(R.id.ID_minTempTriThree);
        tempMinTriFour = findViewById(R.id.ID_minTempTriFour);
        tempMinTriFive = findViewById(R.id.ID_minTempTriFive);

        tempMaxTriOne = findViewById(R.id.ID_maxTempTriOne);
        tempMaxTriTwo = findViewById(R.id.ID_maxTempTriTwo);
        tempMaxTriThree = findViewById(R.id.ID_maxTempTriThree);
        tempMaxTriFour = findViewById(R.id.ID_maxTempTriFour);
        tempMaxTriFive = findViewById(R.id.ID_maxTempTriFive);

        getWeather = findViewById(R.id.getWeather);
        zipCode = findViewById(R.id.ID_zipcode);
        getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zip = zipCode.getText().toString();
                new APIKeyCall().execute(zip);
            }
        });

    }

    public void setImageResources(ImageView image, String iconCode, boolean isQuotation) {
        if (iconCode.equals("01d")) {
            image.setImageResource(R.drawable.oned);
            if(isQuotation)
                quote.setText("All I have to do is sit back and watch as the sun shines");
        }
        else if (iconCode.equals("01n")) {
            image.setImageResource(R.drawable.onen);
            if(isQuotation)
                quote.setText("This is the weather for blowing up moons");
        }
        else if (iconCode.equals("02d")) {
            image.setImageResource(R.drawable.twod);
            if(isQuotation)
                quote.setText("Just a typical, partly cloudy, homecoming.");
        }
        else if (iconCode.equals("02n")) {
            image.setImageResource(R.drawable.twon);
            if(isQuotation)
                quote.setText("Just a typical, partly cloudy, homecoming.");
        }
        else if (iconCode.equals("03d")) {
            image.setImageResource(R.drawable.threed);
            if(isQuotation)
                quote.setText("Let me know if \"cloudy\" wants a magazine or something");
        }
        else if (iconCode.equals("03n")) {
            image.setImageResource(R.drawable.threen);
            if(isQuotation)
                quote.setText("Let me know if \"cloudy\" wants a magazine or something");
        }
        else if (iconCode.equals("04d")) {
            image.setImageResource(R.drawable.fourd);
            if(isQuotation)
                quote.setText("I need a horse. And sunlight.");
        }
        else if (iconCode.equals("04n")) {
            image.setImageResource(R.drawable.fourn);
            if(isQuotation)
                quote.setText("I need a horse. And moonlight");
        }
        else if (iconCode.equals("09d")) {
            image.setImageResource(R.drawable.nined);
            if(isQuotation)
                quote.setText("Drop your socks and grab your crocs, we're about to get wet on this ride");
        }
        else if (iconCode.equals("09n")) {
            image.setImageResource(R.drawable.ninen);
            if(isQuotation)
                quote.setText("Drop your socks and grab your crocs, we're about to get wet on this ride");
        }
        else if (iconCode.equals("10d")) {
            image.setImageResource(R.drawable.tend);
            if(isQuotation)
                quote.setText("I could sit inside all day");
        }
        else if (iconCode.equals("10n")) {
            image.setImageResource(R.drawable.tenn);
            if(isQuotation)
                quote.setText("I could sit inside all day");
        }
        else if (iconCode.equals("11d")) {
            image.setImageResource(R.drawable.elevend);
            if(isQuotation)
                quote.setText("I can feel the storm SURGING!");
        }
        else if (iconCode.equals("11n")) {
            image.setImageResource(R.drawable.elevenn);
            if(isQuotation)
                quote.setText("I can feel the storm SURGING!");
        }
        else if (iconCode.equals("13d")){
            image.setImageResource(R.drawable.thirteend);
            if(isQuotation)
                quote.setText("If you go outside in this weather, I will taze you and watch Supernnany while you drool on the carpet.");
        }
        else if(iconCode.equals("13n")) {
            image.setImageResource(R.drawable.thirteenn);
            if(isQuotation)
                quote.setText("If you go outside in this weather, I will taze you and watch Supernnany while you drool on the carpet.");
        }
        else if(iconCode.equals("50d")) {
            image.setImageResource(R.drawable.fiftyd);
            if(isQuotation)
                quote.setText("Happy! We'are all standing! Bunch of guardians standing in a foggy circle");
        }
        else if(iconCode.equals("50n")) {
            image.setImageResource(R.drawable.fiftyn);
            if(isQuotation)
                quote.setText("Happy! We'are all standing! Bunch of guardians standing in a foggy circle");
        }
    }

    public int rounder(String s){
        Double newTempDouble = (Double.parseDouble(s));
        int newTempInt = (int)Math.rint(newTempDouble);
        return newTempInt;
    }
    public int timeConverter(String s){
        int twoDigit = Integer.parseInt(s);
        twoDigit -= 5;
        if(twoDigit == -5)
            twoDigit = 19;
        else if(twoDigit == -4)
            twoDigit = 20;
        else if(twoDigit == -3)
            twoDigit = 21;
        else if(twoDigit == -2)
            twoDigit = 22;
        else if(twoDigit == -1)
            twoDigit = 23;
        twoDigit %= 12;

        return twoDigit;
    }

    public class APIKeyCall extends AsyncTask<String, Void, Void>{

        @Override
        protected Void doInBackground(String...params){
            jsonInformation = "";
            try {
                information = new URL("https://api.openweathermap.org/data/2.5/forecast?zip=" + params[0] + "&appid=64efa4989f6cc6281d5ef2e44b2740d1&units=imperial");
                connectInformation = information.openConnection();
                inputStream = connectInformation.getInputStream();
            } catch (Exception e) {
                e.printStackTrace();
            }

            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String st;
            try {
                while ((st = bufferedReader.readLine()) != null) {
                    System.out.println(st);
                    jsonInformation += st;
                }
            }catch(IOException e){}

            try {
                weatherPresentInfo = new JSONObject(jsonInformation);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void v) {
            super.onPostExecute(v);

            try {
                JSONArray listCarry = weatherPresentInfo.getJSONArray("list");

                weatherPresent = (JSONObject)listCarry.get(0);
                descriptionPresent = new JSONObject(weatherPresent.getJSONArray("weather").get(0).toString());
                String tempAverage = weatherPresent.getJSONObject("main").getString("temp");
                String forecast = descriptionPresent.getString("description");
                String icon = descriptionPresent.getString("icon");
                setImageResources(currentImage, icon, true);
                currentTemp.setText(rounder(tempAverage) + "°F");
                currentForecast.setText(forecast);


                weatherTriOne = (JSONObject)listCarry.get(1);
                descriptionTriOne = new JSONObject(weatherTriOne.getJSONArray("weather").get(0).toString());
                String minTempOne = weatherTriOne.getJSONObject("main").getString("temp_min");
                String maxTempOne = weatherTriOne.getJSONObject("main").getString("temp_max");
                String iconOne = descriptionTriOne.getString("icon");
                String timeOne = weatherTriOne.getString("dt_txt").substring(11, 13);

                timeTriOne.setText(timeConverter(timeOne)+ ":00");
                tempMinTriOne.setText("Low:" + rounder(minTempOne) + "°F");
                tempMaxTriOne.setText("High:" + rounder(maxTempOne) + "°F");
                setImageResources(imageTriOne, iconOne, false);


                weatherTriTwo = (JSONObject)listCarry.get(2);
                descriptionTriTwo = new JSONObject(weatherTriTwo.getJSONArray("weather").get(0).toString());
                String minTempTwo = weatherTriTwo.getJSONObject("main").getString("temp_min");
                String maxTempTwo = weatherTriTwo.getJSONObject("main").getString("temp_max");
                String iconTwo = descriptionTriTwo.getString("icon");
                String timeTwo = weatherTriTwo.getString("dt_txt").substring(11, 13);

                timeTriTwo.setText(timeConverter(timeTwo)+ ":00");
                tempMinTriTwo.setText("Low:" + rounder(minTempTwo) + "°F");
                tempMaxTriTwo.setText("High:" + rounder(maxTempTwo) + "°F");
                setImageResources(imageTriTwo, iconTwo, false);


                weatherTriThree = (JSONObject)listCarry.get(3);
                descriptionTriThree = new JSONObject(weatherTriThree.getJSONArray("weather").get(0).toString());
                String minTempThree = weatherTriThree.getJSONObject("main").getString("temp_min");
                String maxTempThree = weatherTriThree.getJSONObject("main").getString("temp_max");
                String iconThree = descriptionTriThree.getString("icon");
                String timeThree = weatherTriThree.getString("dt_txt").substring(11, 13);

                timeTriThree.setText(timeConverter(timeThree)+ ":00");
                tempMinTriThree.setText("Low:" + rounder(minTempThree) + "°F");
                tempMaxTriThree.setText("High:" + rounder(maxTempThree) + "°F");
                setImageResources(imageTriThree, iconThree, false);


                weatherTriFour = (JSONObject)listCarry.get(4);
                descriptionTriFour = new JSONObject(weatherTriFour.getJSONArray("weather").get(0).toString());
                String minTempFour = weatherTriFour.getJSONObject("main").getString("temp_min");
                String maxTempFour = weatherTriFour.getJSONObject("main").getString("temp_max");
                String iconFour = descriptionTriFour.getString("icon");
                String timeFour = weatherTriFour.getString("dt_txt").substring(11, 13);

                timeTriFour.setText(timeConverter(timeFour)+ ":00");
                tempMinTriFour.setText("Low:" + rounder(minTempFour) + "°F");
                tempMaxTriFour.setText("High:" + rounder(maxTempFour) + "°F");
                setImageResources(imageTriFour, iconFour, false);


                weatherTriFive = (JSONObject)listCarry.get(5);
                descriptionTriFive = new JSONObject(weatherTriFive.getJSONArray("weather").get(0).toString());
                String minTempFive = weatherTriFive.getJSONObject("main").getString("temp_min");
                String maxTempFive = weatherTriFive.getJSONObject("main").getString("temp_max");
                String iconFive = descriptionTriFive.getString("icon");
                String timeFive = weatherTriFive.getString("dt_txt").substring(11, 13);

                timeTriFive.setText(timeConverter(timeFive)+ ":00");
                tempMinTriFive.setText("Low:" + rounder(minTempFive) + "°F");
                tempMaxTriFive.setText("High:" + rounder(maxTempFive) + "°F");
                setImageResources(imageTriFive, iconFive, false);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



}
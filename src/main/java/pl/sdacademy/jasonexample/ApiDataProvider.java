package pl.sdacademy.jasonexample;

import com.google.gson.*;

import javax.persistence.GeneratedValue;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ApiDataProvider {


    public static ArrayList<CountryCases> createObjects(String fileName) throws FileNotFoundException {
        ArrayList<CountryCases> arrayList = new ArrayList<>();
        File file = new File("src/main/resources/" + fileName);
        Scanner scanner = new Scanner(file);
        StringBuilder text = new StringBuilder();
        while(scanner.hasNext()) {
            text.append(scanner.nextLine());
        }
        JsonParser parser = new JsonParser();

        Object obj = parser.parse(text.toString());
        JsonArray jsonArray = (JsonArray) obj;

        for(JsonElement element : jsonArray){
            JsonObject jsonObject = element.getAsJsonObject();

            String country = jsonObject.get("country").getAsString();

            Integer cases = jsonObject.get("cases").getAsInt();

            arrayList.add(new CountryCases(country,cases));
        }
        return arrayList;
    }

    public static List<CovidApi> createObjects() throws IOException {
        List<CovidApi> arrayList = new ArrayList<>();
        JsonParser parser = new JsonParser();

        URL jsonUrl = new URL("https://api.covid19api.com/dayone/country/south-africa/status/confirmed");
        URLConnection yc = jsonUrl.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        String inputLine;

        while((inputLine=in.readLine())!=null){
            JsonArray jsonArray = (JsonArray) parser.parse(inputLine);

            for(JsonElement element : jsonArray){
                JsonObject jsonObject = element.getAsJsonObject();

                String country = jsonObject.get("Country").getAsString();
                String countryCode = jsonObject.get("CountryCode").getAsString();
                String province = jsonObject.get("Province").getAsString();
                String city = jsonObject.get("City").getAsString();

                Integer cityCode;
                String strCityCode = jsonObject.get("CityCode").getAsString();
                if(!strCityCode.isEmpty()) cityCode = jsonObject.get("cityCode").getAsInt();
                else cityCode = null;

                Float lat;
                String strLat = jsonObject.get("Lat").getAsString();
                if(!strLat.isEmpty()) lat = jsonObject.get("Lat").getAsFloat();
                else lat = null;

                Float lon;
                String strLon = jsonObject.get("Lon").getAsString();
                if(!strLon.isEmpty()) lon = jsonObject.get("Lon").getAsFloat();
                else lon = null;

                Integer cases;
                String strCases = jsonObject.get("Cases").getAsString();
                if(!strCases.isEmpty()) cases = jsonObject.get("Cases").getAsInt();
                else cases = null;


                String status = jsonObject.get("Status").getAsString();
                String date = jsonObject.get("Status").getAsString();

                arrayList.add(new CovidApi(country, countryCode, province, city, cityCode, lat, lon, cases, status, date));

            }
        }

        return arrayList;
    }

}

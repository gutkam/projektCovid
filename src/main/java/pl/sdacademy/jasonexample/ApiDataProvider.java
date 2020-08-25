package pl.sdacademy.jasonexample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ApiDataProvider {


    public static ArrayList<CountryCases> createObjects(String fileName) throws FileNotFoundException {
        return parseCountryCases("src/main/resources/" + fileName);
    }

    public static ArrayList<CountryCases> createObjects() throws FileNotFoundException {
        return parseCountryCases("src/main/resources/data.json");
    }

    private static ArrayList<CountryCases> parseCountryCases(String filePath) throws FileNotFoundException {
        ArrayList<CountryCases> countryCasesArrayList = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonArray jsonArray = (JsonArray) parser.parse(new FileReader(filePath));
        for(JsonElement element : jsonArray){
            JsonObject jsonObject = element.getAsJsonObject();

            String country = jsonObject.get("country").getAsString();
            Integer cases = jsonObject.get("cases").getAsInt();
            countryCasesArrayList.add(new CountryCases(country,cases));
        }

        return countryCasesArrayList;
    }
}

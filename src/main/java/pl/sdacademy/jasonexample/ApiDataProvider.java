package pl.sdacademy.jasonexample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
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

    public static ArrayList<CountryCases> createObjects() throws FileNotFoundException {
        ArrayList<CountryCases> arrayList = new ArrayList<>();
        File file = new File("src/main/resources/data.json");
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



}

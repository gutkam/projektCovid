package pl.sdacademy.jasonexample;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        ArrayList arrayList = new ArrayList();

        Object obj = parser.parse(new FileReader("projektCovid/src/main/resources/example.json"));
        JsonArray jsonArray = (JsonArray) obj;


        for(JsonElement jsonElement : jsonArray){
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            String country = jsonObject.get("country").getAsString();
            int cases = jsonObject.get("cases").getAsInt();

            arrayList.add(new CountryCases(country,cases));
        }

        arrayList.toString();
    }
}

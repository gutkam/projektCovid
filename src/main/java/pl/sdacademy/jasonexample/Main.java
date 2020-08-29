package pl.sdacademy.jasonexample;

import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        List<CountryCases> arrayList = new ArrayList<>();
        File file = new File("src/main/resources/example.json");
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

        System.out.println(ApiDataProvider.createObjects("example.json").toString());


    }
}

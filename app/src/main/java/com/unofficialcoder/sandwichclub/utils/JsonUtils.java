package com.unofficialcoder.sandwichclub.utils;


import com.unofficialcoder.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = new Sandwich();
        try{
            JSONObject rootObject = new JSONObject(json);
            //name object
            JSONObject nameObject = rootObject.getJSONObject("name");
            //mainName
            sandwich.setMainName(nameObject.getString("mainName"));
            //alsoKnownAs
            JSONArray alsoKnownNameArray = nameObject.getJSONArray("alsoKnownAs");
            List<String> otherNames = new ArrayList<>();
            if(alsoKnownNameArray.length() != 0){
                for (int i=0; i<alsoKnownNameArray.length(); i++){
                    otherNames.add(alsoKnownNameArray.getString(i));
                }
            }
            sandwich.setAlsoKnownAs(otherNames);
            //placeOfOrigin
            sandwich.setPlaceOfOrigin(rootObject.getString("placeOfOrigin"));
            //description
            sandwich.setDescription(rootObject.getString("description"));
            //image
            sandwich.setImage(rootObject.getString("image"));
            //ingredients
            JSONArray ingredientsArray = rootObject.getJSONArray("ingredients");
            List<String> ingredients = new ArrayList<String>();
            if(ingredientsArray.length() != 0){
                for (int i=0; i<ingredientsArray.length(); i++){
                    ingredients.add(ingredientsArray.getString(i));
                }
            }
            sandwich.setIngredients(ingredients);

        }catch (Exception e){
            e.printStackTrace();
        }
        return sandwich;
    }
}

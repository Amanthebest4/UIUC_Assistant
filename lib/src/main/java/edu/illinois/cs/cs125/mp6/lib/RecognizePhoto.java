package edu.illinois.cs.cs125.mp6.lib;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public final class RecognizePhoto {



    /**
     * Get the image width.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width of the image or 0 on failure
     */
    public static int getWidth(final String json) {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int width = jsonObject.getAsJsonObject("metadata").get("width").getAsInt();
        return width;
    }

    /**
     * Get the image height.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width of the image or 0 on failure
     */
    public static int getHeight(final String json) {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        int height = jsonObject.getAsJsonObject("metadata").get("height").getAsInt();
        return height;
    }

    /**
     * Get the image file type.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the type of the image or null
     */
    public static String getFormat(final String json) {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String format = jsonObject.getAsJsonObject("metadata").get("format").getAsString();
        return format;
    }

    /**
     * Return the caption describing the image created by the Microsoft Cognitive Services API.
     * If multiple captions are provided your code should return the first one.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the caption describing the image created by the Microsoft or null on failure
     */
    public static String getCaption(final String json) {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject().getAsJsonObject("description");
        JsonArray jsonArray = jsonObject.getAsJsonArray("captions");
        String caption = jsonArray.get(0).getAsJsonObject().get("text").getAsString();
        return caption;
        //return jsonObject.toString();
    }

    /**
     * Determine whether the image contains a dog.
     * You should do this by examining the tags returned by the Cognitive Services API.
     * If a tag with the name "dog" exists with at least the provided confidence,
     * you should return true. Otherwise false.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @param minConfidence the minimum confidence required for this determination
     * @return a boolean indicating whether the image contains a dog or false on failure
     */
    public static boolean isADog (final String json, double minConfidence) {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("tags");
        if (jsonArray == null) { return false; }
        for (int i = 0; i < jsonArray.size(); i++) {
            if (jsonArray.get(i).getAsJsonObject().get("name").getAsString()
                    .toLowerCase().contains("dog")) {
                if (jsonArray.get(i).getAsJsonObject().get("confidence").getAsDouble() >= minConfidence) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    /**
     * Determine whether the image contains a cat.
     * You should do this by examining the tags returned by the Cognitive Services API.
     * If a tag with the name "cat" exists with at least the provided confidence,
     * you should return true. Otherwise false.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @param minConfidence the minimum confidence required for this determination
     * @return a boolean indicating whether the image contains a dog or false on failure
     */
    public static boolean isACat (final String json, double minConfidence) {
        JsonElement jsonElement = new JsonParser().parse(json);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("tags");
        if (jsonArray == null) { return false; }
        for (int i = 0; i < jsonArray.size(); i++) {
            if (jsonArray.get(i).getAsJsonObject().get("name").getAsString()
                    .toLowerCase().contains("cat")) {
                if (jsonArray.get(i).getAsJsonObject().get("confidence").getAsDouble() >= minConfidence) {
                    return true;
                }
                break;
            }
        }
        return false;
    }

    /**
     * Check if image contains Rick Astley.
     * We leave it to you to determine how to do this by examining the
     * JSON returned for various images.
     * Note that you do not need to consider the confidence value to complete this function.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return true if you've Rickrolled yourself
     */
    public static boolean isRick (final String json) {
        return false;
    }
}

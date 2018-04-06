package edu.illinois.cs.cs125.mp6.lib;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

//import jdk.nashorn.internal.parser.JSONParser;

public final class RecognizePhoto {



    /**
     * Get the image width.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width of the image or 0 on failure
     */
    public static int getWidth(final String json) {
        JsonParser parser = new JsonParser();
        JsonObject widthObject = parser.parse(json).getAsJsonObject();
        int width = widthObject.get("width").getAsInt();
        return width;
    }

    /**
     * Get the image height.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the width of the image or 0 on failure
     */
    public static int getHeight(final String json) {
        JsonParser parser = new JsonParser();
        JsonObject heightObject = parser.parse(json).getAsJsonObject();
        int height = heightObject.get("height").getAsInt();
        return height;
    }

    /**
     * Get the image file type.
     *
     * @param json the JSON string returned by the Microsoft Cognitive Services API
     * @return the type of the image or null
     */
    public static String getFormat(final String json) {
        JsonParser parser = new JsonParser();
        JsonObject formatObject = parser.parse(json).getAsJsonObject();
        String format = formatObject.get("format").getAsString();
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
        JsonParser parser = new JsonParser();
        JsonObject captionObject = parser.parse(json).getAsJsonObject();
        String caption = captionObject.get("captions").getAsString();
        System.out.println(caption);
        return caption;
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

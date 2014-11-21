package ua.bugfreeadventure.utils;

import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtil {


    public static String notNullString(JsonNode object, String field) {

        if (object != null && object.has(field)) {

            String result = "";
            result = object.get(field).asText();

            if (result != null) {
                if (!result.equals(String.valueOf("null"))) {
                    return result;
                }
            } else
                return "";

        } else
            return "";

        return "";
    }



    public static int notNullInt(JsonNode object, String field) {

            if (object != null && object.has(field)) {

                return object.get(field).asInt();

            } else
                return 0;

    }

    public static long notNullLong(JsonNode object, String field) {

        if (object != null && object.has(field)) {

            return object.get(field).asLong();

        } else
            return 0;

    }


    public static double notNullDouble(JsonNode object, String field) {

            if (object != null && object.has(field)) {

                return object.get(field).asDouble();

            } else
                return 0.0;

    }


    public static boolean notNullBoolean(JsonNode object, String field) {

        if (object != null && object.has(field)) {

            return object.get(field).asBoolean();

        } else
            return false;

    }


}
package ua.bugfreeadventure.httpclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by DrLietto on 29.07.2014.
 */
public class NextResponse {

    private JsonNode rootNode;
    private boolean isSuccessful;


    public NextResponse(Response response) {

        if (response != null) {
            this.isSuccessful = response.isSuccessful();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                rootNode = objectMapper.readTree(response.body().bytes());

            } catch (IOException e) {

            }
        } else {

        }

    }

    public JsonNode getRootNode() {
        return rootNode;
    }


    public boolean isSuccessful() {
        return isSuccessful;
    }


}

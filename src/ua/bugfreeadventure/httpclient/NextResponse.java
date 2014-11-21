package ua.bugfreeadventure.httpclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

/**
 * Created by DrLietto on 29.07.2014.
 */
public class NextResponse {

    private JsonNode rootNode;
    protected JsonNode body;
    private boolean isSuccessful;
    private boolean isExist = true;

    public NextResponse(Response response) {

        if (response != null) {

            this.isSuccessful = response.isSuccessful();

            ObjectMapper objectMapper = new ObjectMapper();
            try {
                rootNode = objectMapper.readTree(response.body().bytes());


            } catch (IOException e) {

            }

        } else {
            isExist = false;
            this.isSuccessful = false;

        }
    }

    public JsonNode getBody() {
        return body;
    }

    public final JsonNode getBody(String bodyName) {
        if (body == null)
            this.body = rootNode.get(bodyName);
        return body;
    }

    public void setBody(String bodyName) {
        this.body = rootNode.get(bodyName);
    }


    public JsonNode getRootNode() {
        return rootNode;
    }


    public boolean isSuccessful() {
        return isSuccessful;
    }


}

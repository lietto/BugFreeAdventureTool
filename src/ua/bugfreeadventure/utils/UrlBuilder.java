package ua.bugfreeadventure.utils;

import ua.bugfreeadventure.httpclient.NextControlers;
import ua.bugfreeadventure.httpclient.NextMethods;

/**
 * Created by lietto on 30.07.2014.
 */
public class UrlBuilder {

    private static final String BASE_URL = "";
    private StringBuilder url;



    public UrlBuilder() {
        url = new StringBuilder(BASE_URL);
    }

    public static UrlBuilder get() {
        return new UrlBuilder();
    }

    public UrlBuilder controller(NextControlers controler) {
        url.append(controler.name()).append("/");
        return this;
    }

    public String method(NextMethods method){
        String s = url.append(method.name()).toString();
        return s;
    }
}

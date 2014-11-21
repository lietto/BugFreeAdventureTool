package ua.bugfreeadventure.httpclient;

/**
 * Created by lietto on 29.07.2014.
 */
public enum NextError {

    NO_RESPONSE, NO_SERVER_CONNECTION, NO_INTERNET_CONNECTION, INTERNALL_APP_ERROR, JSON_ERROR;

    public String getMessage() {
        switch (this) {
            case NO_RESPONSE:
                return "No actual response from server!";
            case NO_SERVER_CONNECTION:
                return "No server connection! Please, try later!";
            case NO_INTERNET_CONNECTION:
                return "No internet connection!";
            case INTERNALL_APP_ERROR:
                return "Internal app error!";
            case JSON_ERROR:
                return "Incorrect server response!";

        }
        return "Неизвестная ошибка!";
    }
}

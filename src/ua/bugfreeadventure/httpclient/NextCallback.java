package ua.bugfreeadventure.httpclient;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.fasterxml.jackson.databind.JsonNode;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import ua.bugfreeadventure.notifications.DevToast;
import ua.bugfreeadventure.utils.Connectivity;

import java.io.IOException;

/**
 * Created by DrLietto on 28.07.2014.
 */
public abstract class NextCallback implements Callback {

    private Context context;
    private NextError error;

    public NextCallback() {

    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setError(NextError error) {
        this.error = error;
    }

    public NextError getError() {
        return error;
    }

    private Handler responseHandler = new Handler();


    @Override
    public void onFailure(Request request, IOException e) {

        if (error == null)
            if (context != null)
                if (Connectivity.isConnected(context)) {
                    error = NextError.NO_SERVER_CONNECTION;

                } else {
                    error = NextError.NO_INTERNET_CONNECTION;
                }
            else
                error = NextError.INTERNALL_APP_ERROR;

        responseHandler.post(new Runnable() {
            @Override
            public void run() {
                DevToast.context(context).showRed(error.getMessage());
                error(error);
            }
        });


    }

    @Override
    public void onResponse(final Response response) throws IOException {

        final NextResponse next = new NextResponse(response);

        responseHandler.post(new Runnable() {
            @Override
            public void run() {

                if (response != null) {

                    if (response.isSuccessful()) {
                        success(next);
                    } else {
                        nonSuccess(next);
                    }

                } else {
                    error(NextError.NO_RESPONSE);
                }
            }
        });
    }

    public abstract void success(NextResponse response);

    public abstract void nonSuccess(NextResponse response); // all http-codes except 2**

    public void redirect() {

    }

    public abstract void error(NextError error);

}

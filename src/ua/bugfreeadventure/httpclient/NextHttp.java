package ua.bugfreeadventure.httpclient;

import android.content.Context;
import android.widget.ImageView;
import com.squareup.okhttp.*;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.UrlConnectionDownloader;
import ua.bugfreeadventure.utils.UrlBuilder;

import java.util.HashMap;

/**
 * Created by lietto on 28.07.2014.
 */
public class NextHttp {

    private static OkHttpClient client = new OkHttpClient();
    private static Picasso picasso;
    protected Context context;

    private static NextHttp nextHttp;

    /*Usage:
    *
    *NextHttp.connection(this).call(callback);
    *
    * */


    private static NextHttp nextHttp(Context context) {
        if (nextHttp == null)
            nextHttp = new NextHttp();
        nextHttp.context = context;
        return nextHttp;
    }

    protected static OkHttpClient client() {
        if (client == null)
            client = new OkHttpClient();
        return client;
    }

    public static NextHttp connection(Context aContext) {
        return nextHttp(aContext);
    }

    public static Picasso picasso(Context ctx) {
           if (picasso == null) {
               UrlConnectionDownloader c = new UrlConnectionDownloader(ctx);
               picasso = new Picasso.Builder(ctx).downloader(c).build();
           }
        return picasso;
    }

    public static Picasso loadImageInto(ImageView view, String url) {
        if (picasso == null) {
            UrlConnectionDownloader c = new UrlConnectionDownloader(view.getContext().getApplicationContext());
            picasso = new Picasso.Builder(view.getContext().getApplicationContext()).downloader(c).build();
        }
        if (!url.equals("")) {
            picasso.load(url).into(view);
        }

        return picasso;
    }

    /*Example of how to use call to API server*/
    final private void post(HashMap<String, String> params, NextCallback callback) {

        FormEncodingBuilder builder = new FormEncodingBuilder();

        for (String p : params.keySet()) {
            builder.add(p, params.get(p));
        }

        RequestBody formBody = builder
                .build();

        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url(
                        UrlBuilder
                                .get()
                                .controller(NextControlers.controller)
                                .method(NextMethods.method)
                )
//                .header("Authorization", "Basic " + Authentication.getInstance(context).getUserBase())
                .post(formBody).tag(NextMethods.method)
                .build();

        Call epgCall = client().newCall(request);

        callback.setContext(context);

        epgCall.enqueue(callback);
    }


}

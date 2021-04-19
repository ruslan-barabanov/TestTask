package util;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

public class FluentApi {

    private static final String REQUESTPOST = PathsProperties.getProperty("requestPost.path");

    public static String sendPostGetToken(String variant) {
        Collection<NameValuePair> params = new ArrayList<>();
        String request = null;
        try {
            request = Request.Post(REQUESTPOST + variant)
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent().asString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }
}


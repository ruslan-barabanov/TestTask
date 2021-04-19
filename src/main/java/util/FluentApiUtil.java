package util;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;

public class FluentApiUtil {

    private static final String REQUEST_POST = PathsPropertiesUtil.getProperty("requestPost.path");

    public static Content sendPostGetToken(String endpoint, String variant) {
        Collection<NameValuePair> params = new ArrayList<>();
        Content request = null;
        try {
            request = Request.Post(REQUEST_POST + endpoint + variant)
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return request;
    }
}


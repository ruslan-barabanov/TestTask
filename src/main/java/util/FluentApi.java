package util;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class FluentApi {

    private static final Properties properties = PathsProperties.readFile();
    private static final String requestPost = properties.getProperty("requestPost.path");

    public static String sendPostGetToken() throws IOException {
        int myVariant = 4;
        Collection<NameValuePair> params = new ArrayList<>();

        return Request.Post(requestPost + myVariant)
                    .bodyForm(params, Charset.defaultCharset())
                    .execute().returnContent().asString();
    }
}
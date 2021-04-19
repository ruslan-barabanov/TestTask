package test.java.testAutomationSelfEducation.api;

import util.FluentApiUtil;

public class SelfEducationApi {

    public static String getToken(String variant) {
        String response = FluentApiUtil.sendPostGetToken("/token/get?variant=", variant);
        return response;
    }
}

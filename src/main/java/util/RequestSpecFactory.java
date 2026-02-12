package util;

import config.ConfigManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecFactory {

    public static RequestSpecification defaultSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.get("base.url"))
                .setBasePath(ConfigManager.get("api.base.path"))
                .addFilter(new AllureRestAssured())
                .build();
    }
}

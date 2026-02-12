package client;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import util.RequestSpecFactory;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class AutomationExerciseClient {

    private final RequestSpecification spec = RequestSpecFactory.defaultSpec();

    // API 1
    public Response getAllProducts() {
        return given().spec(spec).when().get("/productsList");
    }

    // API 2
    public Response postProductsList() {
        return given().spec(spec).when().post("/productsList");
    }

    // API 3
    public Response getAllBrands() {
        return given().spec(spec).when().get("/brandsList");
    }

    // API 4
    public Response putBrandsList() {
        return given().spec(spec).when().put("/brandsList");
    }

    // API 5
    public Response searchProduct(Map<String, String> form) {
        return given().spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .formParams(form)
                .when().post("/searchProduct");
    }

    // API 6
    public Response searchProductWithoutParam() {
        return given().spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .when().post("/searchProduct");
    }

    // API 7 / 8 / 9 / 10 use same endpoint
    public Response verifyLogin(Map<String, String> form) {
        return given().spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .formParams(form)
                .when().post("/verifyLogin");
    }

    public Response verifyLoginNoParams() {
        return given().spec(spec).when().post("/verifyLogin");
    }

    public Response verifyLoginDelete() {
        return given().spec(spec).when().delete("/verifyLogin");
    }

    // API 11 / 12 / 13 / 14
    public Response createAccount(Map<String, String> form) {
        return given().spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .formParams(form)
                .when().post("/createAccount");
    }

    public Response deleteAccount(Map<String, String> form) {
        return given().spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .formParams(form)
                .when().delete("/deleteAccount");
    }

    public Response updateAccount(Map<String, String> form) {
        return given().spec(spec)
                .contentType("application/x-www-form-urlencoded")
                .formParams(form)
                .when().put("/updateAccount");
    }

    public Response getUserDetailByEmail(String email) {
        return given().spec(spec)
                .queryParam("email", email)
                .when().get("/getUserDetailByEmail");
    }
}

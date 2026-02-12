package apitests;

import client.AutomationExerciseClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestDataFactory;

import java.util.HashMap;
import java.util.Map;

public class ApiTestCases {

    @BeforeMethod
    public void printThreadInfo() {
        System.out.println(
                "THREAD=" + Thread.currentThread().getId() +
                        " | API TEST=" + this.getClass().getSimpleName()
        );
    }


    private final AutomationExerciseClient client = new AutomationExerciseClient();

    private void logTitle(String title) {
        System.out.println("\n\n ");
        System.out.println(title);
        System.out.println("  ");
    }

    private void printResponse(Response res) {
        System.out.println("HTTP Status: " + res.statusCode());
        System.out.println("Response JSON:");
        res.prettyPrint();
    }


    // This API usually returns HTTP 200 and uses responseCode inside JSON
    private void assertApiResponseCode(Response res, int expectedResponseCode) {
        Assert.assertEquals(res.statusCode(), 200, "HTTP status should be 200. Body: " + res.asString());
        int actual = res.jsonPath().getInt("responseCode");
        Assert.assertEquals(actual, expectedResponseCode, "Wrong responseCode. Body: " + res.asString());
    }

    private void assertMessageContains(Response res, String expected) {
        String msg = res.jsonPath().getString("message");
        Assert.assertNotNull(msg, "message is null. Body: " + res.asString());
        Assert.assertTrue(msg.toLowerCase().contains(expected.toLowerCase()),
                "Expected message to contain '" + expected + "' but got: " + msg);
    }


    // API 1: GET All Products
    @Test
    public void API_01_GetAllProductsList() {
        logTitle("API 01 - GET All Products List");
        Response res = client.getAllProducts();
        printResponse(res);

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertTrue(res.asString().contains("products"), "Products key not found in response");
    }


    // API 2: POST Products List (Not Supported)
    @Test
    public void API_02_PostToProductsList_NotSupported() {
        logTitle("API 02 - POST Products List (Not Supported)");
        Response res = client.postProductsList();
        printResponse(res);

        assertApiResponseCode(res, 405);
        assertMessageContains(res, "not supported");
    }


    // API 3: GET All Brands
    @Test
    public void API_03_GetAllBrandsList() {
        logTitle("API 03 - GET All Brands List");
        Response res = client.getAllBrands();
        printResponse(res);

        Assert.assertEquals(res.statusCode(), 200);
        Assert.assertTrue(res.asString().contains("brands"), "Brands key not found in response");
    }


    // API 4: PUT Brands List (Not Supported)
    @Test
    public void API_04_PutToBrandsList_NotSupported() {
        logTitle("API 04 - PUT Brands List (Not Supported)");
        Response res = client.putBrandsList();
        printResponse(res);

        assertApiResponseCode(res, 405);
        assertMessageContains(res, "not supported");
    }


    // API 5: POST Search Product
    @Test
    public void API_05_SearchProduct() {
        logTitle("API 05 - POST Search Product");
        Map<String, String> form = new HashMap<>();
        form.put("search_product", "top");

        Response res = client.searchProduct(form);
        printResponse(res);

        Assert.assertEquals(res.statusCode(), 200);
        assertApiResponseCode(res, 200);
        Assert.assertTrue(res.asString().contains("products"), "Products not found in search response");
    }

    // API 6: POST Search Product without parameter
    @Test
    public void API_06_SearchProduct_WithoutParam() {
        logTitle("API 06 - Search Product Without Param");
        Response res = client.searchProductWithoutParam();
        printResponse(res);

        assertApiResponseCode(res, 400);
        assertMessageContains(res, "bad request");
    }


    // API 7: POST Verify Login with valid details
    @Test
    public void API_07_VerifyLogin_Valid() {
        logTitle("API 07 - Verify Login (Valid)");
        String email = TestDataFactory.uniqueEmail();
        String password = "Pass12345!";

        var user = TestDataFactory.newUser(email, password);
        Response createRes = client.createAccount(TestDataFactory.toFormParams(user));
        printResponse(createRes);
        assertApiResponseCode(createRes, 201);

        Map<String, String> login = new HashMap<>();
        login.put("email", email);
        login.put("password", password);

        Response res = client.verifyLogin(login);
        printResponse(res);

        assertApiResponseCode(res, 200);
        assertMessageContains(res, "user exists");
    }

    // API 8: POST Verify Login without email parameter
    @Test
    public void API_08_VerifyLogin_WithoutEmail() {
        logTitle("API 08 - Verify Login Without Email");
        Map<String, String> login = new HashMap<>();
        login.put("password", "any");

        Response res = client.verifyLogin(login);
        printResponse(res);

        assertApiResponseCode(res, 400);
        assertMessageContains(res, "bad request");
    }

    // API 9: DELETE Verify Login (Not Supported)
    @Test
    public void API_09_DeleteVerifyLogin_NotSupported() {
        logTitle("API 09 - DELETE Verify Login (Not Supported)");
        Response res = client.verifyLoginDelete();
        printResponse(res);

        assertApiResponseCode(res, 405);
        assertMessageContains(res, "not supported");
    }

    // API 11: POST Create Account
    @Test
    public void API_11_CreateAccount() {
        logTitle("API 11 - Create Account");
        String email = TestDataFactory.uniqueEmail();
        String password = "Pass12345!";

        var user = TestDataFactory.newUser(email, password);
        Response res = client.createAccount(TestDataFactory.toFormParams(user));
        printResponse(res);

        assertApiResponseCode(res, 201);
        assertMessageContains(res, "created");
    }
}

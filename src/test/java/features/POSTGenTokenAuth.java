package features;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import models.GenToken;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class POSTGenTokenAuth {

    GenToken genToken;

    @BeforeClass
    public void beforeClass() {

        // get Instance của class GenToKen
        genToken = GenToken.getInstanceGenToken();

        // Khai báo URL
        /*RestAssured.baseURI = "http://192.168.68.124";
        RestAssured.basePath = "/api/1/auth/token/issue";
        RestAssured.port = 8080;*/
    }

    @Test
    public void createTokenAuth() {

        // Khởi tạo Class GenToken và truyền giá trị vào
        //genToken.setUsername(genToken.getUsername());
        //genToken.setPassword(genToken.getPassword());

        // Config và gọi API
        Response res = given()
                .contentType(ContentType.JSON)
                .header("X-Rootvia-Client-Id", "sys_admin")
                .when()
                .body(genToken)
                .post("http://192.168.68.124:8080/api/1/auth/token/issue");

        //verify kết quả trả về
        res.then().statusCode(200);

        System.out.println("Status line: " + res.getStatusLine());
        System.out.println("Pretty Print: " + res.prettyPrint());
        //System.out.println("Header: " + res.headers());
        System.out.println("Header value: " + res.header("Content-Type"));
        for(Header header : res.headers()) {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        System.out.println("body: " + res.body());

        String bodyAsString = res.getBody().asString();
        System.out.println("Response body is: " + bodyAsString);
        Assert.assertTrue(bodyAsString.contains("accessToken"));

        // Lấy data từ response
        //JsonPath jsonPathEvaluator = res.jsonPath();
        String accessToken = res.jsonPath().get("accessToken");
        System.out.println("accessToken: " + accessToken);
    }
}

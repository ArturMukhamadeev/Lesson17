package com.example;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("https://postman-echo.com/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRawRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostFormRequest() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .urlEncodingEnabled(true)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .put("https://postman-echo.com/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/put"));
    }

    @Test
    public void testPatchRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("https://postman-echo.com/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .delete("https://postman-echo.com/delete")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}

package rest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.openqa.selenium.json.Json;


import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void successRegTest() {

        Spec.installSpecification(Spec.request(), Spec.responseSpecOk200());
        Response response =
                given()

                        //.body("{ \"userName\": \a@gmail.com\", \"password\": \"1234\" }")
                        .pathParam("userName", "a@gmail.com")
                        .pathParam("password", "1234")
                        .when()
                        .log().all()
                        .post("?")
                        .then()
                        .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> user = jsonPath.get("userName");

    }
}


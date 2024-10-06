package rest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class Spec {
    public static RequestSpecification request = new RequestSpecBuilder()

            .addHeader("Content-Type", "application/json")
            .setBaseUri(EndPoints.URL)
           // .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .setAccept("text/html;charset=UTF-8")
            .log(LogDetail.ALL)
            .build();

    public static RequestSpecification request() {
        return request;    }


    public static ResponseSpecification responseSpecOk200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(lessThan(5000L))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecOk400() {
        return new ResponseSpecBuilder()
                .expectStatusCode(400)
                .expectResponseTime(lessThan(5000L))
                .log(LogDetail.ALL)
                .build();
    }

    public static ResponseSpecification responseSpecOkUnique(int status) {
        return new ResponseSpecBuilder()
                .expectStatusCode(status)
                .expectResponseTime(lessThan(5000L))
                .log(LogDetail.ALL)
                .build();
    }

    public static void installSpecification(RequestSpecification request, ResponseSpecification response) {
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}



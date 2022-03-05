package com.henry;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;

@QuarkusTest
class UserResourceTest {

    @Test
    void testListAllUsers() {

        given()
                .when().get("/users")
                .then()
                .statusCode(200)
                .body(
                        containsString("User1"),
                        containsString("User1"),
                        containsString("User3")
                );


        given()
                .when().delete("/users/1")
                .then()
                .statusCode(204)
        ;


        given()
                .when().get("/users")
                .then()
                .statusCode(200)
                .body(
                        not(containsString("User1")),
                        containsString("User2"),
                        containsString("User3")
                );


        given()
                .when().post("/users/name/Henry/age/30")
                .then()
                .statusCode(200)
                .body(containsString("Henry"))
                .body("id", notNullValue())
                .extract().body().jsonPath().getString("id");


        given()
                .when().get("/users")
                .then()
                .statusCode(200)
                .body(
                        not(containsString("User1")),
                        containsString("User2"),
                        containsString("User3")
                );
    }

    @Test
    void testFindByAge() {

        given()
                .when().get("/users/age/34")
                .then()
                .statusCode(200)
                .body("size()", is(0));


        given()
                .when().get("/users/age/25")
                .then()
                .statusCode(200)
                .body(
                        containsString("User2"),
                        containsString("User4")
                );


        given()
                .when().get("/users/age/28")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body(containsString("User3"));


        given()
                .when().put("/users/id/4/age/25")
                .then()
                .statusCode(200)
                .body(containsString("User4"));


        given()
                .when().get("/users/age/30")
                .then()
                .statusCode(200)
                .body("size()", is(1))
                .body(
                        containsString("Henry")
                );
    }

}

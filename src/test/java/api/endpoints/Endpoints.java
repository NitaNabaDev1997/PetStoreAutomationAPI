package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Endpoints {

    public static Response createUser(User payload)
    {
        Response response=given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.post_url);

        return response;
    }

    public static Response readUser(String username)
    {
        Response response=given()
                .pathParam("username",username)
                .when()
                .get(Routes.get_url);

        return response;
    }

    public static Response UpdateUser(String username,User payload)
    {
        Response response=given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username",username)
                .body(payload)
                .when()
                .put(Routes.update_url);

        return response;
    }

    public static Response DeleteUser(String username)
    {
        Response response=given()
                .pathParam("username",username)
                .when()
                .put(Routes.delete_url);

        return response;
    }
}

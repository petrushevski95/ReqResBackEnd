package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.request.ReqResPostPutCreateUpdateUserModelRequest;
import models.request.ReqResPostRegisterLoginUserModelRequest;
import models.request.ReqResPostUnsuccessfulRegisterLoginModelRequest;

import static utils.Configuration.*;


public class ReqResClient {

    public Response getRequestUsersList(String value) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get(GET_USERS + value)
                .andReturn();
        }

    public Response getRequestSingleUser(String value) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get(GET_CREATE_DELETE_UPDATE_USER + "/" + value)
                .andReturn();
        }

    public Response getRequestResourcesList() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get(GET_RESOURCES)
                .thenReturn();
        }

    public Response getRequestSingleResource(String value) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .get(GET_RESOURCES + "/" + value)
                .thenReturn();
        }

    public Response postCreateUserRequest(ReqResPostPutCreateUpdateUserModelRequest requestBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(GET_CREATE_DELETE_UPDATE_USER)
                .thenReturn();
    }

    public Response putUpdateUserRequest(ReqResPostPutCreateUpdateUserModelRequest requestBody, String value) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .put(GET_CREATE_DELETE_UPDATE_USER + "/" + value)
                .thenReturn();
    }

    public Response patchUpdateUserRequest(ReqResPostPutCreateUpdateUserModelRequest requestBody, String value) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .patch(GET_CREATE_DELETE_UPDATE_USER + "/" + value)
                .thenReturn();
    }

    public Response deleteUserRequest(String value) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .delete(GET_CREATE_DELETE_UPDATE_USER + "/" + value)
                .thenReturn();
    }

    public Response postRegisterUserRequest(ReqResPostRegisterLoginUserModelRequest requestBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(POST_REGISTER_USER)
                .thenReturn();
    }

    public Response postUnsuccessfulRegisterUserRequest(ReqResPostUnsuccessfulRegisterLoginModelRequest requestBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(POST_REGISTER_USER)
                .thenReturn();
    }

    public Response postLoginUserRequest(ReqResPostRegisterLoginUserModelRequest requestBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(POST_LOGIN_USER)
                .thenReturn();
    }

    public Response postUnsuccessfulLoginUserRequest(ReqResPostUnsuccessfulRegisterLoginModelRequest requestBody) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(requestBody)
                .post(POST_LOGIN_USER)
                .thenReturn();
    }

}



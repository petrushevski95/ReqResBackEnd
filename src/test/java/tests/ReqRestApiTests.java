package tests;

import client.ReqResClient;
import io.restassured.response.Response;
import models.request.ReqResPostPutCreateUpdateUserModelRequest;
import models.request.ReqResPostRegisterLoginUserModelRequest;
import models.request.ReqResPostUnsuccessfulRegisterLoginModelRequest;
import models.response.*;
import org.junit.Test;
import utils.HelperClass;

import static org.junit.Assert.*;

public class ReqRestApiTests {

    private Response response;
    private ReqResGetUsersListModelResponse getUserListResponseBody;
    private ReqResGetSingleUserModelResponse getSingleUserResponseBody;
    private ReqResGetResourcesListModelResponse getResourcesListResponseBody;
    private ReqResGetSingleResourceModelResponse getSingleResourceResponseBody;
    private ReqResPostPutCreateUpdateUserModelRequest createUserRequestBody;
    private ReqResPostCreateUserModelResponse createUserResponseBody;
    private ReqResPutUpdateUserModelResponse updateUserResponseBody;
    private ReqResPostRegisterLoginUserModelRequest registerAndLoginUserRequestBody;
    private ReqResPostRegisterUserModelResponse registerUserResponseBody;
    private ReqResPostUnsuccessfulRegisterLoginModelRequest unsuccessfulRegisterAndLoginRequestBody;
    private ReqResPostUnsuccessfulRegisterLoginModelResponse unsuccessfulRegisterAndLoginResponseBody;

    @Test
    public void getUsersListRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        response = new ReqResClient().getRequestUsersList("2");

        getUserListResponseBody = response.body().as(ReqResGetUsersListModelResponse.class);

        assertEquals(200, response.statusCode());
        assertEquals(2, getUserListResponseBody.getPage());
        assertEquals(6, getUserListResponseBody.getPer_page());
        assertEquals(12, getUserListResponseBody.getTotal());
        assertEquals(2, getUserListResponseBody.getTotal_pages());
        assertFalse(getUserListResponseBody.getData().isEmpty());
        assertEquals("https://reqres.in/#support-heading", getUserListResponseBody.getSupport().getUrl());
        assertEquals(supportText, getUserListResponseBody.getSupport().getText());
    }

    @Test
    public void getSingleUserRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        response = new ReqResClient().getRequestSingleUser("2");

        getSingleUserResponseBody = response.body().as(ReqResGetSingleUserModelResponse.class);

        assertEquals(200, response.statusCode());
        assertEquals(2, getSingleUserResponseBody.getData().getId());
        assertEquals("janet.weaver@reqres.in", getSingleUserResponseBody.getData().getEmail());
        assertEquals("Janet", getSingleUserResponseBody.getData().getFirst_name());
        assertEquals("Weaver", getSingleUserResponseBody.getData().getLast_name());
        assertEquals("https://reqres.in/img/faces/2-image.jpg", getSingleUserResponseBody.getData().getAvatar());
        assertEquals("https://reqres.in/#support-heading", getSingleUserResponseBody.getSupport().getUrl());
        assertEquals(supportText, getSingleUserResponseBody.getSupport().getText());
    }

    @Test
    public void getSingleUserNotFoundRequestTest() {
        response = new ReqResClient().getRequestSingleUser("28");

        assertEquals(404, response.statusCode());
    }

    @Test
    public void getResourcesListRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        response = new ReqResClient().getRequestResourcesList();

        getResourcesListResponseBody = response.body().as(ReqResGetResourcesListModelResponse.class);

        assertEquals(200, response.statusCode());
        assertEquals(1, getResourcesListResponseBody.getPage());
        assertEquals(6, getResourcesListResponseBody.getPer_page());
        assertEquals(12, getResourcesListResponseBody.getTotal());
        assertEquals(2, getResourcesListResponseBody.getTotal_pages());
        assertFalse(getResourcesListResponseBody.getData().isEmpty());
        assertEquals("https://reqres.in/#support-heading", getResourcesListResponseBody.getSupport().getUrl());
        assertEquals(supportText, getResourcesListResponseBody.getSupport().getText());
    }

    @Test
    public void getSingleResourceRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        response = new ReqResClient().getRequestSingleResource("5");

        getSingleResourceResponseBody
                = response.body().as(ReqResGetSingleResourceModelResponse.class);

        assertEquals(200, response.statusCode());
        assertEquals(5, getSingleResourceResponseBody.getData().getId());
        assertEquals("tigerlily", getSingleResourceResponseBody.getData().getName());
        assertEquals(2004, getSingleResourceResponseBody.getData().getYear());
        assertEquals("#E2583E", getSingleResourceResponseBody.getData().getColor());
        assertEquals("17-1456", getSingleResourceResponseBody.getData().getPantone_value());
        assertEquals("https://reqres.in/#support-heading", getSingleResourceResponseBody.getSupport().getUrl());
        assertEquals(supportText, getSingleResourceResponseBody.getSupport().getText());
    }

    @Test
    public void getSingleResourceNotFoundRequestTest() {
        response = new ReqResClient().getRequestSingleUser("23");

        assertEquals(404, response.statusCode());
    }

    @Test
    public void postCreateUserRequestTest() {
        createUserRequestBody = HelperClass.createDefaultUserRequestBody();

        response = new ReqResClient().postCreateUserRequest(createUserRequestBody);

        createUserResponseBody = response.as(ReqResPostCreateUserModelResponse.class);

        assertEquals(201, response.statusCode());

        assertEquals(createUserRequestBody.getName(), createUserResponseBody.getName());
        assertEquals(createUserRequestBody.getJob(),createUserResponseBody.getJob());
        assertNotNull(createUserResponseBody.getId());
        assertNotNull(createUserResponseBody.getCreatedAt());
    }

    @Test
    public void putUpdateUserRequestTest() {
        createUserRequestBody = HelperClass.createDefaultUserRequestBody();

        response = new ReqResClient().putUpdateUserRequest(createUserRequestBody, "5");

        updateUserResponseBody = response.as(ReqResPutUpdateUserModelResponse.class);

        assertEquals(200, response.statusCode());

        assertEquals(createUserRequestBody.getName(), updateUserResponseBody.getName());
        assertEquals(createUserRequestBody.getJob(), updateUserResponseBody.getJob());
        assertNotNull(updateUserResponseBody.getUpdatedAt());
    }

    @Test
    public void patchUpdateUserRequestTest() {
        createUserRequestBody = HelperClass.createDefaultUserRequestBody();

        response = new ReqResClient().patchUpdateUserRequest(createUserRequestBody, "5");

        updateUserResponseBody = response.as(ReqResPutUpdateUserModelResponse.class);

        assertEquals(200, response.statusCode());

        assertEquals(createUserRequestBody.getName(),updateUserResponseBody.getName());
        assertEquals(createUserRequestBody.getJob(), updateUserResponseBody.getJob());
        assertNotNull(updateUserResponseBody.getUpdatedAt());
    }

    @Test
    public void deleteUserRequestTest(){
        response = new ReqResClient().deleteUserRequest("5");

        assertEquals(204,response.statusCode());
    }

    @Test
    public void postRegisterUserRequestTest() {
        registerAndLoginUserRequestBody = HelperClass.createDefaultRegisterLoginRequestBody("eve.holt@reqres.in","pistol");

        response = new ReqResClient().postRegisterUserRequest(registerAndLoginUserRequestBody);

        registerUserResponseBody = response.as(ReqResPostRegisterUserModelResponse.class);

        assertEquals(200,response.statusCode());
        assertTrue(registerUserResponseBody.getId() > 0);
        assertFalse(registerUserResponseBody.getToken().isEmpty());
    }

    @Test
    public void postUnsuccessfulRegisterRequestTest() {
        unsuccessfulRegisterAndLoginRequestBody = HelperClass.createUnsuccessfulRegisterLoginRequestBody("sydney@fife");

        response = new ReqResClient().postUnsuccessfulRegisterUserRequest(unsuccessfulRegisterAndLoginRequestBody);

        unsuccessfulRegisterAndLoginResponseBody = response.as(ReqResPostUnsuccessfulRegisterLoginModelResponse.class);

        assertEquals(400,response.statusCode());
        assertEquals("Missing password", unsuccessfulRegisterAndLoginResponseBody.getError());
    }

    @Test
    public void postLoginUserRequestTest() {
        registerAndLoginUserRequestBody = HelperClass.createDefaultRegisterLoginRequestBody("eve.holt@reqres.in","cityslicka");

        response = new ReqResClient().postLoginUserRequest(registerAndLoginUserRequestBody);

        registerUserResponseBody = response.as(ReqResPostRegisterUserModelResponse.class);

        assertEquals(200,response.statusCode());
        assertNotNull(registerUserResponseBody.getToken());
    }

    @Test
    public void postUnsuccessfulLoginRequestTest() {
        unsuccessfulRegisterAndLoginRequestBody = HelperClass.createUnsuccessfulRegisterLoginRequestBody("sydney@fife");

        response = new ReqResClient().postUnsuccessfulLoginUserRequest(unsuccessfulRegisterAndLoginRequestBody);

        unsuccessfulRegisterAndLoginResponseBody = response.as(ReqResPostUnsuccessfulRegisterLoginModelResponse.class);

        assertEquals(400,response.statusCode());
        assertEquals("Missing password",unsuccessfulRegisterAndLoginResponseBody.getError());
    }

}




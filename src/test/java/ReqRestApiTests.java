import client.ReqResClient;
import data.ReqResPostPutCreateUpdateUserDataFactory;
import data.ReqResPostRegisterLoginUserDataFactory;
import data.ReqResPostUnsuccessfulRegisterLoginUserDataFactory;
import io.restassured.response.Response;
import models.request.ReqResPostPutCreateUpdateUserModelRequest;
import models.request.ReqResPostRegisterLoginUserModelRequest;
import models.request.ReqResPostUnsuccessfulRegisterLoginModelRequest;
import models.response.*;
import org.junit.Test;

import static objectbuilder.ReqResBuilder.*;
import static org.junit.Assert.*;

public class ReqRestApiTests {

    @Test
    public void getUsersListRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        Response getResponse = new ReqResClient().getRequestUsersList("2");

        ReqResGetUsersListModelResponse response = getResponse.body().as(ReqResGetUsersListModelResponse.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(2, response.getPage());
        assertEquals(6, response.getPer_page());
        assertEquals(12, response.getTotal());
        assertEquals(2, response.getTotal_pages());
        assertFalse(response.getData().isEmpty());
        assertEquals("https://reqres.in/#support-heading", response.getSupport().getUrl());
        assertEquals(supportText, response.getSupport().getText());
    }

    @Test
    public void getSingleUserRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        Response getResponse = new ReqResClient().getRequestSingleUser("2");

        ReqResGetSingleUserModelResponse response = getResponse.body().as(ReqResGetSingleUserModelResponse.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(2, response.getData().getId());
        assertEquals("janet.weaver@reqres.in", response.getData().getEmail());
        assertEquals("Janet", response.getData().getFirst_name());
        assertEquals("Weaver", response.getData().getLast_name());
        assertEquals("https://reqres.in/img/faces/2-image.jpg", response.getData().getAvatar());
        assertEquals("https://reqres.in/#support-heading", response.getSupport().getUrl());
        assertEquals(supportText, response.getSupport().getText());
    }

    @Test
    public void getSingleUserNotFoundRequestTest() {
        Response getResponse = new ReqResClient().getRequestSingleUser("28");

        assertEquals(404, getResponse.statusCode());
    }

    @Test
    public void getResourcesListRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        Response getResponse = new ReqResClient().getRequestResourcesList();

        ReqResGetResourcesListModelResponse response =
                getResponse.body().as(ReqResGetResourcesListModelResponse.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(1, response.getPage());
        assertEquals(6, response.getPer_page());
        assertEquals(12, response.getTotal());
        assertEquals(2, response.getTotal_pages());
        assertFalse(response.getData().isEmpty());
        assertEquals("https://reqres.in/#support-heading", response.getSupport().getUrl());
        assertEquals(supportText, response.getSupport().getText());
    }

    @Test
    public void getSingleResourceRequestTest() {
        String supportText = "To keep ReqRes free, contributions towards server costs are appreciated!";

        Response getResponse = new ReqResClient().getRequestSingleResource("5");

        ReqResGetSingleResourceModelResponse response
                = getResponse.body().as(ReqResGetSingleResourceModelResponse.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(5, response.getData().getId());
        assertEquals("tigerlily", response.getData().getName());
        assertEquals(2004, response.getData().getYear());
        assertEquals("#E2583E", response.getData().getColor());
        assertEquals("17-1456", response.getData().getPantone_value());

        assertEquals("https://reqres.in/#support-heading", response.getSupport().getUrl());
        assertEquals(supportText, response.getSupport().getText());
    }

    @Test
    public void getSingleResourceNotFoundRequestTest() {
        Response getResponse = new ReqResClient().getRequestSingleUser("23");

        assertEquals(404, getResponse.statusCode());
    }

    @Test
    public void postCreateUserRequestTest() {
        ReqResPostPutCreateUpdateUserModelRequest requestBody
                = new ReqResPostPutCreateUpdateUserDataFactory(createBodyForPostPutPatchRequest())
                .setName("Gorjan")
                .setJob("Quality Assurance")
                .createRequest();

        Response postResponse = new ReqResClient().postCreateUserRequest(requestBody);

        ReqResPostCreateUserModelResponse response = postResponse.as(ReqResPostCreateUserModelResponse.class);

        assertEquals(201, postResponse.statusCode());

        assertEquals("Gorjan", response.getName());
        assertEquals("Quality Assurance", response.getJob());
        assertFalse(response.getId().isEmpty());
        assertFalse(response.getCreatedAt().isEmpty());
    }

    @Test
    public void putUpdateUserRequestTest() {
        ReqResPostPutCreateUpdateUserModelRequest requestBody
                = new ReqResPostPutCreateUpdateUserDataFactory(createBodyForPostPutPatchRequest())
                .setName("Gorjan")
                .setJob("Quality Assurance")
                .createRequest();

        Response putResponse = new ReqResClient().putUpdateUserRequest(requestBody, "5");

        ReqResPutUpdateUserModelResponse response = putResponse.as(ReqResPutUpdateUserModelResponse.class);

        assertEquals(200, putResponse.statusCode());

        assertEquals("Gorjan", response.getName());
        assertEquals("Quality Assurance", response.getJob());
        assertFalse(response.getUpdatedAt().isEmpty());
    }

    @Test
    public void patchUpdateUserRequestTest() {
        ReqResPostPutCreateUpdateUserModelRequest requestBody
                = new ReqResPostPutCreateUpdateUserDataFactory(createBodyForPostPutPatchRequest())
                .setName("Gorjan")
                .setJob("Quality Assurance")
                .createRequest();

        Response patchResponse = new ReqResClient().patchUpdateUserRequest(requestBody, "5");

        ReqResPutUpdateUserModelResponse response = patchResponse.as(ReqResPutUpdateUserModelResponse.class);

        assertEquals(200, patchResponse.statusCode());

        assertEquals("Gorjan",response.getName());
        assertEquals("Quality Assurance", response.getJob());
        assertFalse(response.getUpdatedAt().isEmpty());
    }

    @Test
    public void deleteUserRequestTest(){
        Response deleteResponse = new ReqResClient().deleteUserRequest("5");

        assertEquals(204,deleteResponse.statusCode());
    }

    @Test
    public void postRegisterUserRequestTest() {
        ReqResPostRegisterLoginUserModelRequest requestBody
                = new ReqResPostRegisterLoginUserDataFactory(createBodyForPostRegisterLoginUserRequest())
                .setEmail("eve.holt@reqres.in")
                .setPassword("pistol")
                .createRequest();

        Response postResponse = new ReqResClient().postRegisterUserRequest(requestBody);

        ReqResPostRegisterUserModelResponse response = postResponse.as(ReqResPostRegisterUserModelResponse.class);

        assertEquals(200,postResponse.statusCode());
        assertTrue(response.getId() > 0);
        assertFalse(response.getToken().isEmpty());
    }

    @Test
    public void postUnsuccessfulRegisterRequestTest() {
        ReqResPostUnsuccessfulRegisterLoginModelRequest requestBody
                = new ReqResPostUnsuccessfulRegisterLoginUserDataFactory(createBodyForPostUnsuccessfulRegisterLoginUserRequest())
                .setEmail("sydney@fife")
                .createRequest();

        Response postResponse = new ReqResClient().postUnsuccessfulRegisterUserRequest(requestBody);

        ReqResPostUnsuccessfulRegisterLoginModelResponse response
                = postResponse.as(ReqResPostUnsuccessfulRegisterLoginModelResponse.class);

        assertEquals(400,postResponse.statusCode());
        assertEquals("Missing password",response.getError());
    }

    @Test
    public void postLoginUserRequestTest() {
        ReqResPostRegisterLoginUserModelRequest requestBody
                = new ReqResPostRegisterLoginUserDataFactory(createBodyForPostRegisterLoginUserRequest())
                .setEmail("eve.holt@reqres.in")
                .setPassword("cityslicka")
                .createRequest();

        Response postResponse = new ReqResClient().postLoginUserRequest(requestBody);

        ReqResPostRegisterUserModelResponse response = postResponse.as(ReqResPostRegisterUserModelResponse.class);

        assertEquals(200,postResponse.statusCode());
        assertFalse(response.getToken().isEmpty());
    }

    @Test
    public void postUnsuccessfulLoginRequestTest() {
        ReqResPostUnsuccessfulRegisterLoginModelRequest requestBody
                = new ReqResPostUnsuccessfulRegisterLoginUserDataFactory(createBodyForPostUnsuccessfulRegisterLoginUserRequest())
                .setEmail("peter@klaven")
                .createRequest();

        Response postResponse = new ReqResClient().postUnsuccessfulLoginUserRequest(requestBody);

        ReqResPostUnsuccessfulRegisterLoginModelResponse response
                = postResponse.as(ReqResPostUnsuccessfulRegisterLoginModelResponse.class);

        assertEquals(400,postResponse.statusCode());
        assertEquals("Missing password",response.getError());
    }

}




package utils;

import data.ReqResPostPutCreateUpdateUserDataFactory;
import data.ReqResPostRegisterLoginUserDataFactory;
import data.ReqResPostUnsuccessfulRegisterLoginUserDataFactory;
import models.request.ReqResPostPutCreateUpdateUserModelRequest;
import models.request.ReqResPostRegisterLoginUserModelRequest;
import models.request.ReqResPostUnsuccessfulRegisterLoginModelRequest;
import org.apache.commons.lang3.RandomStringUtils;

import static objectbuilder.ReqResBuilder.*;

public class HelperClass {

    public static ReqResPostPutCreateUpdateUserModelRequest createDefaultUserRequestBody() {
        return new ReqResPostPutCreateUpdateUserDataFactory(createBodyForPostPutPatchRequest())
                .setName(RandomStringUtils.randomAlphanumeric(10))
                .setJob(RandomStringUtils.randomAlphanumeric(10))
                .createRequest();
    }

    public static ReqResPostRegisterLoginUserModelRequest createDefaultRegisterLoginRequestBody(String email, String password) {
        return new ReqResPostRegisterLoginUserDataFactory(createBodyForPostRegisterLoginUserRequest())
                .setEmail(email)
                .setPassword(password)
                .createRequest();
    }

    public static ReqResPostUnsuccessfulRegisterLoginModelRequest createUnsuccessfulRegisterLoginRequestBody(String email) {
        return new ReqResPostUnsuccessfulRegisterLoginUserDataFactory(createBodyForPostUnsuccessfulRegisterLoginUserRequest())
                .setEmail(email)
                .createRequest();
    }

}

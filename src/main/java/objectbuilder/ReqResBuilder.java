package objectbuilder;

import models.request.ReqResPostPutCreateUpdateUserModelRequest;
import models.request.ReqResPostRegisterLoginUserModelRequest;
import models.request.ReqResPostUnsuccessfulRegisterLoginModelRequest;

public class ReqResBuilder {

    public static ReqResPostPutCreateUpdateUserModelRequest createBodyForPostPutPatchRequest() {
        return ReqResPostPutCreateUpdateUserModelRequest.builder()
                .name("Default value")
                .job("Default value")
                .build();
    }

    public static ReqResPostRegisterLoginUserModelRequest createBodyForPostRegisterLoginUserRequest() {
        return ReqResPostRegisterLoginUserModelRequest.builder()
                .email("Default value")
                .password("Default value")
                .build();
    }

    public static ReqResPostUnsuccessfulRegisterLoginModelRequest createBodyForPostUnsuccessfulRegisterLoginUserRequest() {
        return ReqResPostUnsuccessfulRegisterLoginModelRequest.builder()
                .email("Default value")
                .build();
    }

}

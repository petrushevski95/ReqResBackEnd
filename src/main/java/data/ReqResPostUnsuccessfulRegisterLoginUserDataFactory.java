package data;

import models.request.ReqResPostUnsuccessfulRegisterLoginModelRequest;

public class ReqResPostUnsuccessfulRegisterLoginUserDataFactory {

    ReqResPostUnsuccessfulRegisterLoginModelRequest request;

    public ReqResPostUnsuccessfulRegisterLoginUserDataFactory(ReqResPostUnsuccessfulRegisterLoginModelRequest request) {
        this.request = request;
    }

    public ReqResPostUnsuccessfulRegisterLoginUserDataFactory setEmail(String value) {
        request.setEmail(value);
        return this;
    }

    public ReqResPostUnsuccessfulRegisterLoginModelRequest createRequest() {
        return request;
    }

}

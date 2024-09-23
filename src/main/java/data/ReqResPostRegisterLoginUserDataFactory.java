package data;

import models.request.ReqResPostRegisterLoginUserModelRequest;

public class ReqResPostRegisterLoginUserDataFactory {

    ReqResPostRegisterLoginUserModelRequest request;

    public ReqResPostRegisterLoginUserDataFactory(ReqResPostRegisterLoginUserModelRequest request) {
        this.request = request;
    }

    public ReqResPostRegisterLoginUserDataFactory setEmail(String value) {
        request.setEmail(value);
        return this;
    }

    public ReqResPostRegisterLoginUserDataFactory setPassword(String value) {
        request.setPassword(value);
        return this;
    }

    public ReqResPostRegisterLoginUserModelRequest createRequest() {
        return request;
    }

}

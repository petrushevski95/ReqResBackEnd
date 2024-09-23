package data;

import models.request.ReqResPostPutCreateUpdateUserModelRequest;

public class ReqResPostPutCreateUpdateUserDataFactory {

    ReqResPostPutCreateUpdateUserModelRequest request;

    public ReqResPostPutCreateUpdateUserDataFactory(ReqResPostPutCreateUpdateUserModelRequest request) {
        this.request = request;
    }

    public ReqResPostPutCreateUpdateUserDataFactory setName(String value) {
        request.setName(value);
        return this;
    }

    public ReqResPostPutCreateUpdateUserDataFactory setJob(String value) {
        request.setJob(value);
        return this;
    }

    public ReqResPostPutCreateUpdateUserModelRequest createRequest() {
        return request;
    }

}

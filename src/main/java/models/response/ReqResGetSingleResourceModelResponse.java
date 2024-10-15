package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.response.modeldata.ReqResResourcesDataModel;
import models.response.modeldata.ReqResSupportModel;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResGetSingleResourceModelResponse {

    ReqResResourcesDataModel data;
    ReqResSupportModel support;

}

package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.response.objects.ReqResResourcesDataModel;
import models.response.objects.ReqResSupportModel;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResGetSingleResourceModelResponse {

    ReqResResourcesDataModel data;
    ReqResSupportModel support;

}

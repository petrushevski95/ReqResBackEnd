package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.response.modeldata.ReqResUsersDataModel;
import models.response.modeldata.ReqResSupportModel;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResGetSingleUserModelResponse {

    ReqResUsersDataModel data;
    ReqResSupportModel support;

}

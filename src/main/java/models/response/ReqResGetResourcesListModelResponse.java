package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.response.modeldata.ReqResResourcesDataModel;
import models.response.modeldata.ReqResSupportModel;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResGetResourcesListModelResponse {

    int page;
    int per_page;
    int total;
    int total_pages;
    List<ReqResResourcesDataModel> data;
    ReqResSupportModel support;

}

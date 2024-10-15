package models.response.modeldata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResResourcesDataModel {

    int id;
    String name;
    int year;
    String color;
    String pantone_value;

}

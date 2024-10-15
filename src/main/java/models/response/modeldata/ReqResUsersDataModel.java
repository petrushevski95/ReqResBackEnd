package models.response.modeldata;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResUsersDataModel {

    int id;
    String email;
    String first_name;
    String last_name;
    String avatar;

}

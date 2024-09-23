package models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ReqResPostCreateUserModelResponse {

    String name;
    String job;
    String id;
    String createdAt;

}

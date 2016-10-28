package main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by j on 10/28/16.
 */
@Data
@AllArgsConstructor
public class RetrieveRequest {
    private String deviceId;
}

package main.domain;

import lombok.Data;

/**
 * Created by j on 10/26/16.
 */
@Data
public class SendPayload {
    private String deviceId;
    private String command;
}

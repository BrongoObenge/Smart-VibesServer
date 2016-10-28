package main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by j on 10/28/16.
 */
@Data
@AllArgsConstructor
@ToString
public class Command {
    private String deviceId;
    private String appId;
    private String command;
}

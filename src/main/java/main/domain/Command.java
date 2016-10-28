package main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by j on 10/28/16.
 */
@Data
@AllArgsConstructor
public class Command {
    private String deviceId;
    private String appId;
    private String command;
}

package main.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by j on 10/28/16.
 */
@Data
@AllArgsConstructor
@ToString
@Entity
public class Command {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column
    private String deviceId;
    private String appId;
    private String command;
}

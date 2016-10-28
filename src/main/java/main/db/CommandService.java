package main.db;

import main.domain.Command;

/**
 * Created by j on 10/28/16.
 */
public interface CommandService {
    Command findByDeviceId(String id);
    void save(Command c);
}

package main.db;

import main.domain.Command;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by j on 10/28/16.
 */
public interface CommandRepository extends CrudRepository<Command, Long> {
    Command findBydeviceId(String deviceId);
}

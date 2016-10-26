package main.db;

import main.domain.SendPayload;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by j on 10/26/16.
 */
public interface dbRepository extends
        CrudRepository<SendPayload, Long> {
    SendPayload findById(Long id);
}

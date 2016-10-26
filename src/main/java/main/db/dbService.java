package main.db;

import main.domain.SendPayload;

/**
 * Created by j on 10/26/16.
 */
public interface dbService {
    void create(SendPayload p);
}
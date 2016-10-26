package main.db;

import main.domain.SendPayload;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * Created by j on 10/26/16.
 */
public class dbServiceImpl implements dbService{

//    @Autowired
//    dbRepository dbRepository;

    @Override
    public void create(SendPayload p) {
//        dbRepository.save(p);
    }


}
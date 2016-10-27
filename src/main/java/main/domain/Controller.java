package main.domain;

import main.db.dbService;
import main.db.dbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by j on 10/26/16.
 */

@org.springframework.stereotype.Controller
public class Controller {

//    @Autowired
//    dbService serv;

//    @RequestMapping(value="/send", method= RequestMethod.GET)
//    public int send(@RequestBody String payload){
//        System.out.println(payload);
//        return 200;
//    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public String greeting() throws Exception {
        Thread.sleep(1000); // simulated delay
        return "!";
    }

}

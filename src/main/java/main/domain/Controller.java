package main.domain;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

/**
 * Created by j on 10/26/16.
 */

@RestController
public class Controller {

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String send(@RequestBody String body) throws Exception {
        if(body.startsWith("%7B")){
            String temp = URLDecoder.decode(body, "UTF-8");
            if(temp.endsWith("=")){
                body = temp.substring(0,temp.length() - 1);
            }
        }
        System.out.println(body);

        return "ABC";
    }

    @RequestMapping(value="/retrieve", method=RequestMethod.POST)
    public String get(@RequestBody String body) throws Exception {
        System.out.println(body);
        return "DEF";
    }

}

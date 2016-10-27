package main.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by j on 10/26/16.
 */

@RestController
public class Controller {

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String greeting() throws Exception {
        return "ABC";
    }

}

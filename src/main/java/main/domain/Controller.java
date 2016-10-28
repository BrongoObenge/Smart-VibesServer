package main.domain;

import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 10/26/16.
 */

@RestController
public class Controller {
    private ArrayList<Couple> coupledList = new ArrayList<Couple>();
    private ArrayList<Command> queue = new ArrayList<Command>();
    private Gson g = new Gson();

    @RequestMapping(value="/", method=RequestMethod.GET)
    public String test() throws Exception {
        return "{\"status\":\"up\"}";
    }

    @RequestMapping(value="/send", method=RequestMethod.POST)
    public String send(@RequestBody String body) throws Exception {
        body = checkBody(body);
        SendPayload p = g.fromJson(body, SendPayload.class);
        queue.add(new Command(p.getDeviceId(), null, p.getCommand()));
        return "{\"status\":\"Added Command to queue.\"}";
    }

    @RequestMapping(value="/retrieve", method=RequestMethod.POST)
    public String get(@RequestBody String body) throws Exception {
        body = checkBody(body);
        RetrieveRequest req = g.fromJson(body, RetrieveRequest.class);
        for(Command c: queue){
            if(c.getDeviceId().equals(req.getDeviceId())){

                return "{\"command\":\""+c.getCommand()+"\"}";
            }
        }
        return "{\"command\":\"none\"}";
    }

    @RequestMapping(value="/couple/device", method=RequestMethod.POST)
    public String coupleDevice(@RequestBody String body) throws Exception {
        body = checkBody(body);
        CoupleRequest req = g.fromJson(body, CoupleRequest.class);
        boolean action = false;
        for(Couple c: coupledList){
            if(c.getDeviceId().equals(req.getDeviceId())){
                c.setConnected(true);
                action = true;
                return "{\"status\":\"Established connection.\"}";
            }
        }
        return "{\"status\":\"toet\"}";
    }

    @RequestMapping(value="/couple/app", method=RequestMethod.POST)
    public String couple(@RequestBody String body) throws Exception {
        body = checkBody(body);
        CoupleRequest request = g.fromJson(body, CoupleRequest.class);
        //request:UUID, with:UUID
        boolean action = false;
        for(Couple c : coupledList){
            if(c.isConnected()) {
                action = true;
                continue;
            }
            if(c.getAppId().equals(request.getAppId()) && c.getDeviceId().equals(request.getDeviceId()) && !c.isConnected()){
                action = true;
                c.setConnected(true);
                return "{\"status\":\"Connection established.\"}";
            }
        }
        if(!action){
            coupledList.add(new Couple(request.getDeviceId(), request.getAppId(), false));
            return "{\"status\":\"Request for connection created, waiting for other party.\"}";
        }
        return "{\"status\":\"Error\"}";
    }

    private String checkBody(String s) throws UnsupportedEncodingException {
        if(s.startsWith("%7B")){
            String temp = URLDecoder.decode(s, "UTF-8");
            if(temp.endsWith("=")){
                s = temp.substring(0,temp.length() - 1);
            }
        }
        return s;
    }

    @RequestMapping(value="/debug", method=RequestMethod.GET)
    public Object debugCoupleList() throws Exception {
        debugList(coupledList);
        debugListQueue(queue);
        return coupledList + "\n\n" + queue;
    }


    private void debugList(ArrayList<Couple> a){
        for(Couple c: a){
            System.out.println("Couple: [addId:"+ c.getAppId()+"DeviceId:"+c.getDeviceId()+" connected:"+c.isConnected());
        }
    }

    private void debugListQueue(ArrayList<Command> a){
        for(Command c: a){
            System.out.println(c.toString());
        }
    }

}

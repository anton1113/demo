package com.arash.spring.demo.rest;

import com.arash.spring.demo.model.Request;
import com.arash.spring.demo.model.Response;
import com.arash.spring.demo.service.DemoService;
import com.arash.spring.demo.service.GroovyGreeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author anton1113
 */
@RestController
public class DemoController {

    @Autowired private DemoService demoService;
    @Autowired private GroovyGreeter groovyGreeter;

    @RequestMapping(method = RequestMethod.GET, value = "/rest/say-hello")
    public String sayHello() {
        return "Hello, friend!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/timestamp")
    public String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rest/foo")
    public String foo() {
        return groovyGreeter.sayHello();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rest/demo")
    public Response serve(@RequestBody Request request) {
        return demoService.serve(request);
    }

}

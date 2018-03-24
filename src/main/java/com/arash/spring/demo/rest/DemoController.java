package com.arash.spring.demo.rest;

import com.arash.spring.demo.model.Request;
import com.arash.spring.demo.model.Response;
import com.arash.spring.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anton1113
 */
@RestController
public class DemoController {

    @Autowired private DemoService demoService;

    @RequestMapping(method = RequestMethod.GET, value = "/rest/say-hello")
    public String sayHello() {
        return "Hello, friend!";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/rest/demo")
    public Response serve(@RequestBody Request request) {
        return demoService.serve(request);
    }
}

package com.arash.spring.demo.service;

import com.arash.spring.demo.model.Request;
import com.arash.spring.demo.model.Response;
import org.springframework.stereotype.Service;

/**
 *
 * @author anton1113
 */
@Service
public class DemoService {

    public Response serve(Request request) {

        Response response = new Response();
        response.setId(request.getId());
        response.setText("Response text");
        return response;
    }
}

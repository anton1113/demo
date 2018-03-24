package com.arash.spring.demo.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 *
 * @author anton1113
 */
@Service
public class AsciService {

    public ResponseEntity<byte[]> fetchAsci() throws IOException {

        byte[] output = getContent().getBytes();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("text/html"));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename=surprise.txt");

        return new ResponseEntity<>(output, responseHeaders, HttpStatus.OK);
    }

    private String getContent() {
        return "  ___  __  ____  ____   __      ___   __   _  _  __  ___\n" +
                " / __)/  \\(  _ \\(  _ \\ / _\\    / __) /  \\ ( \\/ )(  )/ __)\n" +
                "( (__(  O )) _ ( )   //    \\  ( (_ \\(  O )/ \\/ \\ )(( (__\n" +
                " \\___)\\__/(____/(__\\_)\\_/\\_/   \\___/ \\__/ \\_)(_/(__)\\___)\n";
    }
}

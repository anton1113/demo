package com.arash.spring.demo.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author anton1113
 */
@Service
public class AsciService {

    private static final String ASCI_PATH = "src/main/resources/asci";

    public ResponseEntity<byte[]> fetchAsci() throws IOException {

        String content = Files.lines(Paths.get(ASCI_PATH))
                .reduce((line1, line2) -> line1.concat("\n").concat(line2)).get();
        byte[] output = content.getBytes();

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("charset", "utf-8");
        responseHeaders.setContentType(MediaType.valueOf("text/html"));
        responseHeaders.setContentLength(output.length);
        responseHeaders.set("Content-disposition", "attachment; filename=surprise.txt");

        return new ResponseEntity<byte[]>(output, responseHeaders, HttpStatus.OK);
    }
}

package com.arash.spring.demo.service

import org.springframework.stereotype.Service

/**
 * Created by anton1113 on 03.04.18.
 */
@Service
class GroovyGreeter {

    String sayHello() {
        'Hello from groovy'
    }
}

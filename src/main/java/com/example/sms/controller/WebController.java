package com.example.sms.controller;

import com.example.sms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hardeepsingh on 1/24/17.
 */

@RestController
public class WebController {

    @Autowired
    EmailService service;

    @RequestMapping(value="/welcome1", method = RequestMethod.GET)
    ModelAndView welcome() {
        return new ModelAndView("index");
    }

    @RequestMapping(value="/welcome2")
    ModelAndView welcome2() {
       return new ModelAndView("index1");
    }

    @RequestMapping(value="/send")
    String send() {
        //Use service class to send email
        try {
            service.sendSMS();
        } catch (Exception e) {
            return e.toString();
        }
        return "Email Sent!";
    }

}
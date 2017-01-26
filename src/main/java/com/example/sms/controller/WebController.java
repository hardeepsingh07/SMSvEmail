package com.example.sms.controller;

import com.example.sms.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hardeepsingh on 1/24/17.
 */

@RestController
public class WebController {

    @Autowired
    EmailService service;

    @RequestMapping(value="/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
        return new ModelAndView("sms");
    }

    @RequestMapping(value="/sendemail/{number}")
    String sendEmail(@PathVariable("number") String number,
                     @RequestParam("provider") String provider,
                     @RequestParam("subject") String subject,
                     @RequestParam("message") String message) {

        //Use service class to send email
        try {
            service.sendSMS(number, provider, subject, message);
        } catch (Exception e) {
            return "error";
        }
        return "success";
    }

}

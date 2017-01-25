package com.example.sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by hardeepsingh on 1/24/17.
 */
@Service
public class EmailService {
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) throws Exception {
        this.javaMailSender = javaMailSender;
    }

    public void sendSMS() {
        //send email via SMS
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("9096497670@vtext.com");
        mailMessage.setFrom("reminderalertservice@gmail.com");
        mailMessage.setSubject("Reminder:");
        mailMessage.setText("This is a test alert from reminder");

        javaMailSender.send(mailMessage);
    }
}

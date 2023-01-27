package com.backend.project.services.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	
	
	private JavaMailSender mailSender;

    public ContactService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public boolean send(String from, String to, String subject, String text) {
    	try {
	    		
    		  	SimpleMailMessage message = new SimpleMailMessage();
    	        message.setFrom(from);
    	        message.setTo(to, from);
    	        message.setSubject(subject);
    	        message.setText(text);
    	        mailSender.send(message);
    	        return true;
		} catch (Exception e) {
			System.out.print(e);
			return false;
		}
      
    }

    public void sendWithAttach(String from, String to, String subject,
                               String text, String attachName,
                               InputStreamSource inputStream) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        helper.addAttachment(attachName, inputStream);
        mailSender.send(message);
    }
}

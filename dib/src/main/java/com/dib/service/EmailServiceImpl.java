package com.dib.service;

import com.dib.Interface.EmailService;
import com.dib.dto.EmailDetails;
import com.dib.exception.EmailNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
            private String senderEmail;

            @Override
            public void sendEmailAlert(EmailDetails emailDetails) {
                try {
                    SimpleMailMessage mailMessage = new SimpleMailMessage();
                    mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setText(emailDetails.getMessage_body());
            mailMessage.setSubject(emailDetails.getSubject());

            javaMailSender.send(mailMessage);
            System.out.println("mail sent successfully");

        } catch (MailException e){
            throw new EmailNotExists();

        }


    }
}

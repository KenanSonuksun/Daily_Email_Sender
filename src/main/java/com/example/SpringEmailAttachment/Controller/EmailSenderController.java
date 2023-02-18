package com.example.SpringEmailAttachment.Controller;
import com.example.SpringEmailAttachment.Model.EmailModel;
import com.example.SpringEmailAttachment.Service.EmailSenderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emailSender")
public class EmailSenderController {

    private final EmailSenderService emailSenderService;
    private  EmailSenderController(EmailSenderService emailSenderService){
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody EmailModel emailModel) {
        return emailSenderService.sendMailWithAttachment(emailModel);
    }
}

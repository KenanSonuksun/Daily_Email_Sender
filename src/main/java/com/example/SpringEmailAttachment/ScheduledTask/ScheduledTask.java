package com.example.SpringEmailAttachment.ScheduledTask;
import com.example.SpringEmailAttachment.Controller.EmailSenderController;
import com.example.SpringEmailAttachment.Model.EmailModel;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    private final EmailSenderController emailSenderController;

    public ScheduledTask(EmailSenderController emailSenderController) {
        this.emailSenderController = emailSenderController;
    }

    @Scheduled(cron = "0 0 8 * * *")
    public String dailyEmailSender() {
        EmailModel emailModel = new EmailModel();
        emailModel.setToEmail("xx357951xx@gmail.com");
        emailModel.setBody("Have a nice day!!");
        emailModel.setSubject("Good Morning");
        emailModel.setAttachment("C:\\Users\\Kenan\\Desktop\\Ben\\ben.jpg");
        return emailSenderController.sendMail(emailModel);
    }
}

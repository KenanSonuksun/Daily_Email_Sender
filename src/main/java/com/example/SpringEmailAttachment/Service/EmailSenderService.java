package com.example.SpringEmailAttachment.Service;
import com.example.SpringEmailAttachment.Exception.EmailSenderException;
import com.example.SpringEmailAttachment.Model.EmailModel;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendMailWithAttachment(EmailModel emailModel) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);

            mimeMessageHelper.setFrom("**************@gmail.com");
            mimeMessageHelper.setTo(emailModel.getToEmail());
            mimeMessageHelper.setText(emailModel.getBody());
            mimeMessageHelper.setSubject(emailModel.getSubject());

            FileSystemResource fileSystemResource= new FileSystemResource(new File(emailModel.getAttachment()));
            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(),fileSystemResource);
            javaMailSender.send(mimeMessage);

            return "success";
        }catch (Exception exp){
            throw new EmailSenderException("Couldn't send the mail: "+exp.getMessage());
        }

    }
}

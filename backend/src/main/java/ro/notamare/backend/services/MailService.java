package ro.notamare.backend.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.annotation.PostConstruct;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine thymeleafTemplateEngine;

    public void sendRegistrationMail(String to) {
        String from = "office@notamare.ro";
        String subject = "notamare.ro : Cod de inregistrare";

        Map<String, Object> context = new HashMap<>();
        context.put("registrationCode", "potato");
        String htmlBody = getHTML("mail/registration-code.html", context);

        sendHtmlMessage(to, from, subject, htmlBody);
    }

    private String getHTML(String template, Map<String, Object> context) {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(context);
        return thymeleafTemplateEngine.process(template, thymeleafContext);
    }

    private void sendHtmlMessage(String to, String from, String subject, String htmlBody) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(to);
            helper.setFrom(from);
            helper.setSubject(subject);
            helper.setText(htmlBody, true);
            emailSender.send(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

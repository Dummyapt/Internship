package de.dummyapt.internship.email;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * {@link Service} class for registration process
 */
@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
    /**
     * Class attribute providing methods from {@link Logger}
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
    /**
     * Class attribute providing methods from {@link JavaMailSender}
     */
    private final JavaMailSender mailSender;

    @Override
    @Async
    public void send(String to, String email) {
        try {
            var mimeMessage = mailSender.createMimeMessage();
            var helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("support@dummyapt.de");
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            LOGGER.error("Failed to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }
}
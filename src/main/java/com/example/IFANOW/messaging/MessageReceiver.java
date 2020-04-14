
package com.example.IFANOW.messaging;


import com.example.IFANOW.constant.EmailConstant;
import com.example.IFANOW.constant.FcmConstant;
import com.example.IFANOW.constant.SMSConstant;
import com.example.IFANOW.model.*;
import com.example.IFANOW.service.*;

import com.example.IFANOW.utility.NotificationService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@Component
public class MessageReceiver {

    private static final String IFANOW_EMAIL_QUEUE = "Ifanow-email-queue";


    @Autowired
    private EmailPoolService emailPoolService;

    @Autowired
    private EmailTemplateService emailTemplateService;

    @Autowired
    private EmailConfigurationService emailConfigurationService;

    @Autowired
    private NotificationService notificationService;

    @JmsListener(destination = IFANOW_EMAIL_QUEUE)
    public void receiveEmailMessage(final Message<String> message) throws JMSException {

        String response = message.getPayload();
        System.out.println("===============update email pool " + response);

        EmailPool emailPool = emailPoolService.findById(Integer.valueOf(response));

        // getting sms configuration
        List<EmailConfiguration> emailConfigList = emailConfigurationService
                .findAllEmailConfigurations();

        EmailConfiguration emailConfig = emailConfigList.get(0);

        StringBuilder contentBuilder = new StringBuilder();
        try {
            // getting email template
            List<EmailTemplate> emailTemplateList = emailTemplateService.findEmailTemplate(emailPool.getTemplateName());
            // TODO check for null
            EmailTemplate emailTemplate = emailTemplateList.get(0);

            // System.out.println("template [" + msg + "]");
/*
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        this.getClass().getClassLoader().getResourceAsStream(emailTemplate.getTemplate())));
                String str = null;
                while ((str = in.readLine()) != null) {
                    contentBuilder.append(str);
                }
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            String text = contentBuilder.toString();
            String msg = emailPool.getContents();
            // Combining .vm file with content
            String[] contentArray = msg.split("\\|");
            int i = 0;
            for (String content : contentArray) {
                text = text.replace("${a" + i + "}", content);
                i++;
            }

            // Actully sending email
            boolean isEmailSend = notificationService.getEmailService().sendEmail(emailPool, text, emailConfig);


            if (isEmailSend) {
                String processingMsg = emailPool.getProcessingMsg();
                if (null != processingMsg && processingMsg.startsWith("error")) {
                    emailPool.setSendFlag(EmailConstant.ERROR);// TODO Remove
                    // hardcoding
                } else {
                    emailPool.setSendFlag(EmailConstant.SEND);
                }

            } else {
                emailPool.setSendFlag(EmailConstant.ERROR);
            }
            emailPool.setModificationDate(new Date());
            emailPool.setModifiedBy("application");
            emailPoolService.save(emailPool);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}


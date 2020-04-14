
package com.example.IFANOW.utility;

import com.example.IFANOW.constant.EmailConstant;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
public class NotificationService {

    @Autowired
    private Environment environment;

    @Autowired
    private EmailService emailService;


    public EmailService getEmailService() {
        return emailService;
    }

    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }


    public void sendFirstBillPaytNotification(String emailId, String mobileNo, String name, double amt,
                                               long custId, long txnId) {
        getEmailService().saveEmailPool("",emailId, EmailConstant.TITLE_WELCOME,
                name + "|" + amt + "|successful|" + "" + "|" + txnId, EmailConstant.FIRST_TRANSACTION);


    }

    public void sendLargeTransactionAlertNotification(String emailId, String mobileNo, String name, double amt,
                                                      long custId, long txnId) {
        getEmailService().saveEmailPool("",emailId, EmailConstant.TITLE_WELCOME,
                name + "|" + amt + "|successful|" + "" + "|" + txnId, EmailConstant.LARGE_TRANSACTION_ALERT);
    }

    public void sendFeedbackNotification(String emailId, String mobileNo, String name, double amt,
                                         long custId, long txnId) {
        getEmailService().saveEmailPool("",emailId, EmailConstant.TITLE_WELCOME,
                name + "|" + amt + "|successful|" + "" + "|" + txnId, EmailConstant.FEEDBACK);

    }
}


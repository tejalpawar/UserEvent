
package com.example.IFANOW.utility;



import com.example.IFANOW.constant.EmailConstant;
import com.example.IFANOW.messaging.MessageSender;
import com.example.IFANOW.model.EmailConfiguration;
import com.example.IFANOW.model.EmailPool;
import com.example.IFANOW.service.EmailConfigurationService;
import com.example.IFANOW.service.EmailPoolService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

@Component
public class EmailService {

	@Autowired
	private EmailPoolService emailPoolService;



/*	@Autowired
	ModelServiceContainer modelServiceContainer;
	*/

	@Autowired
	private EmailConfigurationService emailConfigurationService;


	@Autowired
	private MessageSender messageSender;

	public boolean sendEmail(EmailPool emailPool, String msg, EmailConfiguration emailConfig) {
		boolean res = false;
		try {
			final String username = emailConfig.getUsername();
			final String password = emailConfig.getPassword();
			final String mailHost = emailConfig.getHost();
			final String mailPort = emailConfig.getPort();
			final String mailFrom = emailPool.getEmailFrom();
			final String mailFromName = "Coin";
			final String to = emailPool.getEmailTo();
			final String sub = emailPool.getSubject();

			final String attach = emailPool.getAttachmentLocation();

			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", emailConfig.getStarttls());
			props.put("mail.smtp.host", mailHost);
			props.put("mail.smtp.port", mailPort);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.required", emailConfig.getStarttls());
			props.put("mail.smtp.user", username);
			props.put("mail.smtp.ssl.trust", mailHost);
			props.put("mail.debug", emailConfig.getDebug());

			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailFrom, mailFromName));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(sub);

			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(msg, "text/html");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();

			if (StringUtils.isNotBlank(attach)) {
				String filename = attach;
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
			}

			message.setContent(multipart);
			message.saveChanges();
			Transport.send(message);

			System.out.println("Sent message successfully....to " + to);
			res = true;
			emailPool.setProcessingMsg("Sent Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			emailPool.setProcessingMsg("error-" + e.toString());
			System.out.println("problem in sendmail****************** " + e.toString());
		}
		return res;
	}

	public void saveEmailPool(String agId, String to, String subject, String contents, String templateName) {
		try {

			String from = emailConfigurationService.findAllEmailConfigurations().get(0).getUsername();

			EmailPool emailPool = new EmailPool();
			emailPool.setAgId(agId);
			emailPool.setEmailFrom(from);
			emailPool.setEmailTo(to);
			emailPool.setSubject(subject);
			emailPool.setContents(contents);
			emailPool.setTemplateName(templateName);
			emailPool.setCreatedBy("application");
			emailPool.setCreationDate(new Date());
			emailPool.setSendFlag("N");

			EmailPool emailPoolObj = emailPoolService.save(emailPool);
			messageSender.sendMessage(String.valueOf(emailPoolObj.getId()), EmailConstant.EMAIL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


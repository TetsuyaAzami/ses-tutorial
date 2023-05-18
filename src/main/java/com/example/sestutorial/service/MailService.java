package com.example.sestutorial.service;

import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import jakarta.mail.internet.InternetAddress;

@Service
public class MailService {
	@Autowired
	MailSender mailSender;

	public void sendMail() throws UnsupportedEncodingException {
		//
		InternetAddress senderAddress = new InternetAddress("testsender@example.com", "test", "ISO-2022-JP");
		InternetAddress recieverAddress = new InternetAddress("testreciever@example.com", "test", "ISO-2022-JP");

		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(recieverAddress.toString());
		mailMessage.setFrom(senderAddress.toString());
		mailMessage.setReplyTo(senderAddress.toString());
		mailMessage.setSubject("テスト件名");
		mailMessage.setText("テスト本文");

		mailSender.send(mailMessage);
	}
}

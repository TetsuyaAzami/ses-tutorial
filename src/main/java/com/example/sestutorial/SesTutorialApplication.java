package com.example.sestutorial;

import java.io.UnsupportedEncodingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.sestutorial.service.MailService;

@SpringBootApplication
public class SesTutorialApplication {

	@Autowired
	private MailService mailService;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SesTutorialApplication.class, args);
		SesTutorialApplication app = ctx.getBean(SesTutorialApplication.class);
		app.execStartUp();
	}

	public void execStartUp() {
		//
		try {
			mailService.sendMail();
		} catch (UnsupportedEncodingException e) {
			//
			e.printStackTrace();
		}
	}
}

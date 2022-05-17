package com.derteuffel.security;

import com.derteuffel.security.dao.UserDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
	ApplicationContext ctx =SpringApplication.run(SecurityApplication.class, args);
        UserDao userService = ctx.getBean(UserDao.class);
	}

}

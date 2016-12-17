package br.com.newtry;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class MyLabApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyLabApplication.class, args);
	}
	
	@Bean
	public FixedLocaleResolver localResolver(){
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
}

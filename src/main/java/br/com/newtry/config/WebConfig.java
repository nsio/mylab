package br.com.newtry.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.support.DomainClassConverter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{

	// ESSA CONFIGURACAO FAZ A CONVERSÃO QUANDO COLOCO OBJETO DE ENTIDADE COMO PARAM EM MÉTODOS NO CONTROLLER COM O PATHVARIABLE
	@Bean
	public DomainClassConverter<FormattingConversionService> domainClass(FormattingConversionService conversionService){
		return new DomainClassConverter<FormattingConversionService>(conversionService);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/forms/periodica/novo");
	}	
}

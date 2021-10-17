package io.github.sakiRoot.springProject;

import org.apache.tomcat.jni.Local;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.Validator;

@SpringBootApplication
public class SpringProjectApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	//Walidacja Restowego repozytorium
	//Description nie moze byc pusta przy tworzeniu lub zapisywaniu
	/*@Override
	 *	public void configureValidatingRepositoryEventListener(ValidatingRepositoryEventListener validatingListener) {
	 *		validatingListener.addValidator("beforeCreate", validator());
	 *		validatingListener.addValidator("beforeSave", validator());
	 *  }*/

	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}

package com.example.demo;
import com.example.demo.config.Consumerconfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class ScmliteConsumerApplication {

	public static void main(String[] args) throws JSONException, IOException {
		Consumerconfig consumerconfig =new Consumerconfig();
		//SpringApplication.run(ScmliteConsumerApplication.class, args);
		ClassPathResource classPathResource = new ClassPathResource("application.properties");
		 InputStream inputStream = classPathResource.getInputStream();
		 Properties properties = new Properties();
		 properties.load(inputStream);
		 consumerconfig.consumer(properties);

	}

}

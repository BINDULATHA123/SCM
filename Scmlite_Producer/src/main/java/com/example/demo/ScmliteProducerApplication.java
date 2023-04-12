package com.example.demo;
import com.example.demo.config.Producerconfig;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.util.Properties;

import org.json.JSONException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class ScmliteProducerApplication {

	public static void main(String[] args)throws JSONException, UnknownHostException, IOException {
		Producerconfig producer = new Producerconfig();
		//FileReader fileReader = new FileReader("src/main/resources/application.properties");

		//Properties properties = new Properties();

		//properties.load(fileReader);
		ClassPathResource classPathResource = new ClassPathResource("application.properties");
		 InputStream inputStream = classPathResource.getInputStream();
		 Properties properties = new Properties();
		 properties.load(inputStream);
    	producer.Client1(properties);
	}

}

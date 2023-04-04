package com.example.demo.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

public class Producerconfig {

	// initialize socket and input output streams
	private Socket socket = null;
	private BufferedReader input = null;
	private Properties properties;
	// constructor to put ip address and port
	public void Client1(Properties properties) throws JSONException, UnknownHostException, IOException {
		
		//Setting properties to Instance variable Properties
		this.properties=properties;
		
		//Creating socker connecting to getting data from specific host and port
		socket = new Socket(InetAddress.getLocalHost().getHostAddress(), Integer.parseInt(properties.getProperty("port")));

		//To read data from Socket
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

		String line = "";
		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			try {
				line = input.readLine();
				JSONObject object = new JSONObject(line);

				// KAFKA TEMPLATE METHOD CREATE LINE NO 107
				KafkaTemplate<String, String> kafkaTemplate = kafkaTemplate();
				kafkaTemplate.send(properties.getProperty("topicname"), object.toString());
				// kafkaTemplate.send("DeviceDataStream", object.toString());

			} catch (SocketException socketexception) {
				throw new IllegalArgumentException("unable to load");
			} catch (IOException ioexception) {
				throw new IllegalArgumentException("unable to load to ioexception");
			} catch (Exception exception) {
				throw new IllegalArgumentException("unable to load");
			}

		}

	}

	private KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerConfig());
	}

	public ProducerFactory<String, String> producerConfig() {
		Map<String, Object> config = new HashMap<>();

		 //config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getProperty("bootstrapServers"));

		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}

}
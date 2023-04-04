package com.example.demo.config;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Component
public class Consumerconfig {
	
	//connecting to mongodb
	private MongoCollection<Document> mongocollection =null ;
	public void consumer(Properties properties ) throws JSONException{
		try {
		       MongoClient mongoClient = MongoClients.create(properties.getProperty("mongodburi"));
		       MongoDatabase mongodatabase = mongoClient.getDatabase(properties.getProperty("mongodatabase"));  

		       mongocollection= mongodatabase.getCollection(properties.getProperty("mongocollectionname"));
		       System.out.println("Mongo connection estabished  ......");

			
		}
		 catch (Exception exeception) {
			 System.out.println("handle server down or failed"+exeception);
		        // handle server down or failed query here.
		    }
		 Logger logger= LoggerFactory.getLogger(Consumerconfig.class.getName());  
	        //String bootstrapServers="kafka:9092";  
	        String bootstrapServers=properties.getProperty("bootstrapServers");  

	        String group_id=properties.getProperty("groupid"); 
	        String topic_name=properties.getProperty("topicname"); 
	        //Creating consumer properties  
	        Properties properties1=new Properties();  
	        properties1.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);  
	        properties1.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,   StringDeserializer.class.getName());  
	        properties1.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class.getName());  
	        properties1.setProperty(ConsumerConfig.GROUP_ID_CONFIG,group_id);  
	        properties1.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");  
	        //creating consumer  
	        KafkaConsumer<String,String> consumer= new KafkaConsumer<String,String>(properties1);  

	        //Subscribing  
	        consumer.subscribe(Arrays.asList(topic_name));  
	        //polling  
	        while(true){  
	            ConsumerRecords<String,String> records=consumer.poll(Duration.ofMillis(100));
	            for(ConsumerRecord<String,String> record: records){  
	            	
	                logger.info("Key: "+ record.key() + ", Value:" +record.value());  
	                logger.info("Partition:" + record.partition()+",Offset:"+record.offset());            
	                Document documentdata = Document.parse(record.value());
	                mongocollection.insertOne(documentdata);
	               
	            } 
	}}

}

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

public class S_Producer{
	
	public static void main(String[] args) {
		//Creating Properties
		System.out.println("**");

		Properties properties = new Properties();
		properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//Creating producers
		Producer<String, String> producer = new KafkaProducer<>(properties);
		//prepare the record
		String recordValue = "This is the first Message for Kafka";
		ProducerRecord<String, String> record = new ProducerRecord<>("testTopic", null, recordValue);
		//Sending message to Kafka Broker
		System.out.println("started");
		producer.send(record);
		System.out.println("sent");
		producer.flush();
		producer.close();
	}
}
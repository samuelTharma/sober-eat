package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sobereat.event.Customer;
import com.sobereat.event.MenuItem;
import com.sobereat.event.OrderPlaced;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;

public class Producer
{
  static String BOOTSTRAP_SERVERS = "http://localhost:9092";
  private static final String TOPIC = "kitchen-orders1";

  public static void main(String[] args)
  {
    System.out.println("Hello world!");
    new Producer().produceToKafka();
    //    new Producer().consumeToKafka();
  }

  public void produceToKafka()
  {
    try
    {
      long l = 1;
      org.apache.kafka.clients.producer.Producer<Long, OrderPlaced> producer = createProducer();
      while (true)
      {
        // Create a sample message
        String message = "Hello, Kafka!";

        OrderPlaced placed = new OrderPlaced();
        placed.setId("102020");
        Customer customer = new Customer();
        customer.setName("john");
        customer.setAddress("Reading");
        customer.setPhoneNumber("183722828");
        placed.setCustomer(customer);
        MenuItem menuRecord = new MenuItem();
        menuRecord.setId("34");
        menuRecord.setName("Chicken Pizza ");
        menuRecord.setQty("2");

        MenuItem menuRecord1 = new MenuItem();
        menuRecord1.setId("333");
        menuRecord1.setName("Chicken Curry ");
        menuRecord1.setQty("1");
        List<MenuItem> list = new ArrayList<>();
        list.add(menuRecord);
        list.add(menuRecord1);
        placed.setMenu(list);

        int part = (int) (l % 10);
        ProducerRecord<Long, OrderPlaced> record = new ProducerRecord<>(TOPIC, l++, placed);

        // Send the message to the Kafka topic
        producer.send(record);
        System.out.println("Sent: " + message);

        // Wait for a second before sending the next message
        Thread.sleep(1000);
      }

    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  private static org.apache.kafka.clients.producer.Producer<Long, OrderPlaced> createProducer()
  {
    Properties props = new Properties();
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
    props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
    //    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
    //              StringSerializer.class.getName());
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, io.confluent.kafka.serializers.KafkaAvroSerializer.class);
    props.put("schema.registry.url", "http://localhost:8081");
    return new KafkaProducer<>(props);
  }
}
package org.example;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import com.sobereat.event.OrderPlaced;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

public class Consumer
{
  static String BOOTSTRAP_SERVERS = "http://localhost:9092";
  private static final String TOPIC = "kitchen-orders1";

  public static void main(String[] args)
  {
    System.out.println("Hello world!");
    new Consumer().consumeToKafka();
  }

  public void consumeToKafka()
  {
    org.apache.kafka.clients.consumer.Consumer<Long, OrderPlaced> consumer = createConsumer();
    consumer.subscribe(Collections.singletonList(TOPIC));
//        TopicPartition partition = new TopicPartition(TOPIC);
//        consumer.assign(Collections.singletonList(partition));
    while (true)
    {
      try
      {

        ConsumerRecords<Long, OrderPlaced> records = consumer.poll(Duration.ofMillis(100));
        for (ConsumerRecord<Long, OrderPlaced> record : records)
        {
          System.out.printf("Received message: key = %s, value = %s%n", record.key(), record.value().toString());
        }
        Thread.sleep(1000);
      }
      catch (Exception e)
      {
        e.printStackTrace();
      }

    }
  }

  private static org.apache.kafka.clients.consumer.Consumer<Long, OrderPlaced> createConsumer()
  {
    Properties props = new Properties();
    props.setProperty("bootstrap.servers", BOOTSTRAP_SERVERS);
    props.setProperty("group.id", "test");
    props.setProperty(ConsumerConfig.GROUP_INSTANCE_ID_CONFIG, "test");
    props.setProperty("enable.auto.commit", "true");
    props.setProperty("auto.commit.interval.ms", "1000");
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.LongDeserializer");
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "io.confluent.kafka.serializers.KafkaAvroDeserializer");
    //    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//              "org.apache.kafka.common.serialization.StringDeserializer");
    props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
    props.put("schema.registry.url", "http://localhost:8081");
    return new KafkaConsumer<>(props);
  }
}
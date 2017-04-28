package com.github.ququzone.basicweb.common;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

/**
 * kafka producer helper.
 *
 * @author Yang XuePing
 */
@Component
public class KafkaProducerHelper {
    private Producer<String, String> producer;

    public KafkaProducerHelper() {
        Properties properties = new Properties();
        try {
            properties.load(KafkaProducerHelper.class.getClassLoader().getResourceAsStream("kafka.producer.properties"));
            producer = new KafkaProducer<>(properties);
        } catch (IOException e) {
            throw new RuntimeException("can not load kafka config file", e);
        }
    }

    public void send(String topic, String value) {
        producer.send(new ProducerRecord<String, String>(topic, value));
    }
}

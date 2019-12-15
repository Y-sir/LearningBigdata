package com.ysir308.interceptor;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

public class CounterInterceptor implements ProducerInterceptor {

    int success;
    int error;

    @Override
    public void configure(Map<String, ?> map) {

    }

    @Override
    public ProducerRecord onSend(ProducerRecord producerRecord) {
        return producerRecord;
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception e) {
        if (metadata != null) {
            success ++;
        } else {
            error ++;
        }
    }

    @Override
    public void close() {
        System.out.println("success: " + success + ",error: " + error);
    }

}
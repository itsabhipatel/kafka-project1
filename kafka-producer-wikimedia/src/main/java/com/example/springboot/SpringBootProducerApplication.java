package com.example.springboot;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner {

    @Autowired
private WikimediaChangesProducer wikimediaChangesProducer;
    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(SpringBootProducerApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();

    }


}

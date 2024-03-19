package com.example.springboot;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private WikiMediaDataRepository repository;
    @KafkaListener(
            topics = "wikimedia-recentchange",
            groupId = "myGroup")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
        WikimediaData wikimediadata = new WikimediaData();
        wikimediadata.setWikiEventData(message);
        repository.save(wikimediadata);
    }
}

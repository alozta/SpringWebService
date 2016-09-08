package com.imarine.WebService;

import com.mongodb.MongoClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

/**
 * Created by alozta on 9/7/16.
 */
@EnableAutoConfiguration
@Configuration
public class MongoConfig {

    private static MongoConfig mongoConfig;
    private static MongoClient mongoClient;
    private static MongoTemplate mongoTemplate;
    private static String db_name = "alarm_db";

    public static @Bean MongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongoClient, db_name);
    }

    public static @Bean MongoTemplate mongoTemplate() throws Exception {

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());

        return mongoTemplate;

    }

    public static void changeMongoClient(String ip, int port){
        mongoClient=new MongoClient(ip,port);
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    public static MongoTemplate getMongoTemplate() {
        getInstance();
        return mongoTemplate;
    }

    /**
     * Singleton Constructor
     * */
    public static MongoConfig getInstance(){
        if(mongoConfig==null){
            mongoConfig = new MongoConfig();
            try {
                mongoTemplate=mongoTemplate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mongoConfig;
    }

    /**
     * Default: Local mongoDB configuration
     * */
    private MongoConfig(){
        mongoClient=new MongoClient("localhost",27017);
    }
}

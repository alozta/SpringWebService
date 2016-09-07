package com.imarine.WebService;

import com.mongodb.MongoClient;
import java.net.UnknownHostException;

/**
 * Created by alozta on 9/7/16.
 */
public class MongoConfig {

    private static MongoConfig mongoConfig;
    private static MongoClient mongoClient;

    public static void changeMongoClient(String ip, int port){
        try {
            mongoClient=new MongoClient(ip,port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static MongoClient getMongoClient() {
        return mongoClient;
    }

    /**
     * Singleton Constructor
     * */
    public static MongoConfig getInstance(){
        if(mongoConfig==null){
            mongoConfig = new MongoConfig();
        }
        return mongoConfig;
    }

    /**
     * Default: Local mongoDB configuration
     * */
    private MongoConfig(){
        try {
            mongoClient=new MongoClient("localhost",27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}

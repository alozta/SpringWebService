package com.imarine.WebService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by alozta on 9/8/16.
 */
@EnableAutoConfiguration
@RestController
public class WebService {

    //ApplicationContext ctx = new AnnotationConfigApplicationContext(MongoConfig.class);
    //MongoOperations mongoOperation = (MongoOperations)ctx.getBean("mongoTemplate");     //interface that allows mongodb operations
    private MongoOperations mongoOperation;

    WebService(){
        mongoOperation = MongoConfig.getMongoTemplate();
    }

    public MongoOperations mongo() {
        return mongoOperation;
    }


    @RestController
    public class AlarmController {

        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        @CrossOrigin
        @RequestMapping("/saved_alarms")        //Use @RequestMapping(method=GET) to narrow this mapping.
        public SavedAlarms saved_alarms(@RequestParam(value="type", defaultValue="none") String type,
                                        @RequestParam(value="operation", defaultValue="none") String operation,
                                        @RequestParam(value="data1", defaultValue="none") String data1,
                                        @RequestParam(value="data2", defaultValue="none") String data2) {
            return new SavedAlarms(counter.toString(),type,operation,data1,data2);
        }
    }
}

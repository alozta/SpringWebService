package com.imarine.WebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by alozta on 9/7/16.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Test {

    public static void main(String [] args){
        WebService ws = new WebService();

        //ws.mongo().save(new SavedAlarms("smuggling","create","data","data"));

        // query to search user
        //Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

        // query to search user
        //Query searchUserQuery = new Query(Criteria.where("username").is("mkyong"));

        // find the saved user again.
        //User savedUser = mongoOperation.findOne(searchUserQuery, User.class);

        // update password
        //mongoOperation.updateFirst(searchUserQuery, Update.update("password", "new password"),User.class);

        // find the updated user object
        //User updatedUser = mongoOperation.findOne(searchUserQuery, User.class);

        // delete
        //mongoOperation.remove(searchUserQuery, User.class);

        // List, it should be empty now.
        //List<User> listUser = mongoOperation.findAll(User.class);

        SpringApplication.run(WebService.class, args);
    }
}

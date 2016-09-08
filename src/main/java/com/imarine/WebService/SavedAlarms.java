package com.imarine.WebService;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Describes the structure of collection.
 *
 * Created by alozta on 9/8/16.
 */
@EnableAutoConfiguration
@Document(collection = "saved_alarms")      //collection name
public class SavedAlarms {

    @Id
    private String id;
    private String type;
    private String operation;
    private String maxApproachDistance;
    private String absenceofAISMessage;

    public SavedAlarms(String id, String type, String operation, String maxApproachDistance, String absenceofAISMessage) {
        this.id = id;
        this.type = type;
        this.operation = operation;
        this.maxApproachDistance = maxApproachDistance;
        this.absenceofAISMessage = absenceofAISMessage;
    }

    public String getType() {
        return type;
    }

    public String getOperation() {
        return operation;
    }

    public String getMaxApproachDistance() {
        return maxApproachDistance;
    }

    public String getAbsenceofAISMessage() {
        return absenceofAISMessage;
    }

    public String getId() {
        return id;
    }
}

package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class CsvEmpModelFormat {
    @JsonProperty("Name")
    abstract String getName();

    @JsonProperty("Score")
    abstract double getScore();
}

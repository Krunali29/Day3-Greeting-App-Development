package com.bridgelabz.greetingapp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GREETING")

public class Greeting {

    @Id
    private final long id;
    private final String message;

    public Greeting() {
        id = 0;
        message = "";

    }
    public Greeting(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String name) {
    }
    // @Column(name = "id", nullable = false)

}

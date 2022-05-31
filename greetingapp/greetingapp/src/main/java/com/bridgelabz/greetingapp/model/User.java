package com.bridgelabz.greetingapp.model;

import lombok.Getter;
import lombok.Setter;

public class User {
    @Getter
    @Setter
    private String firstName;

    private String lastName;

    @Override
    public String toString() {
        String str = (firstName != null) ? firstName + " " : "";
        str += (lastName != null) ? lastName : "";
        return str.trim();
    }
}

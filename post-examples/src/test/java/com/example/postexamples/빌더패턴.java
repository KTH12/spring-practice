package com.example.postexamples;

import org.junit.jupiter.api.Test;

public class 빌더패턴 {

    @Test
    void test() {
        new User.Builder()
            .name("이름")
            .age(100)
            .contact("010-1234", "email@email.com")
            .house("집주소", 12345)
            .build();
    }
}

class User {
    String name;
    String phoneNumber;
    String address;
    int zipCode;
    int age;
    String email;

    private User(String name, String phoneNumber, String address, int zipCode, int age, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
        this.age = age;
        this.email = email;
    }

    public static class Builder {
        String name;
        int age;
        String phoneNumber;
        String email;
        String address;
        int zipCode;

        public Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder contact(String phoneNumber, String email) {
            this.phoneNumber = phoneNumber;
            this.email = email;
            return this;
        }

        public Builder house(String address, int zipCode) {
            this.address = address;
            this.zipCode = zipCode;
            return this;
        }

        public User build() {
            return new User(name, phoneNumber, address, zipCode, age, email);
        }
    }
}
//
// class User1 {
//     String name;
//     String phoneNumber;
//     String address;
//     int zipCode;
//     int age;
//     String email;
//
//     public User(String name, String phoneNumber, String address, int zipCode, int age, String email) {
//         this.name = name;
//         this.phoneNumber = phoneNumber;
//         this.address = address;
//         this.zipCode = zipCode;
//         this.age = age;
//         this.email = email;
//     }
// }

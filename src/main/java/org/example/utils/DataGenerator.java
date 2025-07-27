package org.example.utils;

import net.datafaker.Faker;
import org.example.models.User;

public class DataGenerator {

    private Faker faker = new Faker();

    public User generateUserWithValidData(){
        return new User(
                faker.name().toString(),
                faker.internet().emailAddress(),
                faker.random().nextInt(14, 99));
    }
}

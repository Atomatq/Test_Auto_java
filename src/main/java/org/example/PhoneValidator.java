package org.example;

public class PhoneValidator {
    public static boolean isValid(String phoneNumber) {
        return phoneNumber.matches("^\\+\\d{1,3}\\d{10}$");
    }
}

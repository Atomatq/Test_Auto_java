package unit;

import org.example.PhoneValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTests {
    @Test
    public void checkValidPhoneNumbersTest() {
        assertAll(
                () -> assertTrue(PhoneValidator.isValid("+71234567890")),  // +7 и 10 цифр
                () -> assertTrue(PhoneValidator.isValid("+441234567890")), // +44 и 10 цифр
                () -> assertTrue(PhoneValidator.isValid("+1231234567890"))  // +123 и 10 цифр
        );
    }

    @Test
    public void checkInvalidPhoneNumbersTest() {
        assertAll(
                () -> assertFalse(PhoneValidator.isValid("71234567890")),// без +
                () -> assertFalse(PhoneValidator.isValid("+1234567890")), // без кода страны
                () -> assertFalse(PhoneValidator.isValid("+12341234567890")), // код страны 1234 (4 цифры)
                () -> assertFalse(PhoneValidator.isValid("+1abc4567890")), // содержит буквы
                () -> assertFalse(PhoneValidator.isValid("+1 234 567 8901")), // содержит пробелы
                () -> assertFalse(PhoneValidator.isValid("+1-234-567-8901")), // содержит другие символы
                () -> assertFalse(PhoneValidator.isValid("")),
                () -> assertFalse(PhoneValidator.isValid(null))
        );

    }

    // Неочевидные
    @Test
    public void checkLeadingZerosTest() {
        // Код страны и номер содержат ведущие нули
        assertTrue(PhoneValidator.isValid("+0000123456789"));
    }
}

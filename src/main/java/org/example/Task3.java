package org.example;

import java.util.Collections;
import java.util.List;

public class Task3 {

    public static List<Integer> findDuplicates(List<Integer> numbers) {
        return numbers.stream()
                .filter(numb-> Collections.frequency(numbers, numb) > 1)
                .distinct()
                .toList();
    }
}

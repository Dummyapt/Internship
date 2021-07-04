package de.dummyapt.internship.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        // TODO: 04.07.2021 Regex to validate email
        return true;
    }
}
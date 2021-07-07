package de.dummyapt.internship.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

/**
 * {@link Service} class checking whether an email matches regex or not
 */
@Service
public class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(String s) {
        return s.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$");
    }
}
package de.dummyapt.internship.config;

/**
 * Interface providing methods for retrieving data from the database
 */
public interface MyUserServiceAPI {
    /**
     * Method for selecting a specific record
     * @param username Name of the user
     * @return User by the given username
     */
    String findByUsername(String username);
}
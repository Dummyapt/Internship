package de.dummyapt.internship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Start point of Spring application
 * @author Duha Cinar
 * @version 1.0
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    /**
     * main()-method starting the spring application with passing
     * the Application class and the given start
     * @param args Needed for command line parameters
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Spring application builder for buildung executables (.jar/.war)
     * @param builder Passing itself as it is required to use it
     * @return building resources for the artifact builder to create a .war file
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
}

// TODO: 01.07.2021 Remove unused imports
// TODO: 01.07.2021 Commit and push to GitHub
// TODO: 01.07.2021 Add Thymeleaf variable
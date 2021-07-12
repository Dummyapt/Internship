package de.dummyapt.internship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Start point of {@link SpringBootApplication}
 * @author Duha Cinar
 * @version 2.0
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    /**
     * {@link SpringApplicationBuilder} for buildung executables (.jar/.war)
     * @param builder Passing itself as it is required to use it
     * @return building resources for the artifact builder to create a .war file
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    /**
     * main()-method starting the spring application with passing
     * the Application class and the given start
     * @param args Needed for command line parameters
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

// TODO: 12.07.2021 Remove unused imports
// TODO: 12.07.2021 Convert/Translate everything into English
// TODO: 12.07.2021 Check for typos
// TODO: 12.07.2021 Commit and push to GitHub
package github.yukinami.webboilerplate.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

/**
 * Security Configuration for development environment
 *
 * @author snowblink on 15/11/6.
 */
@Profile("development")
@Configuration
public class SecurityConfigForDevelop extends SecurityConfig {

    @Autowired
    @Override
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}

package com.remock.userService.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import com.remock.commons.security.CommonSecurityConfig;

@Configuration
@Import(CommonSecurityConfig.class)
public class UserServiceConfig {
    // This class is used to import the beans from the common library.
}
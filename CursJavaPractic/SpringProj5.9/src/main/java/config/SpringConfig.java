package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = {"business.service","persistance.dao","entryPoint"})
public class SpringConfig {






}

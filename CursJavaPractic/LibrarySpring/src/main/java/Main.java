import business.config.LibraryConfig;
import business.entryPoint.LibraryEntryPoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan(basePackages = {"business.service","persistance.dao","frontEnd"})
public class Main {
    public static void main(String[] args) {

    /*    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(LibraryConfig.class);
        LibraryEntryPoint libraryEntryPoint = annotationConfigApplicationContext.getBean(LibraryEntryPoint.class);
        libraryEntryPoint.run();*/
        SpringApplication.run(Main.class,args);


    }
}

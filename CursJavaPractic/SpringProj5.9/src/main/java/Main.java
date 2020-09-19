import config.SpringConfig;
import entryPoint.SpringEntryPoint;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        SpringEntryPoint springEntryPoint = annotationConfigApplicationContext.getBean(SpringEntryPoint.class);
        springEntryPoint.run();
    }
}

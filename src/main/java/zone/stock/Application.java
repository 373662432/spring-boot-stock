package zone.stock;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "zone.stock")
@SpringBootApplication
public class Application {
    private final static Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
        LOGGER.info("项目起飞");
    }

}

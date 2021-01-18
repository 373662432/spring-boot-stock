package zone.stock.module.util;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
@EnableConfigurationProperties({SinaProperties.class})
public class SinaUtils {

    private SinaProperties sinaProperties;

    public SinaUtils(SinaProperties sinaProperties){
        this.sinaProperties = sinaProperties;
    }

    public SinaProperties getSinaProperties(){
        return this.sinaProperties;
    }

}

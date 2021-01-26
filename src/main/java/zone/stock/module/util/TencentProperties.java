package zone.stock.module.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "tencent")
public class TencentProperties {
    private String url;
}

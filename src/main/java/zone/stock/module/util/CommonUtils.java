package zone.stock.module.util;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
@Configuration
@EnableConfigurationProperties({SinaProperties.class, StockProperties.class, TencentProperties.class})
public class CommonUtils {

    private SinaProperties sinaProperties;
    private StockProperties stockProperties;
    private TencentProperties tencentProperties;


    public CommonUtils(SinaProperties sinaProperties, StockProperties stockProperties, TencentProperties tencentProperties) {
        this.sinaProperties = sinaProperties;
        this.stockProperties = stockProperties;
        this.tencentProperties = tencentProperties;
    }

    public SinaProperties getSinaProperties() {
        return this.sinaProperties;
    }

    public StockProperties getStockProperties() {
        return this.stockProperties;
    }

    public TencentProperties getTencentProperties() {
        return this.tencentProperties;
    }
}

package zone.stock.module.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import zone.stock.common.models.Stock;
import zone.stock.common.models.StockDetails;
import zone.stock.module.util.SinaProperties;
import zone.stock.module.util.SinaUtils;

@Component
public class Connector implements zone.stock.module.services.Connector {
    private static final Logger logger = LoggerFactory.getLogger(Connector.class);

    @Autowired
    private SinaUtils sinaUtils;

    @Override
    public Stock sinaInit(String stockId) {
        logger.info(stockId + "开始访问新浪接口");
        try {
            RestTemplate restTemplate = new RestTemplate();
            System.out.println(sinaUtils.getSinaProperties().getUrl() + stockId);
            String result = restTemplate.getForObject(sinaUtils.getSinaProperties().getUrl() + stockId, String.class);
            System.out.println(result);
        } catch (Exception e) {
            logger.warn(stockId + ",访问新浪接口失败," + e.getMessage());
        }
        return new Stock();
    }

    @Override
    public StockDetails sinaUpdate(String stockId) {
        return null;
    }
}

package zone.stock.module.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import zone.stock.common.models.Stock;
import zone.stock.common.models.StockDetails;
import zone.stock.module.services.impl.TencentConnect;
import zone.stock.module.util.CommonUtils;

import java.lang.reflect.Field;

@Service
@EnableScheduling
public class Handle {

    @Autowired
    private TencentConnect tencentConnect;

    @Autowired
    private CommonUtils commonUtils;

    @Scheduled(cron = "0/3 * * * * ?")
    private void stockInitAllBySina() throws IllegalAccessException {
        String[] strList = commonUtils.getStockProperties().getList().split(",");
        for (String str : strList
        ) {
            Stock stock = tencentConnect.basicInfo(str);
            StockDetails stockDetails = tencentConnect.detailsInfo(str);
            Class cls = stockDetails.getClass();
            Field[] fields = cls.getDeclaredFields();
            for (Field f: fields
                 ) {
                f.setAccessible(true);
                System.out.println(f.getName() + ": " + f.get(cls));
            }
        }
    }
}

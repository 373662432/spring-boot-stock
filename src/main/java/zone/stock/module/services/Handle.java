package zone.stock.module.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class Handle {

    @Autowired
    private Connector connector;

    @Scheduled(cron = "0/5 * * * * ?")
    private void stockInit(){
        connector.sinaInit("sz300059");
    }
}

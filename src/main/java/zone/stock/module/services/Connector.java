package zone.stock.module.services;

import zone.stock.common.models.Stock;
import zone.stock.common.models.StockDetails;

public interface Connector {
    /**
     * 统一处理url访问操作
     * @param stockId 股票号码 如 sz300059
     * @return 报文信息
     */
    Object connection(String stockId, String url);
}

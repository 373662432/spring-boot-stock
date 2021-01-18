package zone.stock.module.services;

import zone.stock.common.models.Stock;
import zone.stock.common.models.StockDetails;

public interface Connector {
    /**
     * 根据股票号码初始化股票基础信息
     * @param stockId 股票号码 如sz300059
     * @return 股票对象
     */
    Stock sinaInit(String stockId);

    /**
     * 根据股票号码获取实时交易信息
     * @param stockId 股票号码 如 sz300059
     * @return 股票信息对象
     */
    StockDetails sinaUpdate(String stockId);
}

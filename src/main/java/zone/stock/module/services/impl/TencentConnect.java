package zone.stock.module.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import zone.stock.common.models.Stock;
import zone.stock.common.models.StockDetails;
import zone.stock.module.services.Connector;
import zone.stock.module.util.CommonUtils;

import java.util.HashMap;
import java.util.Objects;

@Component
public class TencentConnect implements Connector {
    private static final Logger logger = LoggerFactory.getLogger(TencentConnect.class);

    @Autowired
    private CommonUtils commonUtils;

    private final String[] urlType = new String[]{"s_", "s_pk", "ff_", ""};

    @Override
    public String[] connection(String stockId, String type) {
        logger.info(stockId + "开始访问腾讯接口");
        try {
            RestTemplate restTemplate = new RestTemplate();
            String[] result = Objects.requireNonNull(restTemplate
                    .getForObject(commonUtils.getTencentProperties().getUrl() + type + stockId, String.class))
                    .replace("v_" + type + stockId + "=\"", "")
                    .replace("\";", "")
                    .split("~");
            if (result.length == 0) {
                logger.warn(stockId + ",访问腾讯接口失败,可能是ID错误.");
            }
            return result;
        } catch (Exception e) {
            logger.warn(stockId + ",访问腾讯接口失败," + e.getMessage());
            return null;
        }
    }

    /**
     * 获取简要信息，解析报文
     *
     * @param stockId 股票号码
     * @return 返回Stock对象
     */
    public Stock basicInfo(String stockId) {
        String[] res = this.connection(stockId, this.urlType[0]);
        return new Stock(stockId.substring(0, 2), stockId.substring(2, 6), res[1]);
    }

    /**
     * 获取详细信息，解析报文
     *
     * @param stockId 股票号码
     * @return 返回Stock对象
     */
    public StockDetails detailsInfo(String stockId) {
        String[] resII = this.connection(stockId, this.urlType[1]);
        String[] resIII = this.connection(stockId, this.urlType[2]);
        String[] resIV = this.connection(stockId, this.urlType[3]);
        StockDetails stockDetails = new StockDetails();
        stockDetails.setId(stockId);
        stockDetails.setDateTime(System.currentTimeMillis());
        stockDetails.setTodayStartValue(Double.parseDouble(resIV[5]));
        stockDetails.setYesterdayEndValue(Double.parseDouble(resIV[4]));
        stockDetails.setCurValue(Double.parseDouble(resIV[3]));
        stockDetails.setTodayUpValue(Double.parseDouble(resIV[33]));
        stockDetails.setTodayEndValue(Double.parseDouble(resIV[34]));
        stockDetails.setBuyOneValue(Double.parseDouble(resIV[9]));
        stockDetails.setSellOneValue(Double.parseDouble(resIV[19]));
        stockDetails.setDealNum(Integer.parseInt(resIV[36]));
        stockDetails.setDealAmount(Double.parseDouble(resIV[37]));
        stockDetails.setMarketValue(Double.parseDouble(resIV[45]));
        stockDetails.setLiquidityMarkValue(Double.parseDouble(resIV[44]));
        stockDetails.setPE(Double.parseDouble(resIV[39]));
        stockDetails.setPBR(Double.parseDouble(resIV[46]));
        stockDetails.setBuyHugeOrder(Double.parseDouble(resII[0]));
        stockDetails.setBuySmallOrder(Double.parseDouble(resII[1]));
        stockDetails.setSellHugeOrder(Double.parseDouble(resII[2]));
        stockDetails.setSellSmallOrder(Double.parseDouble(resII[3]));
        stockDetails.setMainInflow(Double.parseDouble(resIII[1]));
        stockDetails.setMainOutflow(Double.parseDouble(resIII[2]));
        stockDetails.setMainNetInflow(Double.parseDouble(resIII[3]));
        stockDetails.setMainInflowPer(Double.parseDouble(resIII[4]));
        stockDetails.setRetailInflow(Double.parseDouble(resIII[5]));
        stockDetails.setRetailOutflow(Double.parseDouble(resIII[6]));
        stockDetails.setRetailNetInflow(Double.parseDouble(resIII[7]));
        stockDetails.setRetailInflowPer(Double.parseDouble(resIII[8]));
        stockDetails.setFlowTotal(Double.parseDouble(resIII[9]));
        return stockDetails;
    }
}

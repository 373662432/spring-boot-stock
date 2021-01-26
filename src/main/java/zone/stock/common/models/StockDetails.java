package zone.stock.common.models;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class StockDetails implements Serializable {
    private static final long serialVersionUID = 2L;
    private String id; //股票号码
    private long dateTime; //更新时间
    private double todayStartValue; //开盘价
    private double yesterdayEndValue; //昨收价
    private double curValue; //当前价
    private double todayUpValue; //最高价
    private double todayEndValue; //最低价
    private double buyOneValue; //买一价
    private double sellOneValue; //卖一价
    private int dealNum; //成交量
    private double dealAmount; //成交额
    private double marketValue; //市值
    private double liquidityMarkValue; //流动市值
    private double pE; //市盈率
    private double pBR; //市净率
    private double buyHugeOrder; //买方大单
    private double buySmallOrder; //买方小单
    private double sellHugeOrder; //卖方大单
    private double sellSmallOrder; //卖方小单
    private double mainInflow; //主力流入
    private double mainOutflow; //主力流出
    private double mainNetInflow; //主力净流入
    private double mainInflowPer; //主力净流入占总流动比
    private double retailInflow; //散户流入
    private double retailOutflow; //散户流出
    private double retailNetInflow; //散户净流入
    private double retailInflowPer; //散户净流入占总流动比
    private double flowTotal; //资金流入流出总量

}

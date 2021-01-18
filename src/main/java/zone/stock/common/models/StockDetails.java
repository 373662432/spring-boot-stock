package zone.stock.common.models;

import java.io.Serializable;
import java.sql.Date;

public class StockDetails implements Serializable {
    private static final long serialVersionUID = 2L;
    private String id;
    private Date dateTime;
    private double todayStartValue;
    private double yesterdayEndValue;
    private double curValue;
    private double todayUpValue;
    private double todayEndValue;
    private double buyOneValue;
    private double sellOneValue;
    private int dealNum;
    private double dealAmount;
}

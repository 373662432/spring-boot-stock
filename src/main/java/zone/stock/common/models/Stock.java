package zone.stock.common.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class Stock implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String type;
    private String name;

    public Stock(String id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }
}

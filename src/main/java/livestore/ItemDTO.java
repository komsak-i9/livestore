package livestore;

import java.io.Serializable;
import lombok.Data;

@Data
public class ItemDTO implements Serializable{
    private int id;
    private String type;
    private double price;
    private double cost;
}

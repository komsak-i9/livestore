package livestore;

import java.io.Serializable;
import lombok.Data;

@Data
public class ItemDTO implements Serializable{
    private String type;
    private char size;
    private char color;
    private double price;
    private double cost;
}

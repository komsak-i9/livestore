
package livestore;

import java.util.List;

/**
 *
 * @author ARIT
 */
public class LiveStore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        StoreLoader storeLoader = new StoreLoader(
                "mydb1","root","password");
        List<ItemDTO> items = storeLoader.LoadItems();  
        
        for( ItemDTO item : items) {
            System.out.println( item.getType() 
                    + ", sellprice = " 
                    + item.getCost() * item.getPrice());
        }
    }
    
}

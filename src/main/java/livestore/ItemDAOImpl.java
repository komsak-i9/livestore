package livestore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDAOImpl implements ItemDAO {

    private final Connection conn;

    public ItemDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public int insert(ItemDTO itemDTO) {
        try {
            //
            PreparedStatement pp = conn.prepareStatement("Insert into Item(type, price, cost) "
                    + "values(?,?,?)");
            pp.setString(1, itemDTO.getType());
            pp.setDouble(2, itemDTO.getPrice());
            pp.setDouble(3, itemDTO.getCost());
            int row = pp.executeUpdate();
            pp.close();
            return row;
        } catch (SQLException ex) {
            Logger.getLogger(ItemDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public ItemDTO get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ItemDTO> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(ItemDTO itemDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

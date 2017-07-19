package livestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreLoader {

    private final String dbName;
    private final String username;
    private final String password;

    public StoreLoader(String dbName, String username,
            String password) {
        //set properties เพื่อเก็บไว้ต่อ database
        this.dbName = dbName;
        this.username = username;
        this.password = password;
    }

    public ItemDTO getItem(int id)  {
        String mysqlJdbcUrl = "jdbc:mysql://localhost/"
                + dbName
                + "?user=" + username
                + "&password=" + password;

        Connection conn = null;
     
        try {
            conn = DriverManager.getConnection(mysqlJdbcUrl);

            PreparedStatement pstmt = conn.prepareStatement("select "
                    + "id, type, size, color, price, cost from item where id = " + id );
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                ItemDTO dto = new ItemDTO();
                dto.setId(rs.getInt("id"));
                dto.setType(rs.getString("type"));
                dto.setColor(rs.getString("color").charAt(0));
                dto.setSize(rs.getString("size").charAt(0));
                dto.setPrice(rs.getDouble("price"));
                dto.setCost(rs.getDouble("cost"));
                return  dto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return null;
    }
    
    //Todo connect database
    //select all item
    //fill all data from table to dto
    public List<ItemDTO> getItems() {

        String mysqlJdbcUrl = "jdbc:mysql://localhost/"
                + dbName
                + "?user=" + username
                + "&password=" + password;

        Connection conn = null;
        ArrayList<ItemDTO> items = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(mysqlJdbcUrl);

            PreparedStatement pstmt = conn.prepareStatement("select "
                    + "type, size, color, price, cost from item");
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                ItemDTO dto = new ItemDTO();
                dto.setType(rs.getString("type"));
                dto.setColor(rs.getString("color").charAt(0));
                dto.setSize(rs.getString("size").charAt(0));
                dto.setPrice(rs.getDouble("price"));
                dto.setCost(rs.getDouble("cost"));
                items.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }
        return items;
    }
}

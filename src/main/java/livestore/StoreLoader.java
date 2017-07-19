package livestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public List<ItemDTO> LoadItems() {

        String mysqlJdbcUrl = "jdbc:mysql://localhost/" 
                + dbName
                + "?user=" + username 
                + "&password=" + password;

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(mysqlJdbcUrl);
            
            PreparedStatement pstmt = conn.prepareStatement("select "
                    + "type, size, color, price, cost from item");
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                System.out.println(rs.getString("type"));
                System.out.println(rs.getString("size"));
                System.out.println(rs.getString("color"));
                System.out.println(rs.getDouble("price"));
                System.out.println(rs.getDouble("cost"));
                
                ItemDTO dto = new ItemDTO();
                dto.setType(rs.getString("type"));
                //..
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
            }
        }

        //Todo connect database
        //select all item
        //fill all data from table to dto
        return null;
    }
}

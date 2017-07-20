package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import livestore.ItemDAOImpl;
import livestore.ItemDAO;
import livestore.ItemDTO;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.Assert;
import org.junit.Before;

@RunWith(JUnit4.class)
public class ItemDAOImplTest {

    Connection conn = null;

    @Before
    public void setUp() throws SQLException {
        String mysqlJdbcUrl = "jdbc:mysql://localhost/"
                + "mydb1"
                + "?user=root"
                + "&password=password";

        if (conn == null) {
            conn = DriverManager.getConnection(mysqlJdbcUrl);
        }
    }

    @Test
    public void testCreate() {
        ItemDAO itemDao = new ItemDAOImpl(conn);
        ItemDTO dto = new ItemDTO();
        int rc = itemDao.insert(dto);
        Assert.assertEquals(1, rc);
    }

    @After
    public void tearDown() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
}

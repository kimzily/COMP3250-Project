package rentawheel.test;

import java.sql.Connection;
import java.sql.Statement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rentawheel.DatabaseConnection;

public class DatabaseConnectionTest {
    private Connection con;
     
    @Before
    public void setUp() {
        this.con = DatabaseConnection.getConnection();
    }
    
    @After
    public void tearDown() {
        this.con = null;
    }

    @Test
    public void testConnection() {
        assertNotNull(this.con);
    }
    
    @Test
    public void testStatement() {
        Statement st = DatabaseConnection.getStatement();
        assertNotNull(st);
    }
}
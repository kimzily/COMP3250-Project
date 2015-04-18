package rentawheel.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import rentawheel.Employee;
import rentawheel.EmployeeModel;

public class EmpployeeModelTest {
    private EmployeeModel model;
         
    @Before
    public void setUp() {
        model = new EmployeeModel();
    }
    
    @After
    public void tearDown() {
        Employee e = model.getEmployee("test");
        if (e != null) {
            model.removeEmployee(e.getId());
        }
        model = null;
    }

    @Test
    public void testAddEmployee() {
        Employee e1 = new Employee();
        
        e1.setFirstName("testName");
        e1.setLastName("testName");
        e1.setUsername("test");
        e1.setPassword("test");
        e1.setTitle(1);
        
        boolean result = model.addEmployee(e1);
        assertTrue(result);
        
        Employee e2 = model.getEmployee("test");
        
        assertNotNull(e2);
        assertEquals(e1.getFirstName(), e2.getFirstName());
        assertEquals(e1.getLastName(), e2.getLastName());
        assertEquals(e1.getPassword(), e2.getPassword());
        assertEquals(e1.getUsername(), e2.getUsername());
        assertEquals(e1.getTitle(), e2.getTitle());
    }
    
    @Test
    public void testRemoveEmployee() {
        Employee e1 = new Employee();
        
        e1.setFirstName("testName");
        e1.setLastName("testName");
        e1.setUsername("test");
        e1.setPassword("test");
        e1.setTitle(1);
        
        boolean result = model.addEmployee(e1);
        assertTrue(result);
        
        Employee e2 = model.getEmployee("test");
        
        model.removeEmployee(e2.getId());
        Employee e3 = model.getEmployee("test");
        assert(e3 == null);
    }
    
    @Test
    public void testEditEmployee() {
        Employee e1 = new Employee();
        e1.setFirstName("testName");
        e1.setLastName("testName");
        e1.setUsername("test");
        e1.setPassword("test");
        e1.setTitle(1);
        
        boolean result = model.addEmployee(e1);
        assertTrue(result);
             
        Employee e3 = new Employee();
        e3.setFirstName("testName1");
        e3.setLastName("testName1");
        e3.setUsername("test");
        e3.setPassword("test1");
        e1.setTitle(2);
        
        model.editEmployee(e3);
        
        Employee e2 = model.getEmployee(e1.getUsername());
        assertNotNull(e2);
        assertEquals(e3.getFirstName(), e2.getFirstName());
        assertEquals(e3.getLastName(), e2.getLastName());
        assertEquals(e3.getPassword(), e2.getPassword());
        assertEquals(e3.getUsername(), e2.getUsername());
        assertEquals(e3.getTitle(), e2.getTitle());
    }
}
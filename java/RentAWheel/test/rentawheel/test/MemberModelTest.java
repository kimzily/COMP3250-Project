package rentawheel.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import rentawheel.Member;
import rentawheel.MemberModel;

public class MemberModelTest {
    private MemberModel model;
         
    @Before
    public void setUp() {
        model = new MemberModel();
    }
    
    @After
    public void tearDown() {
        Member e = model.getMember("testName");
        if (e != null) {
            model.removeMemberByUser(e.getUsername());
        }
        model = null;
    }

    @Test
    public void testAddMember() {
        Member e1 = new Member();
        
        e1.setUsername("testName");
        e1.setPassword("test");
        e1.setFirstname("test");
        e1.setLastname("test");
        e1.setEmail("test");
        e1.setPhonenumber("1");
        e1.setDpnumber("test");
        
        boolean result = model.addMember(e1);
        assertTrue(result);
        
        Member e2 = model.getMember("testName");
        
        assertNotNull(e2);
        assertEquals(e1.getFirstname(), e2.getFirstname());
        assertEquals(e1.getLastname(), e2.getLastname());
        assertEquals(e1.getPassword(), e2.getPassword());
        assertEquals(e1.getUsername(), e2.getUsername());
        assertEquals(e1.getEmail(), e2.getEmail());
        assertEquals(e1.getPhonenumber(), e2.getPhonenumber());
        assertEquals(e1.getDpnumber(), e2.getDpnumber());
    }
    
    @Test
    public void testRemoveMember() {
        Member e1 = new Member();
        
        e1.setUsername("testName");
        e1.setPassword("test");
        e1.setFirstname("test");
        e1.setLastname("test");
        e1.setEmail("test");
        e1.setPhonenumber("1");
        e1.setDpnumber("test");
        
        boolean result = model.addMember(e1);
        assertTrue(result);
        
        Member e2 = model.getMember("testName");
        
        model.removeMember(e2.getId());
        Member e3 = model.getMember("testName");
        assert(e3 == null);
    }
    
    @Test
    public void testEditMember() {
        Member e1 = new Member();
        e1.setUsername("testName");
        e1.setPassword("test");
        e1.setFirstname("test");
        e1.setLastname("test");
        e1.setEmail("test");
        e1.setPhonenumber("1");
        e1.setDpnumber("test");
        
        boolean result = model.addMember(e1);
        assertTrue(result);
             
        Member e3 = new Member();
        e3.setUsername("testName");
        e3.setPassword("test1");
        e3.setFirstname("test1");
        e3.setLastname("test1");
        e3.setEmail("test1");
        e3.setPhonenumber("2");
        e3.setDpnumber("test1");
        
        model.editMember(e3);
        
        Member e2 = model.getMember(e1.getUsername());
        assertNotNull(e2);
        assertEquals(e3.getFirstname(), e2.getFirstname());
        assertEquals(e3.getLastname(), e2.getLastname());
        assertEquals(e3.getPassword(), e2.getPassword());
        assertEquals(e3.getUsername(), e2.getUsername());
        assertEquals(e3.getEmail(), e2.getEmail());
        assertEquals(e3.getPhonenumber(), e2.getPhonenumber());
        assertEquals(e3.getDpnumber(), e2.getDpnumber());
    }
}
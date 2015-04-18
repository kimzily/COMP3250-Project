package rentawheel;

import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class HomeScreen {
    JFrame frame = new JFrame("RAW Home Screen");
    int title;
    
    public HomeScreen(int title) {
        this.title = title;
        displayFrame();
    }
    
    private void displayFrame() {        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        
        EmployeeView ev = new EmployeeView();
        EmployeeModel em = new EmployeeModel();
        EmployeeController ec = new EmployeeController(em, ev);
        
        MemberView mv = new MemberView();
        MemberModel mm = new MemberModel();
        MemberController mc = new MemberController(mm, mv);
        
        RentalsView rv = new RentalsView();
        RentalsModel rm = new RentalsModel();
        RentalsController rc = new RentalsController(rm, rv);
        
        ReservationView rev = new ReservationView();
        ReservationModel rem = new ReservationModel();
        RentalsModel rrm = new RentalsModel();
        MemberModel rmm = new MemberModel();
        ReservationController rec = new ReservationController(rem, rmm, rrm, rev);
        
        tabbedPane.addTab("Members", mv);
        
        if (title == 1) {
            tabbedPane.addTab("Employees", ev);
        }
        
        tabbedPane.addTab("Rentals", rv);
        tabbedPane.addTab("Reservations", rev);
        
        frame.setSize(600,400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }
}
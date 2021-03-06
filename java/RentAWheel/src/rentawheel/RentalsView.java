package rentawheel;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RentalsView extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public RentalsView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        String columnNames[] = {
            "Id", "Manufacturer", "Model", "Rental Cost", "Rented", "Available"
        };
        
        t1 = new JTable();
        m1 = new DefaultTableModel(0, 0);
        t2 = new JTable();
        m2 = new DefaultTableModel(0, 0);
        t3 = new JTable();
        m3 = new DefaultTableModel(0, 0);
        
        m1.setColumnIdentifiers(columnNames);
        t1.setModel(m1);
        t1.setFillsViewportHeight(true);
        s1 = new JScrollPane(t1);
        
        m2.setColumnIdentifiers(columnNames);
        t2.setModel(m2);
        t2.setFillsViewportHeight(true);
        s2 = new JScrollPane(t2);
        
        m3.setColumnIdentifiers(columnNames);
        t3.setModel(m3);
        t3.setFillsViewportHeight(true);
        s3 = new JScrollPane(t3);
        
        pnlTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        atxtCarId = new javax.swing.JTextField();
        atxtManufacturer = new javax.swing.JTextField();
        atxtModel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        atxtAvailable = new javax.swing.JTextField();
        aboxLoan = new javax.swing.JCheckBox();
        atxtRentalCost = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rtxtCarid = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ftxtCarId = new javax.swing.JTextField();
        JLabel12 = new javax.swing.JLabel();
        JLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ftxtManufacturer = new javax.swing.JTextField();
        ftxtRentalCost = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ftxtAvailable = new javax.swing.JTextField();
        fboxLoan = new javax.swing.JCheckBox();
        ftxtModel = new javax.swing.JTextField();
        pnlViewAll = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnlViewUnavailable = new javax.swing.JPanel();

        pnlTabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel1.setText("Car Id");

        jLabel2.setText("Manufacturer");

        jLabel3.setText("Model");

        jLabel4.setText("Rental Cost");

        jLabel8.setText("On Loan");

        jLabel10.setText("Available");

        btnAdd.setText("Save");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAdd)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(atxtManufacturer, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(atxtCarId)
                    .addComponent(atxtModel)
                    .addComponent(atxtAvailable)
                    .addComponent(aboxLoan)
                    .addComponent(atxtRentalCost))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(atxtCarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(atxtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(atxtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(atxtRentalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(aboxLoan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(atxtAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addComponent(btnAdd)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pnlTabbedPane.addTab("Add Rental Car", jPanel1);

        jLabel6.setText("Car Id");

        btnRemove.setText("Remove Car");
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemove)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(rtxtCarid, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rtxtCarid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnRemove)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        pnlTabbedPane.addTab("Remove Rental Car", jPanel2);

        jLabel7.setText("Car Id");

        

        JLabel12.setText("Manufacturer");

        JLabel16.setText("Model");

        jLabel11.setText("Rental Cost");

        

        btnModify.setText("Save Changes");
        

        btnSearch.setText("Search");
        

        jLabel12.setText("Availability");

        jLabel13.setText("On Loan");

        

        

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(JLabel16)
                            .addComponent(JLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtCarId, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(ftxtManufacturer)
                                    .addComponent(ftxtRentalCost)
                                    .addComponent(ftxtAvailable)
                                    .addComponent(ftxtModel))
                                .addGap(62, 62, 62)
                                .addComponent(btnSearch))
                            .addComponent(fboxLoan)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnModify)))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ftxtCarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel12)
                    .addComponent(ftxtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel16)
                    .addComponent(ftxtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ftxtRentalCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(ftxtAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fboxLoan))
                .addGap(61, 61, 61)
                .addComponent(btnModify)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTabbedPane.addTab("Find A Rental Car", jPanel3);

        javax.swing.GroupLayout pnlViewAllLayout = new javax.swing.GroupLayout(pnlViewAll);
        pnlViewAll.setLayout(pnlViewAllLayout);
        pnlViewAllLayout.setHorizontalGroup(
            pnlViewAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        pnlViewAllLayout.setVerticalGroup(
            pnlViewAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        pnlTabbedPane.addTab("View All Rental Cars", s1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        pnlTabbedPane.addTab("View All Available Cars", s2);

        javax.swing.GroupLayout pnlViewUnavailableLayout = new javax.swing.GroupLayout(pnlViewUnavailable);
        pnlViewUnavailable.setLayout(pnlViewUnavailableLayout);
        pnlViewUnavailableLayout.setHorizontalGroup(
            pnlViewUnavailableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        pnlViewUnavailableLayout.setVerticalGroup(
            pnlViewUnavailableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        pnlTabbedPane.addTab("View All Unavailable Cars", s3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    public void display(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel JLabel12;
    private javax.swing.JLabel JLabel16;
    public javax.swing.JCheckBox aboxLoan;
    public javax.swing.JTextField atxtAvailable;
    public javax.swing.JTextField atxtCarId;
    public javax.swing.JTextField atxtManufacturer;
    public javax.swing.JTextField atxtModel;
    public javax.swing.JTextField atxtRentalCost;
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnModify;
    public javax.swing.JButton btnRemove;
    public javax.swing.JButton btnSearch;
    public javax.swing.JCheckBox fboxLoan;
    public javax.swing.JTextField ftxtAvailable;
    public javax.swing.JTextField ftxtCarId;
    public javax.swing.JTextField ftxtManufacturer;
    public javax.swing.JTextField ftxtModel;
    public javax.swing.JTextField ftxtRentalCost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel pnlViewAll;
    public javax.swing.JTabbedPane pnlTabbedPane;
    public javax.swing.JPanel pnlViewUnavailable;
    public javax.swing.JTextField rtxtCarid;
    public javax.swing.JTable t1;
    public javax.swing.table.DefaultTableModel m1;
    public javax.swing.JScrollPane s1;
    public javax.swing.JTable t2;
    public javax.swing.table.DefaultTableModel m2;
    public javax.swing.JScrollPane s2;
    public javax.swing.JTable t3;
    public javax.swing.table.DefaultTableModel m3;
    public javax.swing.JScrollPane s3;
    
    // End of variables declaration                   
}

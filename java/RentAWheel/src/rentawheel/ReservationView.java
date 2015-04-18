package rentawheel;

import javax.swing.JOptionPane;

public class ReservationView extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public ReservationView() {
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
        tblViewAll = new javax.swing.JTable();
        tblViewAllModel = new javax.swing.table.DefaultTableModel(0, 0);
        
        String columnNames[] = {
            "Id", "Carid", "Member Id", "Date Rented", "Date Returned", "Date Due"
        };
        
        tblViewAllModel.setColumnIdentifiers(columnNames);
        tblViewAll.setModel(tblViewAllModel);        
        tblViewAll.setFillsViewportHeight(true);
        scrollPane = new javax.swing.JScrollPane(tblViewAll);
        
        pnlTabbed = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        atxtDateRented = new javax.swing.JTextField();
        atxtDateReturned = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        atxtDateDue = new javax.swing.JTextField();
        acbCarId = new javax.swing.JComboBox();
        acbMemberId = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        rtxtRentalId = new javax.swing.JTextField();
        btnRemove = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ftxtRentalId = new javax.swing.JTextField();
        JLabel12 = new javax.swing.JLabel();
        JLabel16 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ftxtDateRented = new javax.swing.JTextField();
        ftxtDateDue = new javax.swing.JTextField();
        btnModify = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ftxtDateReturned = new javax.swing.JTextField();
        fcbCarId = new javax.swing.JComboBox();
        fcbMemberId = new javax.swing.JComboBox();
        pnlViewAll = new javax.swing.JPanel();

        pnlTabbed.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel2.setText("Date Rented");

        jLabel3.setText("Date Returned");

        jLabel4.setText("Date Due");

        jLabel8.setText("Car Id");

        jLabel10.setText("Member Id");

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
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(atxtDateRented, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(atxtDateReturned)
                    .addComponent(atxtDateDue)
                    .addComponent(acbCarId)
                    .addComponent(acbMemberId))
                .addContainerGap(333, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(atxtDateRented, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(atxtDateReturned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(atxtDateDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(acbCarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(acbMemberId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnAdd)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        pnlTabbed.addTab("Make A Reservation", jPanel1);

        jLabel6.setText("Rental Id");

        btnRemove.setText("Remove Reservation");
        

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
                        .addComponent(rtxtRentalId, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(339, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rtxtRentalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(btnRemove)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        pnlTabbed.addTab("Remove A Reservation", jPanel2);

        jLabel7.setText("Reservation Id");

       

        JLabel12.setText("Date Rented");

        JLabel16.setText("Date Returned");

        jLabel11.setText("Date Due");

        

        btnModify.setText("Save Changes");
        

        btnSearch.setText("Search");
        
        jLabel12.setText("Car Id");

        jLabel13.setText("Member Id");

        

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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fcbMemberId, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftxtRentalId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(ftxtDateRented, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftxtDateDue, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftxtDateReturned, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fcbCarId))
                        .addGap(62, 62, 62)
                        .addComponent(btnSearch))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnModify)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(ftxtRentalId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel12)
                    .addComponent(ftxtDateRented, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel16)
                    .addComponent(ftxtDateReturned, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(ftxtDateDue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(fcbCarId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(fcbMemberId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(btnModify)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTabbed.addTab("Find A Reservation", jPanel3);

        javax.swing.GroupLayout pnlViewAllLayout = new javax.swing.GroupLayout(pnlViewAll);
        pnlViewAll.setLayout(pnlViewAllLayout);
        pnlViewAllLayout.setHorizontalGroup(
            pnlViewAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );
        pnlViewAllLayout.setVerticalGroup(
            pnlViewAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 309, Short.MAX_VALUE)
        );

        pnlTabbed.addTab("View All Reservations", scrollPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlTabbed, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlTabbed, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
        );
    }// </editor-fold>  
    
    public void display(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel JLabel12;
    private javax.swing.JLabel JLabel16;
    public javax.swing.JComboBox acbCarId;
    public javax.swing.JComboBox acbMemberId;
    public javax.swing.JTextField atxtDateDue;
    public javax.swing.JTextField atxtDateRented;
    public javax.swing.JTextField atxtDateReturned;
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnModify;
    public javax.swing.JButton btnRemove;
    public javax.swing.JButton btnSearch;
    public javax.swing.JComboBox fcbCarId;
    public javax.swing.JComboBox fcbMemberId;
    public javax.swing.JTextField ftxtDateDue;
    public javax.swing.JTextField ftxtDateRented;
    public javax.swing.JTextField ftxtDateReturned;
    public javax.swing.JTextField ftxtRentalId;
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
    public javax.swing.JPanel pnlViewAll;
    public javax.swing.JTabbedPane pnlTabbed;
    public javax.swing.JTextField rtxtRentalId;
    public javax.swing.JTable tblViewAll;
    public javax.swing.table.DefaultTableModel tblViewAllModel;
    public javax.swing.JScrollPane scrollPane;
    // End of variables declaration                   
}
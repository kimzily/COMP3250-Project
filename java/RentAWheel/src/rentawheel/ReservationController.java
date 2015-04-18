package rentawheel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ReservationController {
    private ReservationModel rmodel;
    private MemberModel mmodel;
    private RentalsModel cmodel;
    private ReservationView view;
    
    private ArrayList<Integer> fcbCarids;
    private ArrayList<Integer> fcbMemberids;

    public ReservationController(ReservationModel rmodel, 
                                 MemberModel mmodel,
                                 RentalsModel cmodel,
                                 ReservationView view) {
        this.rmodel = rmodel;
        this.mmodel = mmodel;
        this.cmodel = cmodel;
        this.view = view;
        
        addListeners();
    }
    
    private void addListeners() {
        view.btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               addReservation();
            }
        });
        
        view.btnModify.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               modifyReservation();
           } 
        });
        
        view.btnRemove.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeReservation();
           } 
        });
        
        view.btnSearch.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               findReservation();
           } 
        });
        
        view.pnlTabbed.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                
                if (index == 3) {
                    updateViewAllTable();
                }
                
                if (index == 0) {
                    updateAddComboBoxes();
                }
                
                if (index == 2) {
                    updateFindComboBoxes();
                }
            }
        });
        
        updateAddComboBoxes();
    }
    
    private void updateAddComboBoxes() {
        ArrayList<Integer> carList = this.cmodel.getAllAvailableCarIds();
        ArrayList<Integer> memberList = this.mmodel.getAllMemberIds();
        
        DefaultComboBoxModel m1 = new DefaultComboBoxModel(carList.toArray());
        DefaultComboBoxModel m2 = new DefaultComboBoxModel(memberList.toArray());
        
        view.acbCarId.setModel(m1);
        view.acbMemberId.setModel(m2);
    }
    
    private void updateFindComboBoxes() {
        ArrayList<Integer> carList = this.cmodel.getAllAvailableCarIds();
        ArrayList<Integer> memberList = this.mmodel.getAllMemberIds();
        
        this.fcbCarids = carList;
        this.fcbMemberids = memberList;
        
        DefaultComboBoxModel m1 = new DefaultComboBoxModel(carList.toArray());
        DefaultComboBoxModel m2 = new DefaultComboBoxModel(memberList.toArray());
        
        view.fcbCarId.setModel(m1);
        view.fcbMemberId.setModel(m2);
    }
    
    private void addReservation() {
        Reservation m = new Reservation();
        m.setDateReturned(view.atxtDateReturned.getText());
        m.setDateRented(view.atxtDateRented.getText());
        m.setDateDue(view.atxtDateDue.getText());
        m.setCarid((Integer)view.acbCarId.getSelectedItem());
        m.setMemberid((Integer)view.acbMemberId.getSelectedItem());
                
        if (rmodel.addReservation(m)) {
            view.display("Reservation Added");
        } else {
            view.display("An error occurred");
        }
    }
    
    private void removeReservation() {
        Reservation m = rmodel.getReservation(Integer.parseInt(view.rtxtRentalId.getText()));
        
        if (m == null) {
            view.display("Reservation Not Found");
        } else {
            rmodel.removeReservation(m.getId());
            view.display("Reservation Removed");
        }
    }
    
    private void findReservation() {
        int id = Integer.parseInt(view.ftxtRentalId.getText());
        Reservation m = rmodel.getReservation(id);
        
        if (m == null) {
            view.display("Reservation Not Found");
        } else {
            view.ftxtDateRented.setText(m.getDateRented());
            view.ftxtDateReturned.setText(m.getDateReturned());
            view.ftxtDateDue.setText(m.getDateDue());
            
            int index = 0;
            for (Integer i: this.fcbCarids) {
                if (i == m.getCarid()) {
                    break;
                }
                
                index += 1;
            }
            
            view.fcbCarId.setSelectedIndex(index);
            
            index = 0;
            for (Integer i: this.fcbMemberids) {
                if (i == m.getCarid()) {
                    break;
                }
                
                index += 1;
            }
            
            view.fcbMemberId.setSelectedIndex(index);
        }
    }
        
    private void modifyReservation() {
        Reservation m = new Reservation();
        
        m.setId(Integer.parseInt(view.ftxtRentalId.getText()));
        m.setDateReturned(view.ftxtDateReturned.getText());
        m.setDateRented(view.ftxtDateRented.getText());
        m.setDateDue(view.ftxtDateDue.getText());
        m.setCarid((Integer)view.fcbCarId.getSelectedItem());
        m.setMemberid((Integer)view.fcbMemberId.getSelectedItem());

        rmodel.editReservation(m);
        view.display("Reservation Updated");
    }
    
    private void updateViewAllTable() {
        ArrayList<Reservation> list = rmodel.getAllReservations();
        
        view.tblViewAllModel.setRowCount(0);
        
        for (Reservation m: list) {
            view.tblViewAllModel.addRow(new Object[] {
                String.valueOf(m.getId()),
                String.valueOf(m.getCarid()),
                String.valueOf(m.getMemberid()),
                m.getDateRented(),
                m.getDateReturned(),
                m.getDateDue()
            });
        }
        
        view.tblViewAllModel.fireTableDataChanged();
    }
}
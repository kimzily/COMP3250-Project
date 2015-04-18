package rentawheel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RentalsController {
    private RentalsModel model;
    private RentalsView view;
    
    public RentalsController(RentalsModel model, RentalsView view) {
        this.model = model;
        this.view = view;
        
        addListeners();
    }
    
    private void addListeners() {
        view.btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               addRentals();
            }
        });
        
        view.btnModify.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               modifyRentals();
           } 
        });
        
        view.btnRemove.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeRentals();
           } 
        });
        
        view.btnSearch.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               findRentals();
           } 
        });
        
        view.pnlTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();

                if (index == 3) {
                    updateViewAllTable();
                }
                
                if (index == 4) {
                    updateViewAllAvailableTable();
                }
                
                if (index == 5) {
                    updateViewAllUnavailableTable();
                }
            }
        });
    }
    
    private void addRentals() {
        Rentals m = new Rentals();
        m.setId(Integer.parseInt(view.atxtCarId.getText()));
        m.setManufacturer(view.atxtManufacturer.getText());
        m.setModel(view.atxtModel.getText());
        m.setRentalcost(view.atxtRentalCost.getText());
        m.setRented(view.aboxLoan.isSelected());
        m.setAvailability(view.atxtAvailable.getText());
                
        if (model.addRental(m)) {
            view.display("Rental Added");
        } else {
            view.display("An error occurred");
        }
    }
    
    private void removeRentals() {
        Rentals m = model.getRental(Integer.parseInt(view.rtxtCarid.getText()));
        
        if (m == null) {
            view.display("Rental Not Found");
        } else {
            model.removeRental(m.getId());
            view.display("Rental Removed");
        }
    }
    
    private void findRentals() {
        int id = Integer.parseInt(view.ftxtCarId.getText());
        Rentals m = model.getRental(id);
        
        if (m == null) {
            view.display("Rental Not Found");
        } else {
            view.ftxtManufacturer.setText(m.getManufacturer());
            view.ftxtModel.setText(m.getModel());
            view.ftxtRentalCost.setText(m.getRentalcost());
            view.fboxLoan.setSelected(m.isRented());
            view.ftxtAvailable.setText(m.getAvailability());
        }
    }
        
    private void modifyRentals() {
        Rentals m = new Rentals();
        
        m.setId(Integer.parseInt(view.ftxtCarId.getText()));
        m.setManufacturer(view.ftxtManufacturer.getText());
        m.setModel(view.ftxtModel.getText());
        m.setRentalcost(view.ftxtRentalCost.getText());
        m.setRented(view.fboxLoan.isSelected());
        m.setAvailability(view.ftxtAvailable.getText());

        model.editRental(m);
        view.display("Rental Updated");
    }
    
    private void updateViewAllTable() {
        ArrayList<Rentals> list = model.getAllRentals();
        
        view.m1.setRowCount(0);
        
        for (Rentals m: list) {
            view.m1.addRow(new Object[] {
                String.valueOf(m.getId()),
                m.getManufacturer(),
                m.getModel(),
                m.getRentalcost(),
                m.isRented() ? "True" : "False", 
                m.getAvailability()
            });
        }
        
        view.m1.fireTableDataChanged();
    }
    
    private void updateViewAllAvailableTable() {
        ArrayList<Rentals> list = model.getAllAvailableRentals();
        
        view.m2.setRowCount(0);
        
        for (Rentals m: list) {
            view.m2.addRow(new Object[] {
                String.valueOf(m.getId()),
                m.getManufacturer(),
                m.getModel(),
                m.getRentalcost(),
                m.isRented() ? "True" : "False", 
                m.getAvailability()
            });
        }
        
        view.m2.fireTableDataChanged();
    }
    
    private void updateViewAllUnavailableTable() {
        ArrayList<Rentals> list = model.getAllUnavailableRentals();
        
        view.m3.setRowCount(0);
        
        for (Rentals m: list) {
            view.m3.addRow(new Object[] {
                String.valueOf(m.getId()),
                m.getManufacturer(),
                m.getModel(),
                m.getRentalcost(),
                m.isRented() ? "True" : "False", 
                m.getAvailability()
            });
        }
        
        view.m3.fireTableDataChanged();
    }
}
package rentawheel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeController {
    private EmployeeModel model;
    private EmployeeView view;
    
    public EmployeeController(EmployeeModel model, EmployeeView view) {
        this.model = model;
        this.view = view;
        
        addListeners();
    }
    
    private void addListeners() {
        view.btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               addEmployee();
            }
        });
        
        view.btnModify.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               modifyEmployee();
           } 
        });
        
        view.btnRemove.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeEmployee();
           } 
        });
        
        view.btnSearch.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               findEmployee();
           } 
        });
    }
    
    private void addEmployee() {
        Employee e = new Employee();
        e.setFirstName(view.atxtFirstName.getText());
        e.setLastName(view.atxtLastName.getText());
        e.setPassword(view.atxtPassword.getText());
        e.setUsername(view.atxtUsername.getText());
        
        int title;
        if (view.aboxTitle.isSelected()) {
            title = 1;
        } else {
            title = 2;
        }
        
        e.setTitle(title);
        
        if (model.addEmployee(e)) {
            view.display("Employee Added");
        } else {
            view.display("An error occurred");
        }
    }
    
    private void removeEmployee() {
        Employee e = model.getEmployee(view.rtxtUsername.getText());
        
        if (e == null) {
            view.display("Employee Not Found");
        } else {
            model.removeEmployee(e.getId());
            view.display("Employee Removed");
        }
    }
    
    private void findEmployee() {
        String username = view.ftxtUsername.getText();
        Employee e = model.getEmployee(username);
        
        if (e == null) {
            view.display("Employee Not Found");
        } else {
            view.ftxtFirstName.setText(e.getFirstName());
            view.ftxtLastName.setText(e.getLastName());
            view.ftxtPassword.setText(e.getPassword());
            view.fboxTitle.setSelected(e.getTitle() == 1);
        }
    }
        
    private void modifyEmployee() {
        Employee e = new Employee();
        e.setFirstName(view.ftxtFirstName.getText());
        e.setLastName(view.ftxtLastName.getText());
        e.setPassword(view.ftxtPassword.getText());
        e.setTitle(view.fboxTitle.isSelected() ? 1 : 2);
        e.setUsername(view.ftxtUsername.getText());

        model.editEmployee(e);
        view.display("Employee Updated");
    }
}
package rentawheel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MemberController {
    private MemberModel model;
    private MemberView view;
    
    public MemberController(MemberModel model, MemberView view) {
        this.model = model;
        this.view = view;
        
        addListeners();
    }
    
    private void addListeners() {
        view.btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               addMember();
            }
        });
        
        view.btnModify.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               modifyMember();
           } 
        });
        
        view.btnRemove.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeMember();
           } 
        });
        
        view.btnSearch.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               findMember();
           } 
        });
        
        view.jTabbedPane1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
                int index = sourceTabbedPane.getSelectedIndex();
                System.out.println(index);
                if (index == 3) {
                    updateViewAllTable();
                }
            }
        });
    }
    
    private void addMember() {
        Member m = new Member();
        m.setFirstname(view.atxtFirstName.getText());
        m.setLastname(view.atxtLastName.getText());
        m.setPassword(view.atxtPassword.getText());
        m.setUsername(view.atxtUsername.getText());
        m.setDpnumber(view.atxtDPNumber.getText());
        m.setPhonenumber(view.atxtPhoneNumber.getText());
        m.setEmail(view.atxtEmail.getText());
                
        if (model.addMember(m)) {
            view.display("Member Added");
        } else {
            view.display("An error occurred");
        }
    }
    
    private void removeMember() {
        Member m = model.getMember(view.rtxtUsername.getText());
        
        if (m == null) {
            view.display("Member Not Found");
        } else {
            model.removeMember(m.getId());
            view.display("Member Removed");
        }
    }
    
    private void findMember() {
        String username = view.ftxtUsername.getText();
        Member m = model.getMember(username);
        
        if (m == null) {
            view.display("Member Not Found");
        } else {
            view.ftxtFirstName.setText(m.getFirstname());
            view.ftxtLastName.setText(m.getLastname());
            view.ftxtPassword.setText(m.getPassword());
            view.ftxtDPNumber.setText(m.getDpnumber());
            view.ftxtEmail.setText(m.getEmail());
            view.ftxtPhoneNumber.setText(m.getPhonenumber());
        }
    }
        
    private void modifyMember() {
        Member m = new Member();
        
        m.setFirstname(view.ftxtFirstName.getText());
        m.setLastname(view.ftxtLastName.getText());
        m.setPassword(view.ftxtPassword.getText());
        m.setUsername(view.ftxtUsername.getText());
        m.setDpnumber(view.ftxtDPNumber.getText());
        m.setPhonenumber(view.ftxtPhoneNumber.getText());
        m.setEmail(view.ftxtEmail.getText());

        model.editMember(m);
        view.display("Member Updated");
    }
    
    private void updateViewAllTable() {
        ArrayList<Member> list = model.getAllMembers();
        
        view.tblViewAllModel.setRowCount(0);
        
        for (Member m: list) {
            view.tblViewAllModel.addRow(new Object[] {
                m.getUsername(),
                m.getPassword(),
                m.getEmail(),
                m.getFirstname(),
                m.getLastname(),
                m.getPhonenumber(),
                m.getDpnumber(),
                String.valueOf(m.getId())
            });
        }
        
        view.tblViewAllModel.fireTableDataChanged();
    }
}

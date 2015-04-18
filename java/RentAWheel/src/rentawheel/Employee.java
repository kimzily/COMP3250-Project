package rentawheel;

public class Employee {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private int title;
    
    public void setId(int i) {
        this.id = i;
    }
    
    public void setUsername(String u) {
        this.username = u;
    }
    
    public void setPassword(String p) {
        this.password = p;
    }
    
    public void setFirstName(String f) {
        this.firstname = f;
    }
    
    public void setLastName(String l) {
        this.lastname = l;
    }
    
    public void setTitle(int t) {
        this.title = t;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getFirstName() {
        return this.firstname;
    }
    
    public String getLastName() {
        return this.lastname;
    }
    
    public int getTitle() {
        return this.title;
    }
}
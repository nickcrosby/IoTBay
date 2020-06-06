package uts.isd.model;

public class Staff {

    //Registration data fields
    private String fname;
    private String lname;
    private String password;
    private String dob;
    private String email;
    private String address;
    private String phone;

    //Initialise constructor with user fields
    public Staff(String fname, String lname, String password, String email) {
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

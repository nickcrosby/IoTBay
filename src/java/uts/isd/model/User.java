package uts.isd.model;

public class User {

    //Registration data fields
    private String fname;
    private String lname;
    private String password;
    private String dob;
    private String email;
    private String address;
    private String phone;
    private String id;

    //Initialise constructor with user fields
    public User(String email, String fname, String lname, String password, String dob, String phone) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.dob = dob;
        this.phone = phone;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

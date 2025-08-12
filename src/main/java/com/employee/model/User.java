package com.employee.model;

public class User {

    private int emp_id;
    private String emp_name;
    private String email;
    private String phoneno;
    private String city;
    private String gender;
    private String password;  // add password field

    // Constructor without password (for display, update without password)
    public User(int emp_id, String emp_name, String email, String phoneno, String city, String gender) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.email = email;
        this.phoneno = phoneno;
        this.city = city;
        this.gender = gender;
    }

    // Constructor with password (for login and registration)
    public User(int emp_id, String emp_name, String email, String phoneno, String city, String gender, String password) {
        this(emp_id, emp_name, email, phoneno, city, gender);
        this.password = password;
    }

    // Getters and setters

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

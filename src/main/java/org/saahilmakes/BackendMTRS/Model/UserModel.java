package org.saahilmakes.BackendMTRS.Model;

import jakarta.persistence.*;
@Entity
@Table(name = "`users`")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long user_id;


    private String role;

    private String username;

    private String password;

    private String email;

    private Integer phone;

    public long getUser_id() {
        return user_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}

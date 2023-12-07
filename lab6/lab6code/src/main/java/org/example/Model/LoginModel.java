package org.example.Model;

import org.example.Customer.Customer;
import org.example.Customer.JsonUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

/**
 * @author nbdhc
 */ // Model
public class LoginModel {
    private String userId;
    private String password;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Business Logic
    public boolean authenticate() {
        try {
            List<Customer> customers = JsonUtil.deserializeCustomers();
            for (Customer customer : customers) {
                if (customer.getUsername().equals(userId) && customer.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

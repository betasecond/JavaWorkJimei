package org.example.Table;


import org.example.Customer.Customer;
import org.example.Customer.JsonUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class UserList {
    public static void main(String[] args) {
        // 创建窗口
        JFrame frame = new JFrame("Customer Data");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // 创建表格
        String[] columnNames = {"Name", "Gender", "Phone", "Username", "Password"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(model);

        // 填充数据
        try {
            List<Customer> customers = JsonUtil.deserializeCustomers();
            for (Customer customer : customers) {
                model.addRow(new Object[]{
                        customer.getName(),
                        customer.getGender(),
                        customer.getPhone(),
                        customer.getUsername(),
                        customer.getPassword() // 注意：实际应用中不应在界面上展示密码
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将表格加入到滚动面板，并将滚动面板加入到窗口
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        // 显示窗口
        frame.setVisible(true);
    }
}

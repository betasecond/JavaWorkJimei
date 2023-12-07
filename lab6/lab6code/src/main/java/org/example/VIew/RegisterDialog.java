package org.example.VIew;
import org.example.Customer.Customer;
import org.example.Customer.JsonUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class RegisterDialog extends JDialog {
    private JTextField txtUsername = new JTextField(20);
    private JPasswordField txtPassword = new JPasswordField(20);
    private JPasswordField txtConfirmPassword = new JPasswordField(20);
    private JButton btnRegister = new JButton("注册");
    private JButton btnCancel = new JButton("取消");
    private JTextField txtGender = new JTextField(20);
    private JTextField txtPhone = new JTextField(20);

    public RegisterDialog(Frame parent) {
        super(parent, "注册", true);

        // Layout components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(createInputPanel(new JLabel("用户名："), txtUsername));
        add(createInputPanel(new JLabel("密码："), txtPassword));
        add(createInputPanel(new JLabel("确认密码："), txtConfirmPassword));
        add(createInputPanel(new JLabel("性别："), txtGender));
        add(createInputPanel(new JLabel("手机号："), txtPhone));
        add(createButtonPanel());
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerNewCustomer();
            }
        });
        pack(); // Adjusts size to fit components
        setLocationRelativeTo(parent); // Centers the dialog relative to the parent frame
    }

    private JPanel createInputPanel(JLabel label, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(label);
        panel.add(textField);
        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnCancel);

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Closes and disposes of the dialog
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registerNewCustomer();
            }
        });

        return buttonPanel;
    }
    private void registerNewCustomer() {
        String username = txtUsername.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        String gender = txtGender.getText();
        String phone = txtPhone.getText();

        // 数据验证
        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "用户名和密码不能为空", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "两次输入的密码不匹配", "错误", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 读取现有的客户列表
            List<Customer> customers;
            try {
                customers = JsonUtil.deserializeCustomers();
            } catch (IOException ex) {
                // 如果反序列化失败，假定是因为文件不存在或为空，我们将创建一个新列表
                customers = new ArrayList<>();
            }

            // 创建新的Customer对象并添加到列表
            Customer newCustomer = new Customer(username, gender, phone, username, password);
            customers.add(newCustomer);

            // 序列化更新后的客户列表
            JsonUtil.serializeCustomers(customers);
            JOptionPane.showMessageDialog(this, "注册成功！");
            dispose(); // 关闭对话框
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "注册失败: " + ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Getters for username and passwords, and other logic like validation can be added here
    // ...
}


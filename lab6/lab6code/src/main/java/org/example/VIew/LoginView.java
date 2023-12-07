package org.example.VIew;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

// View
public class LoginView extends JFrame {
    private JTextField txtUserId = new JTextField(20);
    private JPasswordField txtPassword = new JPasswordField(20);





    private JButton btnLogin = new JButton("登录");
    private JButton btnRegister = new JButton("注册");

    public LoginView() {
        super("登录");
        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Construct the frame



        setSize(300, 400);  // 稍微增加窗口宽度和长度
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));  // 设置BoxLayout

        // User ID Panel
        JPanel userIdPanel = new JPanel();
        userIdPanel.add(new JLabel("账户："));
        userIdPanel.add(txtUserId);

        // Password Panel
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("密码："));
        passwordPanel.add(txtPassword);

        JPanel userPanel = new JPanel();
        userPanel.add(userIdPanel);
        userPanel.add(passwordPanel);

        JPanel userTypePanel = new JPanel();
        Vector<String> element = new Vector<String>();
        element.addElement("用户");
        element.addElement("管理员");
        JComboBox<String> userType = new JComboBox<>(element);
        userType.setSelectedItem(element);
        userTypePanel.add(new JLabel("账户类型："));
        userTypePanel.add(userType);
        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnLogin);

        // Add panels to frame
        add(Box.createVerticalStrut(50));  // 为了美观，添加一些垂直间隔
        add(userPanel);
        add(userTypePanel);
        add(Box.createVerticalStrut(20));  // 增加更大的间隔在按钮前
        add(buttonPanel);

        btnRegister.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterDialog registerDialog = new RegisterDialog(LoginView.this);
                registerDialog.setVisible(true);
            }
        });

    }

    public String getUserId() {
        return txtUserId.getText();
    }

    public String getPassword() {
        return new String(txtPassword.getPassword());
    }

    public void setLoginListener(ActionListener listener) {
        btnLogin.addActionListener(listener);
    }

    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
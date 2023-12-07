package org.example.Control;

import org.example.Model.LoginModel;
import org.example.VIew.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author nbdhc
 */ // Controller
public class LoginController {
    private LoginModel model;
    private LoginView view;

    public LoginController(LoginModel model, LoginView view) {
        this.model = model;
        this.view = view;

        view.setLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setUserId(view.getUserId());
                model.setPassword(view.getPassword());
                if (model.authenticate()) {
                    JOptionPane.showMessageDialog(view, "登录成功！");
                } else {
                    view.showErrorDialog("登录失败！");
                }
            }
        });
    }
}

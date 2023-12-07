package org.example.Entrance;

import org.example.Control.LoginController;
import org.example.Model.LoginModel;
import org.example.VIew.LoginView;

import javax.swing.*;

/**
 * @author nbdhc
 */ // Main
public class LoginMVC {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginModel model = new LoginModel();
                LoginView view = new LoginView();
                LoginController controller = new LoginController(model, view);
                view.setVisible(true);
            }
        });
    }
}
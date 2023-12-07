package org.example.Customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Customer> customers = new ArrayList<>();
            customers.add(new Customer("Beta", "Female", "1234567890", "beta1025", "password123"));
            // 可以继续添加其他客户到列表中
            // customers.add(new Customer("其他客户的信息..."));

            JsonUtil.serializeCustomers(customers); // 序列化整个客户列表

            List<Customer> readCustomers = JsonUtil.deserializeCustomers(); // 反序列化客户列表
            for (Customer customer : readCustomers) {
                System.out.println(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

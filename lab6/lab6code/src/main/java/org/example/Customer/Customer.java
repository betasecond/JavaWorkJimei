package org.example.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author nbdhc
 */
@Getter
@Setter
public class Customer {
    @JsonProperty("name")
    private String name;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    // 构造函数、getters 和 setters
    public Customer() {
    }

    public Customer(String name, String gender, String phone, String username, String password) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    // 省略其他getters和setters...

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + this.getName() + '\'' +
                ", gender='" + this.getGender() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", username='" + this.getUsername() + '\'' +
                ", password='" + this.getPassword() + '\'' +
                '}';
    }
}


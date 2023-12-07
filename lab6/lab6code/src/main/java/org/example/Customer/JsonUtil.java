package org.example.Customer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author nbdhc
 */
public class JsonUtil {

    private static final String FILE_NAME = "lab6/lab6code/src/main/resources/customerDatas.json"; // JSON文件名

    // 将客户对象列表序列化到文件
    public static void serializeCustomers(List<Customer> customers) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // 美化输出
        mapper.writeValue(new File(FILE_NAME), customers);
    }

    // 从文件反序列化客户对象列表
    public static List<Customer> deserializeCustomers() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(FILE_NAME), new TypeReference<>() {
        });
    }
}

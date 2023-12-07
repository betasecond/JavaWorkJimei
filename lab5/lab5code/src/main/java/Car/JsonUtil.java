package Car;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonUtil {
    private static final String JSON_FILE_PATH = "src/main/resources/cars.json";


    public static ArrayList<Car> serializeCars(ArrayList<Car> cars) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(JSON_FILE_PATH), new TypeReference<ArrayList<Car>>() {});
    }
}

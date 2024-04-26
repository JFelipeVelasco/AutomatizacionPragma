package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ModelLogIn {
    String user;
    String password;

    public static List<ModelLogIn> setData(DataTable dataTable) {

        List<ModelLogIn> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();

        for (Map<String, String> map : mapInfo) {
            data.add(new ObjectMapper().convertValue(map, ModelLogIn.class));
        }
        return data;
    }
}

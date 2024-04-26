package models;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ModelProducts {

    String productName;
    String category;
    String productName2;
    String category2;
    int quantity;
    int price;

    public static List<ModelProducts> setData(DataTable dataTable) {

        List<ModelProducts> data = new ArrayList<>();
        List<Map<String, String>> mapInfo = dataTable.asMaps();

        for (Map<String, String> map : mapInfo) {
            data.add(new ObjectMapper().convertValue(map, ModelProducts.class));
        }
        return data;
    }
}

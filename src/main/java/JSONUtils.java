import model.Employee;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {
    private static final String FILEPATH = "src/main/resources/";
    private static final String FILEEXTENSION = ".json";


    public static List<Employee> readEmployees(String filename) throws IOException {
        List<Employee> employees = new ArrayList<Employee>();

        JSONParser parser = new JSONParser();
        JSONArray jsonArr = null;
        try {
            jsonArr = (JSONArray) parser
                    .parse(new FileReader(FILEPATH + filename + FILEEXTENSION));
        } catch (ParseException e) {
            System.out.println("!!! Corrupted file !!!");
            e.printStackTrace();
            return null;
        }

        if (jsonArr != null) {
            for (Object o : jsonArr) {
                Employee employee = new Employee();
                JSONObject empJson = (JSONObject) o;
                employee.setName((String) empJson.get("name"));
                employee.setTotalSales((Long) empJson.get("totalSales"));
                employee.setSalesPeriod((Long) empJson.get("salesPeriod"));
                employee.setExperienceMultiplier((Double) empJson.get("experienceMultiplier"));
                employees.add(employee);
            }
        }

        return employees;
    }

//    public static Employee test() {
//        JSONParser parser = new JSONParser();
//        Gson gson = new Gson();
//        Employee employee = null;
//        try {
//            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src\\main\\resources\\test.json"));
//            employee = gson.fromJson(jsonObject.toString(), Employee.class);
//            System.out.println(employee.getName());
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return employee;
//    }
}

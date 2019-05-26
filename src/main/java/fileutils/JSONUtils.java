package fileutils;

import model.Employee;
import model.ReportDefinition;
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
    private static final String FILE_EXTENSION = ".json";


    public static List<Employee> getEmployees(String filename) throws IOException {
        List<Employee> employees = new ArrayList<>();

        JSONParser parser = new JSONParser();
        JSONArray jsonArr = null;

        try (FileReader fileReader = new FileReader(FILEPATH + filename + FILE_EXTENSION)) {
            jsonArr = (JSONArray) parser.parse(fileReader);
        } catch (ParseException e) {
            System.out.println("!!! Corrupted file !!!");
            e.printStackTrace();
        }

        if (jsonArr != null) {
            for (Object o : jsonArr) {
                Employee employee = new Employee();
                JSONObject empJson = (JSONObject) o;
                employee.setName((String) empJson.get("name"));
                employee.setTotalSales(((Long) empJson.get("totalSales")).intValue());
                employee.setSalesPeriod(((Long) empJson.get("salesPeriod")).intValue());
                employee.setExperienceMultiplier((Double) empJson.get("experienceMultiplier"));
                employees.add(employee);
            }
        }
        return employees;
    }


    public static ReportDefinition getReportDefinition(String filename) throws IOException {
        ReportDefinition reportDefinition = new ReportDefinition();

        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try (FileReader fileReader = new FileReader(FILEPATH + filename + FILE_EXTENSION)) {
            jsonObject = (JSONObject) parser.parse(fileReader);
        } catch (ParseException e) {
            System.out.println("!!! Corrupted file !!!");
            e.printStackTrace();
        }

        if (jsonObject != null) {
            reportDefinition.setTopPerformersThreshold(((Long) jsonObject.get("topPerformersThreshold")).intValue());
            reportDefinition.setUseExprienceMultiplier((Boolean) jsonObject.get("useExprienceMultiplier"));
            reportDefinition.setPeriodLimit(((Long) jsonObject.get("periodLimit")).intValue());
        }

        return reportDefinition;
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

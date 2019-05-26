import model.Employee;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<Employee> a = JSONUtils.readEmployees("data");

        for (Employee employee : a) {
            System.out.println(">>>" + employee);
        }
    }
}

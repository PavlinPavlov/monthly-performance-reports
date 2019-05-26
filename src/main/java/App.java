import fileutils.JSONUtils;
import fileutils.TxtUtils;
import model.Employee;
import model.ReportDefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = null;
        ReportDefinition reportDefinition = null;

        while (true) {
            try {
                System.out.print("Enter file with data: ");
                String fileData = scanner.nextLine();
                System.out.print("Enter file with definition: ");
                String fileDefinition = scanner.nextLine();

                employees = JSONUtils.getEmployees(fileData);
                reportDefinition = JSONUtils.getReportDefinition(fileDefinition);

                break;
            } catch (IOException e) {
                System.out.println("No such files!\n");
                System.out.println("Enter again!");
            }
        }

        System.out.print("Enter name of output file: ");
        String outFile = scanner.nextLine();


        Map<String, Double> map = new HashMap<>();
        map.put("David Prowless", 12.6);
        map.put("Ivan1", 2.6);
        map.put("Ivan2", 42.6);
        map.put("Ivan3", 13.0);

        TxtUtils.writeResults("test", map);
    }
}

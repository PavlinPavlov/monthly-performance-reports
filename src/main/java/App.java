import file_helpers.JSONUtils;
import file_helpers.TxtUtils;
import models.Employee;
import models.ReportDefinition;
import utils.Calculator;
import utils.Filter;

import java.io.IOException;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees;
        ReportDefinition reportDefinition = null;

        while (true) {
            System.out.print("Enter file with data: ");
            String fileData = scanner.nextLine();
            System.out.print("Enter file with definition: ");
            String fileDefinition = scanner.nextLine();

            try {
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

        Calculator.calculateScores(employees, reportDefinition.isUseExperienceMultiplier());
        List<Employee> result = Filter.filter(employees, reportDefinition);

        TxtUtils.writeResults(outFile, result);
        //TxtUtils.writeResults(outFile, employees);
    }
}

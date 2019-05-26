package utils;

import models.CsvEmpModel;
import models.Employee;
import models.ReportDefinition;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static List<CsvEmpModel> filter(List<Employee> employees, ReportDefinition repDef) {
        List<CsvEmpModel> result = new ArrayList<>();

        int periodLimit = repDef.getPeriodLimit();

        int empCount = employees.size();
        int topPercent = repDef.getTopPerformersThreshold();
        int topEmpCount = (empCount * topPercent) / 100;

        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getSalesPeriod() < periodLimit)
                .sorted(Comparator.comparingDouble(Employee::getScore).reversed())
                .limit(topEmpCount)
                .collect(Collectors.toList());

        filteredEmployees.forEach(emp -> result.add(new CsvEmpModel(emp.getName(), round(emp.getScore()))));

        return result;
    }


    private static double round(double value) {
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}

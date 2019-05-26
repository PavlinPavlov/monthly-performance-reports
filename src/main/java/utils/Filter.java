package utils;

import models.Employee;
import models.ReportDefinition;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {

    public static List<Employee> filter(List<Employee> employees, ReportDefinition repDef) {
        int periodLimit = repDef.getPeriodLimit();

        int empCount = employees.size();
        int topPercent = repDef.getTopPerformersThreshold();
        int topEmpCount = (empCount * topPercent) / 100;

        return employees.stream()
                .filter(e -> e.getSalesPeriod() < periodLimit)
                .sorted(Comparator.comparingDouble(Employee::getScore).reversed())
                .limit(topEmpCount)
                .collect(Collectors.toList());
    }
}

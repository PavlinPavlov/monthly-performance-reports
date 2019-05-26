package utils;

import models.Employee;

import java.util.List;

public class Calculator {
    public static void calculateScores(List<Employee> employees, boolean useMultiplier) {
        for (Employee emp : employees) {
            int totalSales = emp.getTotalSales();
            int salesPeriod = emp.getSalesPeriod();
            double score = totalSales / salesPeriod;
            if (useMultiplier) {
                score *= emp.getExperienceMultiplier();
            }
            emp.setScore(score);
        }
    }
}

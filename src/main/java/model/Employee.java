package model;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int totalSales;
    private int salesPeriod;
    private double experienceMultiplier;

    public Employee() {
    }

    public Employee(String name, int totalSales, int salesPeriod, double experienceMultiplier) {
        this.name = name;
        this.totalSales = totalSales;
        this.salesPeriod = salesPeriod;
        this.experienceMultiplier = experienceMultiplier;
    }


    // Getters, Setters & toString()
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(int totalSales) {
        this.totalSales = totalSales;
    }

    public int getSalesPeriod() {
        return salesPeriod;
    }

    public void setSalesPeriod(int salesPeriod) {
        this.salesPeriod = salesPeriod;
    }

    public double getExperienceMultiplier() {
        return experienceMultiplier;
    }

    public void setExperienceMultiplier(double experienceMultiplier) {
        this.experienceMultiplier = experienceMultiplier;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", totalSales=" + totalSales +
                ", salesPeriod=" + salesPeriod +
                ", experienceMultiplier=" + experienceMultiplier +
                '}';
    }
}

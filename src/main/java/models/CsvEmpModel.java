package models;

public class CsvEmpModel {
    private String name;
    private double score;

    public CsvEmpModel() {
    }

    public CsvEmpModel(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}

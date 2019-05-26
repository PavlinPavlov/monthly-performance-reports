package model;

public class ReportDefinition {
    private int topPerformersThreshold;
    private boolean useExprienceMultiplier;
    private int periodLimit;

    public ReportDefinition() {
    }

    public ReportDefinition(int topPerformersThreshold, boolean useExprienceMultiplier, int periodLimit) {
        this.topPerformersThreshold = topPerformersThreshold;
        this.useExprienceMultiplier = useExprienceMultiplier;
        this.periodLimit = periodLimit;
    }

    //Getters, Setters
    public int getTopPerformersThreshold() {
        return topPerformersThreshold;
    }

    public void setTopPerformersThreshold(int topPerformersThreshold) {
        this.topPerformersThreshold = topPerformersThreshold;
    }

    public boolean isUseExprienceMultiplier() {
        return useExprienceMultiplier;
    }

    public void setUseExprienceMultiplier(boolean useExprienceMultiplier) {
        this.useExprienceMultiplier = useExprienceMultiplier;
    }

    public int getPeriodLimit() {
        return periodLimit;
    }

    public void setPeriodLimit(int periodLimit) {
        this.periodLimit = periodLimit;
    }
}

package CS591.GradeManageSystem.entity;

public interface Calculable {
    // under condition whether to use default method or normal method
    double getMedian();

    double getMean();

    double getMax();

    double getMin();

    double getStdDev();
}

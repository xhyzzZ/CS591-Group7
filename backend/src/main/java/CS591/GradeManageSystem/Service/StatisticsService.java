package CS591.GradeManageSystem.Service;

public interface StatisticsService {

    public double[] getStatistics(int assignmentId, int courseId);

    public double getMax(double[] res);

    public double getMin(double[] res);

    public double getMean(double[] res);

    public double getMedium(double[] res);

    public double getStdDev(double[] res);
}

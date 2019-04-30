package CS591.GradeManageSystem.Service.impl;

import CS591.GradeManageSystem.DAO.Impl.AssignmentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.StudentRepositoryImpl;
import CS591.GradeManageSystem.DAO.Impl.UnitRepositoryImpl;
import CS591.GradeManageSystem.Service.StatisticsService;
import CS591.GradeManageSystem.entity.Student;

import java.util.Arrays;
import java.util.List;

public class StatisticsServiceImpl implements StatisticsService {

    private UnitRepositoryImpl unitRepository = new UnitRepositoryImpl();
    private AssignmentRepositoryImpl assignmentRepository = new AssignmentRepositoryImpl();
    private StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

    @Override
    public double[] getStatistics(int assignmentId, int courseId) {
        List<Student> students = studentRepository.findByCourseId(courseId);
        double[] res = new double[students.size()];
        for(int i = 0; i < students.size(); i++) {
            res[i] = Double.parseDouble(unitRepository.findByAssignmentIdAndStudentId(assignmentId, students.get(i).getStudentId()).getContent());
        }
        return res;
    }

    @Override
    public double getMax(double[] res) {
        double max = 0;
        for(int i = 0; i < res.length; i++) {
            max = Math.max(max, res[i]);
        }
        return max;
    }

    @Override
    public double getMin(double[] res) {
        double min = 0;
        for(int i = 0; i < res.length; i++) {
            min = Math.min(min, res[i]);
        }
        return min;
    }

    @Override
    public double getMean(double[] res) {
        if (res.length == 0) return 0;
        double sum = 0;
        for(int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum / res.length;
    }

    @Override
    public double getMedium(double[] res) {
        double medium = 0;
        Arrays.sort(res);
        if(res.length % 2 == 1) {
            medium = res[res.length / 2];
        }
        if(res.length % 2 == 0) {
            medium = res[res.length / 2 - 1];
        }
        return medium;
    }

    @Override
    public double getStdDev(double[] res) {
        int len = res.length;
        double sum = 0;
        for(int i = 0; i < len; i++) {
            sum += res[i];
        }
        double dAve = sum / len;
        double dVar = 0;
        for(int i = 0; i < len; i++) {
            dVar += (res[i] - dAve) * (res[i] - dAve);
        }
        return Math.sqrt(dVar / len);
    }
}

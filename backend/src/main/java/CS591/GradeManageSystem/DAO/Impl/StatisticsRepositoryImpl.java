package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.StatisticsRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Statistics;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StatisticsRepositoryImpl implements StatisticsRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public List<Statistics> getStatistics() {
        List<Statistics> statistics = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = "SELECT * FROM STATISTICS";
            pst = conn.prepareStatement("exec");

            // execute the operation
            rs = pst.executeQuery();
            while (rs.next()) {
                Statistics assignment = new Statistics(rs.getInt("assignmentId"),
                        rs.getDouble("median"),
                        rs.getDouble("mean"),
                        rs.getDouble("max"),
                        rs.getDouble("min"),
                        rs.getDouble("stdDev"));

                statistics.add(assignment);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return statistics;
    }

    @Override
    public void save(Statistics statistics) {
        try {
            conn = AppConf.getConnection();

            int assignmentId = statistics.getAssignmentId();
            double median = statistics.getMedian();
            double mean = statistics.getMean();
            double max = statistics.getMax();
            double min = statistics.getMin();
            double stdDev =statistics.getStdDev();

            // pre-process the execution
            String exec = String.format("INSERT INTO STATISTICS(assignmentId, median, mean, max, min, stdDev) VALUES('%d', '%f', '%f', '%f', '%f', '%f');",
                    assignmentId, median, mean, max, min, stdDev);
            pst = conn.prepareStatement(exec);

            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(Statistics statistics) {
        try {
            conn = AppConf.getConnection();

            int assignmentId = statistics.getAssignmentId();
            double median = statistics.getMedian();
            double mean = statistics.getMean();
            double max = statistics.getMax();
            double min = statistics.getMin();
            double stdDev =statistics.getStdDev();

            // pre-process the execution
            String exec = String.format("UPDATE STATISTICS(median, mean, max, min, stdDev) VALUES('%f', '%f', '%f', '%f', '%f') WHERE assignmentId = '%d';",
                    median, mean, max, min, stdDev, assignmentId);

            pst = conn.prepareStatement(exec);
            // execute and get the result set
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void deleteByAssignmentId(int assignmentId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM STATISTICS WHERE assignmentId = '%d';", assignmentId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pst != null){
                    pst.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


}

package test;

import CS591.GradeManageSystem.DAO.Impl.ModelRepositoryImpl;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Model;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ModelTest {

    private ModelRepositoryImpl modelRepository = new ModelRepositoryImpl();

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    private void initialize() {

        try {
            conn = AppConf.getConnection();

            String exec = "DELETE FROM MODEL;";

            pst = conn.prepareStatement(exec);

            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void save() {

        try {
            initialize();

            Model model = new Model(1, "test1", "name", 20, 100, true, true, false);
            modelRepository.save(model);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM MODEL WHERE modelId = %d;", model.getModelId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int userId = -1;
            String modelName = "";
            String columnName = "";
            int weight = -1;
            int maxPoint = -1;
            boolean addPoint = false;
            boolean extraBonus = false;
            boolean fix = true;
            while (rs.next()) {
                userId = rs.getInt(2);
                modelName = rs.getString(3);
                columnName = rs.getString(4);
                weight = rs.getInt(5);
                maxPoint = rs.getInt(6);
                addPoint = rs.getBoolean(7);
                extraBonus = rs.getBoolean(8);
                fix = rs.getBoolean(9);
            }

            Assert.assertEquals(1, userId);
            Assert.assertEquals("test1", modelName);
            Assert.assertEquals("name", columnName);
            Assert.assertEquals(20, weight);
            Assert.assertEquals(100, maxPoint);
            Assert.assertTrue(addPoint);
            Assert.assertTrue(extraBonus);
            Assert.assertFalse(fix);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void update() {

        try {
            initialize();

            Model model = new Model(1, "test2", "name", 20, 100, true, true, false);
            modelRepository.save(model);

            model.setUserId(2);
            model.setModelName("test2.1");
            model.setColumnName("name2");
            model.setWeight(30);
            model.setMaxPoint(90);
            model.setAddPoint(false);
            model.setExtraBonus(false);
            model.setFix(true);
            modelRepository.update(model);

            conn = AppConf.getConnection();
            String exec = String.format("SELECT * FROM MODEL WHERE modelId = %d;", model.getModelId());

            pst = conn.prepareStatement(exec);
            rs = pst.executeQuery();

            int userId = -1;
            String modelName= "";
            String columnName = "";
            int weight = -1;
            int maxPoint = -1;
            boolean addPoint = true;
            boolean extraBonus = true;
            boolean fix = false;
            while (rs.next()) {
                userId = rs.getInt(2);
                modelName = rs.getString(3);
                columnName = rs.getString(4);
                weight = rs.getInt(5);
                maxPoint = rs.getInt(6);
                addPoint = rs.getBoolean(7);
                extraBonus = rs.getBoolean(8);
                fix = rs.getBoolean(9);
            }

            Assert.assertEquals(2, userId);
            Assert.assertEquals("test2.1", modelName);
            Assert.assertEquals("name2", columnName);
            Assert.assertEquals(30, weight);
            Assert.assertEquals(90, maxPoint);
            Assert.assertFalse(addPoint);
            Assert.assertFalse(extraBonus);
            Assert.assertTrue(fix);

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByModelId() {
        try {
            initialize();

            Model model = new Model(1, "test3", "name", 20, 100, true, true, false);
            modelRepository.save(model);

            Model ret = modelRepository.findByModelId(model.getModelId());

            Assert.assertNotNull(ret);
            Assert.assertEquals(1, ret.getUserId());
            Assert.assertEquals("test3", ret.getModelName());
            Assert.assertEquals("name", ret.getColumnName());
            Assert.assertEquals(20, ret.getWeight());
            Assert.assertEquals(100, ret.getMaxPoint());
            Assert.assertTrue(model.isAddPoint());
            Assert.assertTrue(model.isExtraBonus());
            Assert.assertFalse(model.isFix());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUserIdAndModelName() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO MODEL(userId, modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix) VALUES(1, 'test4', 'name1', 20, 100, TRUE, TRUE, FALSE);";
            String exec2 = "INSERT INTO MODEL(userId, modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix) VALUES(2, 'test4', 'name2', 30, 90, FALSE, FALSE, TRUE);";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            List<Model> models = modelRepository.findByUserIdAndModelName(1, "test4");
            models.sort(Comparator.comparingInt(Model::getModelId));

            Assert.assertNotNull(models.get(0));
            Assert.assertEquals(1, models.size());
            Model model0 = models.get(0);
            Assert.assertEquals("test4", model0.getModelName());
            Assert.assertEquals("name1", model0.getColumnName());
            Assert.assertEquals(20, model0.getWeight());
            Assert.assertEquals(100, model0.getMaxPoint());
            Assert.assertTrue(model0.isAddPoint());
            Assert.assertTrue(model0.isExtraBonus());
            Assert.assertFalse(model0.isFix());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void findByUserId() {
        try {
            initialize();

            conn = AppConf.getConnection();
            String exec1 = "INSERT INTO MODEL(userId, modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix) VALUES(1, 'test5.1', 'name1', 20, 100, TRUE, TRUE, FALSE);";
            String exec2 = "INSERT INTO MODEL(userId, modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix) VALUES(1, 'test5.2', 'name2', 30, 90, FALSE, FALSE, TRUE);";
            String exec3 = "INSERT INTO MODEL(userId, modelName, columnName, weight, maxPoint, addPoint, extraBonus, fix) VALUES(2, 'test5.3', 'name3', 40, 80, FALSE, FALSE, TRUE);";

            pst = conn.prepareStatement(exec1);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec2);
            pst.executeUpdate();

            pst = conn.prepareStatement(exec3);
            pst.executeUpdate();

            List<Model> models = modelRepository.findByUserId(1);
            models.sort(Comparator.comparingInt(Model::getModelId));

            Assert.assertNotNull(models.get(0));
            Assert.assertEquals(2, models.size());
            Model model0 = models.get(0);
            Assert.assertEquals("test5.1", model0.getModelName());
            Assert.assertEquals("name1", model0.getColumnName());
            Assert.assertEquals(20, model0.getWeight());
            Assert.assertEquals(100, model0.getMaxPoint());
            Assert.assertTrue(model0.isAddPoint());
            Assert.assertTrue(model0.isExtraBonus());
            Assert.assertFalse(model0.isFix());

            Assert.assertNotNull(models.get(1));
            Model model1 = models.get(1);
            Assert.assertEquals("test5.2", model1.getModelName());
            Assert.assertEquals("name2", model1.getColumnName());
            Assert.assertEquals(30, model1.getWeight());
            Assert.assertEquals(90, model1.getMaxPoint());
            Assert.assertFalse(model1.isAddPoint());
            Assert.assertFalse(model1.isExtraBonus());
            Assert.assertTrue(model1.isFix());

            initialize();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void deleteByModelId() {
        try {
            initialize();

            Model model = new Model(1, "test6", "name", 20, 100, true, true, false);
            modelRepository.save(model);

            modelRepository.deleteByModelId(model.getModelId());

            Model ret = modelRepository.findByModelId(model.getModelId());

            Assert.assertNull(ret);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

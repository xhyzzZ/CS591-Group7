package CS591.GradeManageSystem.DAO.Impl;

import CS591.GradeManageSystem.DAO.ModelRepository;
import CS591.GradeManageSystem.config.AppConf;
import CS591.GradeManageSystem.entity.Model;
import CS591.GradeManageSystem.utils.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelRepositoryImpl implements ModelRepository {

    // the connection to sql server
    private static Connection conn = null;

    // PreparedStatement to execute sql code
    private static PreparedStatement pst = null;

    // the result set
    private static ResultSet rs = null;

    @Override
    public void save(Model model) {
        try {
            conn = AppConf.getConnection();

            String modelName = model.getModelName();
            String columnName = model.getColumnName();
            int weight = model.getWeight();
            boolean addPoint = model.isAddPoint();
            boolean extraBonus = model.isExtraBonus();
            boolean fix = model.isFix();

            // pre-process the execution
            String exec = String.format("INSERT INTO MODEL(modelName, columnName, weight, addPoint, extraBonus, fix) VALUES(\'%s\', \'%s\', %d, %b, %b, %b);",
                    modelName,
                    columnName,
                    weight,
                    addPoint,
                    extraBonus,
                    fix);
            pst = conn.prepareStatement(exec, Statement.RETURN_GENERATED_KEYS);
            int affectedRows = pst.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException(Constants.MODELFAILEDONROWS);
            }

            try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    model.setModelId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException(Constants.MODELFAILEDONID);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Model model) {
        try {
            conn = AppConf.getConnection();

            int modelId = model.getModelId();
            String modelName = model.getModelName();
            String columnName = model.getColumnName();
            int weight = model.getWeight();
            boolean addPoint = model.isAddPoint();
            boolean extraBonus = model.isExtraBonus();
            boolean fix = model.isFix();

            // pre-process the execution
            String exec = String.format("UPDATE MODEL SET modelName = \'%s\', columnName = \'%s\', weight = %d, addPoint = %b, extraBonus = %b, fix = %b WHERE modelId = %d;",
                    modelName,
                    columnName,
                    weight,
                    addPoint,
                    extraBonus,
                    fix,
                    modelId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Model> findAll() {
        List<Model> models = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = "SELECT * FROM MODEL";
            pst = conn.prepareStatement(exec);

            // execute the operation
            rs = pst.executeQuery();

            while (rs.next()) {
                Model model = new Model(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));
                models.add(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return models;
    }

    @Override
    public List<Model> findByModelName(String modelName) {
        List<Model> models = new ArrayList<>();

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM MODEL WHERE modelName = \'%s\';", modelName);
            pst = conn.prepareStatement(exec);

            // execute the operation
            rs = pst.executeQuery();

            while (rs.next()) {
                Model model = new Model(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));
                models.add(model);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return models;
    }

    @Override
    public Model findByModelId(int modelId) {
        Model model = null;

        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("SELECT * FROM MODEL WHERE modelId = %d;", modelId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            rs = pst.executeQuery();

            while (rs.next()) {
                model = new Model(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6),
                        rs.getBoolean(7));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return model;
    }

    @Override
    public void deleteByModelName(String modelName) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM MODEL WHERE modelName = \'%s\';", modelName);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteByModelId(int modelId) {
        try {
            conn = AppConf.getConnection();

            // pre-process the execution
            String exec = String.format("DELETE FROM MODEL WHERE modelId = %d;", modelId);
            pst = conn.prepareStatement(exec);

            // execute the operation
            pst.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

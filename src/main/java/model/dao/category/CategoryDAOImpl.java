package model.dao.category;

import model.entity.Category;
import utils.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        Connection c = null;
        List<Category> categories = new ArrayList<>();

        try {
            c = ConnectDB.opDB();
            c.setAutoCommit(false);
            CallableStatement statement = c.prepareCall("CALL SHOW_CATEGORY");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                categories.add(category);
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ConnectDB.clDB(c);
        }
        return categories;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public void remove(Integer integer) {

    }

    @Override
    public boolean update(Integer integer) {
        return false;
    }

    @Override
    public Category findById(Integer integer) {
        Connection c = null;
        Category category = null;
        try {
            c = ConnectDB.opDB();
            c.setAutoCommit(false);
            PreparedStatement ps = c.prepareStatement("SELECT * FROM category WHERE id = ?");
            ps.setInt(1, integer);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                category = new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description"));
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }finally {
            ConnectDB.clDB(c);
        }
        return category;
    }
}

package model.dao.product;

import model.dao.category.CategoryDAOImpl;
import model.dao.category.ICategoryDao;
import model.entity.Category;
import model.entity.Product;
import utils.ConnectDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IProductDAO{
    @Override
    public List<Product> findAll() {
        ICategoryDao categoryDAO = new CategoryDAOImpl();
        Connection c = null;
        List<Product> products = new ArrayList<>();
        try {
            c = ConnectDB.opDB();
            c.setAutoCommit(false);
            CallableStatement statement = c.prepareCall("CALL SHOW_PRODUCT");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                if (category == null){
                    throw new IllegalStateException("errr");
                }
                product.setCategory(category);
                product.setProductId(resultSet.getInt("id"));
                product.setQuantity(resultSet.getInt("quantity"));
                product.setProductName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
            }
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public boolean create() {
        return false;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public boolean update(Integer id) {
        return false;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}

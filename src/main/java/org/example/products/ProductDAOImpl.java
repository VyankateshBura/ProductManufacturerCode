package org.example.products;

import java.sql.*;
import java.util.*;

public class ProductDAOImpl implements ProductDAO{
    Connection connection;

    ProductDAOImpl(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rps@123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int add(Product product) {
        return 0;
    }

    @Override
    public List<Product> view() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select productId,productName,productPrice,m.manufacturer_id,manufacturer_name,manufacturer_country from products p inner join manufacturers  m on m.manufacturer_id = p.manufacturer_id");
            List<Product> products = new ArrayList<>();
            Map<String,Manufacturer> manufacturerPerId = new HashMap<>();
            while(rs.next()){
                Product p;
                if(manufacturerPerId.containsKey(rs.getString(4))){
                    p = new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),Float.parseFloat(rs.getString(3)),manufacturerPerId.get(rs.getString(4)));
                    products.add(p);
                }
                else{
                    manufacturerPerId.putIfAbsent(rs.getString(4),new Manufacturer(Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6),new ArrayList<>()));
                    p = new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),Float.parseFloat(rs.getString(3)),manufacturerPerId.get(rs.getString(4)));
                    products.add(p);

                }
                manufacturerPerId.get(rs.getString(4)).getProducts().add(p);

            }
            return products;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public int delete(int productId) {
        return 0;
    }

    @Override
    public int update(Product product) {
        return 0;
    }
}

package org.example.products;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class ManufacturerDAOImpl implements  ManufacturerDAO{
    Connection connection;

    ManufacturerDAOImpl(){
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
    public int add(Manufacturer manufacturer) {
        return 0;
    }

    @Override
    public List<Manufacturer> view() {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select productId,productName,productPrice,m.manufacturer_id,manufacturer_name,manufacturer_country from products p inner join manufacturers  m on m.manufacturer_id = p.manufacturer_id");
            List<Manufacturer> manufacturers = new ArrayList<>();
            Map<String,List<Product>> productsPerManufactId = new HashMap<>();
            while(rs.next()){
                if(!productsPerManufactId.containsKey(rs.getString(4))){
                    productsPerManufactId.put(rs.getString(4),new ArrayList<>());
                }
                Manufacturer manufacturer = new Manufacturer(Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6),new ArrayList<>());
                Product p = new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),Float.parseFloat(rs.getString(3)),manufacturer);
                productsPerManufactId.get(rs.getString(4)).add(p);
                manufacturers.add(manufacturer);

            }
            return manufacturers.stream().map(manufacturer -> {
                manufacturer.setProducts(productsPerManufactId.get(String.valueOf(manufacturer.getManufacturerId())));
                return manufacturer;
            }).collect(Collectors.toList());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    @Override
    public int delete(int manufacturerId) {
        return 0;
    }

    @Override
    public int update(Manufacturer manufacturer) {
        return 0;
    }
}

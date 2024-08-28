package org.example.products;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestSQLJoin {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","rps@123");

//        Statement statement = connection.createStatement();
//
//        ResultSet rs = statement.executeQuery("select productId,productName,productPrice,m.manufacturer_id,manufacturer_name,manufacturer_country from products p inner join manufacturers  m on m.manufacturer_id = p.manufacturer_id");
//        List<Product> products = new ArrayList<>();
//        while(rs.next()){
//            System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
//            products.add(new Product(Integer.parseInt(rs.getString(1)),rs.getString(2),Float.parseFloat(rs.getString(3)),new Manufacturer(Integer.parseInt(rs.getString(4)),rs.getString(5),rs.getString(6),null)));
//        }

        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        List<Product> products = productDAOImpl.view();
        List<ProductManufacturer> productManufacturers = products.stream().map(ProductManufacturer::new).collect(Collectors.toUnmodifiableList());
        System.out.println(productManufacturers);

        ManufacturerDAOImpl manufacturerDAOImpl = new ManufacturerDAOImpl();
        List<Manufacturer> manufacturers = manufacturerDAOImpl.view();
        List<ManufacturerProduct> manufacturerProducts = manufacturers.stream().map(ManufacturerProduct::new).collect(Collectors.toUnmodifiableList());
        System.out.println(manufacturerProducts);

    }
}

package org.example.products;


import java.util.List;

public interface ProductDAO {
    int add(Product product);
    List<Product> view();
    int delete(int productId);
    int update(Product product);
}

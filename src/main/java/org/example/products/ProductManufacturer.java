package org.example.products;

public class ProductManufacturer {
    Product product;

    public ProductManufacturer(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductManufacturer{" +
                "productId = " + product.getId() +
                ", productName = "+product.getName()+
                ", productPrice = "+product.getPrice()+
                ", manufacturerId = "+product.getManufacturer().getManufacturerId()+
                ", manufacturerName= "+product.getManufacturer().getManufacturerName()+
                ", manufacturerCountry = "+product.getManufacturer().getManufacturerCountry()+
                '}';
    }
}

package org.example.products;

public class ManufacturerProduct {
    Manufacturer manufacturer;

    public ManufacturerProduct(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        String productsToString = "";
        for(Product product :manufacturer.getProducts()){
            productsToString = productsToString+ " ( productId = " + product.getId() +
                    ", productName = "+product.getName()+
                    ", productPrice = "+product.getPrice()+" ),";
        }
        return "ManufacturerProduct{" +
                ", manufacturerId = "+manufacturer.getManufacturerId()+
                ", manufacturerName= "+manufacturer.getManufacturerName()+
                ", manufacturerCountry = "+manufacturer.getManufacturerCountry()+
                ", products = "+productsToString+
                '}';
    }
}

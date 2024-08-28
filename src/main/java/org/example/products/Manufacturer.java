package org.example.products;

import java.util.List;

public class Manufacturer implements Cloneable{
    private int manufacturerId;
    private String manufacturerName;
    private String manufacturerCountry;
    private List<Product> products;

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturerId) {
        this.manufacturerId = manufacturerId;
    }


//    @Override
//    public String toString() {
//        StringBuilder productsInfo = new StringBuilder();
//        for(Product p:this.products){
//            productsInfo.append(" ").append(p.getId()).append(" ").append(p.getName()).append(" ").append(p.getPrice()).append(" hashcode ").append(p.hashCode());
//        };
//        return "products.Manufacturer{" +
//                "manufacturerName='" + manufacturerName + '\'' +
//                ", manufacturerCountry='" + manufacturerCountry + '\'' +
//                ", products=" +productsInfo  +
//                '}';
//    }


    @Override
    public String toString() {
        return "Manufacturer{" +
                "manufacturerId=" + manufacturerId +
                ", manufacturerName='" + manufacturerName + '\'' +
                ", manufacturerCountry='" + manufacturerCountry + '\'' +
                ", products=" + products +
                '}';
    }

    public Manufacturer(int manufacturerId, String manufacturerName, String manufacturerCountry, List<Product> products) {
        this.manufacturerName = manufacturerName;
        this.manufacturerCountry = manufacturerCountry;
        this.products = products;
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerCountry() {
        return manufacturerCountry;
    }

    public void setManufacturerCountry(String manufacturerCountry) {
        this.manufacturerCountry = manufacturerCountry;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public Manufacturer clone() throws CloneNotSupportedException {
        //Deep copy
//        products.Manufacturer manufacturer = (products.Manufacturer) super.clone();
//        List<products.Product> products = manufacturer.getProducts();
//        List<products.Product> cloneProducts = new ArrayList<>();
//        for(products.Product p:products){
//            cloneProducts.add(p.clone());
//        };
//        manufacturer.setProducts(cloneProducts);

//        return manufacturer;

        //Shallow Copy
        return (Manufacturer) super.clone();
    }
}

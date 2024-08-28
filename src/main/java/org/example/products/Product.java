package org.example.products;

import java.util.ArrayList;

public class Product implements Cloneable {

    private int id;
    private String name;
    private double price;
    private Manufacturer manufacturer;
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }


    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", manufacturer=" + manufacturer +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    @Override
//    public String toString() {
//        String manufacturerInfo = manufacturer.getManufacturerName()+" "+manufacturer.getManufacturerCountry()+" hashcode = "+manufacturer.hashCode();
//        return "products.Product{ product hashcode "+this.hashCode() +
//                " id=" + id +
//                ", name='" + name + '\'' +
//                ", price=" + price +
//                ",manufacturer = "+manufacturerInfo+
//                '}';
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Integer id, String name, double price,Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturer = manufacturer;
    }

//    @Override
//    public int compareTo(products.Product product) {
//        return this.id - product.id ;
//    }


    @Override
    protected Product clone() throws CloneNotSupportedException {

        //Deep copy
        Product product = (Product) super.clone();
        product.setManufacturer(new Manufacturer(this.manufacturer.getManufacturerId(),this.manufacturer.getManufacturerName(),this.manufacturer.getManufacturerCountry(),new ArrayList<>(this.manufacturer.getProducts())));
        return product;

        //Shallow Copy
//        return (products.Product) super.clone();
    }
}

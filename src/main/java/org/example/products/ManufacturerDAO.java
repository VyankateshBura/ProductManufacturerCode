package org.example.products;

import java.util.List;

public interface ManufacturerDAO {
    int add(Manufacturer manufacturer);
    List<Manufacturer> view();
    int delete(int manufacturerId);
    int update(Manufacturer manufacturer);
}

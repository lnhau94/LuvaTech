package Logic;

import DAL.ProductDAO;
import Entity.Brand;

import java.util.ArrayList;

public class BrandManagement {
    ArrayList<Brand> brandList;
    public BrandManagement() {
        brandList = ProductDAO.getBrands();
    }

    public ArrayList<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(ArrayList<Brand> brandList) {
        this.brandList = brandList;
    }

    public void addNewBrand(Brand brand) {
        brandList.add(brand);
    }
}

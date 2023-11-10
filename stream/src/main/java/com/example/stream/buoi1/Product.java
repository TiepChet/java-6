package com.example.stream.buoi1;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String tenSanPham;
    private float giaBan;

    public Product() {
    }

    public Product(String tenSanPham, float giaBan) {
        this.tenSanPham = tenSanPham;
        this.giaBan = giaBan;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Product{" +
                "tenSanPham='" + tenSanPham + '\'' +
                ", giaBan=" + giaBan +
                '}';
    }

    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product("a",1));
        list.add(new Product("b",2));
        list.add(new Product("c",3));
        list.add(new Product("d",4));

        //•	Lọc ra các sản phẩm có giá bán từ 100.000 đồng tới 500.000 đồng.
        list.stream().filter(o-> o.getGiaBan() >=2 && o.getGiaBan()<=4).forEach(System.out::println);

        //•	Tính tổng giá bán của tất cả các sản phẩm
        float tong = list.stream().map(Product::getGiaBan).reduce(0f,Float::sum);
        float tongx = list.stream().map(o->o.getGiaBan()).reduce(0f,Float::sum);

        System.out.println("Tổng: "+tong);

        //	Tìm sản phẩm có giá bán cao nhất.
        Product product = list.stream().max((o1, o2) -> o1.getGiaBan()> o2.getGiaBan() ? 1:-1).get();
        Product products= list.stream().min((o1, o2) -> o1.getGiaBan()> o2.getGiaBan() ? 1:-1).get();
        System.out.println("Sản phẩn lớn nhất: "+product);
        System.out.println("Sản phẩn nhỏ nhất: "+products);
    }

}

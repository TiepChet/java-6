package com.example.stream.buoi1;

import com.example.stream.StreamApplication;
import org.springframework.boot.SpringApplication;

import java.util.ArrayList;
import java.util.List;

public class SinhVien {

    private String ten;
    private float diemSo;

    public SinhVien() {
    }

    public SinhVien(String ten, float diemSo) {
        this.ten = ten;
        this.diemSo = diemSo;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getDiemSo() {
        return diemSo;
    }

    public void setDiemSo(float diemSo) {
        this.diemSo = diemSo;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ten='" + ten + '\'' +
                ", diemSo=" + diemSo +
                '}';
    }

    public static void main(String[] args) {
        List<SinhVien> list = new ArrayList<>();
        list.add(new SinhVien("a",1));
        list.add(new SinhVien("b",2));
        list.add(new SinhVien("c",3));
        list.add(new SinhVien("d",4));

        //•	Lọc ra các học sinh có điểm số lớn hơn hoặc bằng 8.
        list.stream().filter(o-> o.getDiemSo() >=3).forEach(System.out::println);

        //•	Tính điểm trung bình của tất cả các học sinh.
        float diemTB = list.stream().map(SinhVien::getDiemSo).reduce(0f, Float::sum) / list.size();
        System.out.println("điểm tb: "+diemTB);

        //•	Tìm học sinh có điểm số cao nhất.
        SinhVien diemCaoNhat = list.stream().max((o1, o2) -> o1.getDiemSo()>o2.getDiemSo() ? 1 :-1).get();
        System.out.println("Điểm cao: "+diemCaoNhat);

        list.sort((o1, o2) ->  (int) (o2.getDiemSo() - o1.getDiemSo()));
        System.out.println(list);
    }

}

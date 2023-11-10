package com.example.demo.service;

import com.example.demo.entity.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SinhVienService {

    List<SinhVien> list = new ArrayList<>();

    public List<SinhVien> getAll() {
        list.add(new SinhVien("a", 19, 5));
        list.add(new SinhVien("b", 23, 10));
        list.add(new SinhVien("c", 18, 6));
        list.add(new SinhVien("a", 20, 7));
        return list;
    }


    //•	Tìm sinh viên có điểm số cao nhất trong môn Toán
    public Optional<SinhVien> diemCao(){
        return list.stream().max(Comparator.comparing(SinhVien::getDiem));
    }

    //•	Tính điểm trung bình của môn Hóa học.

    public double dtb() {
        return list.stream().mapToDouble(SinhVien::getDiem).average().orElse(0.0);
    }

    // Lọc tuoi `10-20
    public  List<SinhVien> loc(){
       return list.stream().filter(o->o.getTuoi() >=10 && o.getTuoi() <=20).collect(Collectors.toList());
    }

    // tổng bình phương
    public double tongBP(){
       return list.stream().filter(o->o.getDiem() %2==0)
                .mapToDouble(list -> Math.pow(list.getDiem(), 2))
                .sum();
    }

    //sap xep diem giam
    public List<SinhVien> sapXep(){
          list.sort(Comparator.comparing(SinhVien::getDiem,Comparator.reverseOrder()));
       return list;
    }

    //diem duoi 5
    public List<SinhVien> diem5(){
     return     list.stream().filter(o->o.getDiem() >= 7).collect(Collectors.toList());

    }


}

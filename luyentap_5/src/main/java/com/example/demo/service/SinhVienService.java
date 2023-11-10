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

    private List<SinhVien> list = new ArrayList<>();

    public List<SinhVien> getAll(){
        list.add(new SinhVien("a",15,1));
        list.add(new SinhVien("a",17,2));
        list.add(new SinhVien("a",19,3));
        list.add(new SinhVien("a",13,5));
        return list;
    }

    //•	Tìm sinh viên có điểm số cao nhất trong môn Toán.
    public Optional<SinhVien> diemCao(){
        return list.stream().max(Comparator.comparing(SinhVien::getDiem));
    }

    //•	Tính điểm trung bình của môn Hóa học.\
    public double diemTB(){
        return list.stream().mapToDouble(SinhVien::getDiem).average().orElse(0.0);
    }

    //•	Lọc ra các sinh viên có tuổi từ 18 đến 22.
    public List<SinhVien> tuoiSV(){
        return list.stream().filter(o->o.getTuoi()>=15 && o.getTuoi()<=19).collect(Collectors.toList());
    }

    //•	Sắp xếp danh sách sinh viên theo thứ tự giảm dần của tổng điểm các môn học.
    public List<SinhVien> sapXep(){
         list.sort(Comparator.comparing(SinhVien::getTuoi,Comparator.reverseOrder()));
         return list;
    }

    //•	Kiểm tra xem liệu có sinh viên nào có điểm số dưới 5.0 không.
    public List<SinhVien> diem5(){
        return list.stream().filter(o->o.getDiem()<5).collect(Collectors.toList());
    }

    //•	Tính điểm trung bình cong của môn Hóa học.
    public double tbc(){
        return list.stream().mapToDouble(sinhVien->Math.pow(sinhVien.getDiem(),2)).sum();
    }
}

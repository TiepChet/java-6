package com.example.stream.buoi2.service;

import com.example.stream.buoi2.entity.SinhVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class SinhVienService {

    List<SinhVien> list = new ArrayList<>();

    public List<SinhVien> getAll() {
        list.add(new SinhVien("a", 17, 10));
        list.add(new SinhVien("a", 14, 8));
        list.add(new SinhVien("a", 15, 9));
        list.add(new SinhVien("a", 19, 7));
        list.add(new SinhVien("a", 13, 4));
        return list;
    }

    //•	Tìm sinh viên có điểm số cao nhất trong môn Toán.
    public Optional<SinhVien> dienCao(){
        return list.stream().max(Comparator.comparing(SinhVien::getDiem));
    }

    //•	Tính điểm trung bình của môn Hóa học.
    public double diemTB(){
        return list.stream().mapToDouble(SinhVien::getDiem).average().orElse(0.0);
    }

    //•	Lọc ra các sinh viên có tuổi từ 18 đến 22.
    public List<SinhVien> locSV(){
        return list.stream().filter(o->o.getTuoi() >=17 && o.getTuoi()<=22).collect(Collectors.toList());
    }

    //•	Sắp xếp danh sách sinh viên theo thứ tự giảm dần của tổng điểm các môn học.
    public List<SinhVien> sapXep(){
        list.sort(Comparator.comparing(SinhVien::getDiem, Comparator.reverseOrder()));
        return list;
    }

    //•	Kiểm tra xem liệu có sinh viên nào có điểm số dưới 5.0 không.
    public List<SinhVien> diem5(){
        return list.stream().filter(o->o.getDiem()<=5).collect(Collectors.toList());
    }
}

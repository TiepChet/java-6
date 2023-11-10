package com.example.demo.service;

import com.example.demo.entity.NhanVien;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhanVienService {

    private List<NhanVien> list = new ArrayList<>();

    public List<NhanVien> getAll(){
        list.add(new NhanVien("a",15,1));
        list.add(new NhanVien("b",14,2));
        list.add(new NhanVien("c",18,4));
        list.add(new NhanVien("d",20,3));
        return list;
    }

    //•	Lọc ra các nhân viên có tuổi từ 25 đến 35 và mức lương trên 10 triệu đồng.
    public List<NhanVien> locNhanVien(){
        return list.stream().filter(o->o.getTuoi()>=18 && o.getTuoi()<=22 && o.getLuong()>3).collect(Collectors.toList());
    }

    //•	Tính tổng lương của tất cả các nhân viên.
    public double tongLuong(){
        return list.stream().mapToDouble(NhanVien::getLuong).sum();
    }

    //•	Tìm nhân viên có mức lương cao nhất.
    public Optional<NhanVien> luongCao(){
        return list.stream().max(Comparator.comparing(NhanVien::getLuong));
    }

    //•	Sắp xếp danh sách nhân viên theo mức lương giảm dần.
    public List<NhanVien> sapXep(){
        list.sort(Comparator.comparing(NhanVien::getLuong,Comparator.reverseOrder()));
        return list;
    }

    //•	Kiểm tra xem liệu có nhân viên nào có tuổi trên 40 không.
    public List<NhanVien> tuoi(){
        return list.stream().filter(o->o.getTuoi()>=18).collect(Collectors.toList());
    }

    //Tinh trung binh cong
    public double tbc(){
        return list.stream().mapToDouble(NhanVien::getLuong).average().orElse(0.0);
    }

    //Tính tổng bình phương
    public double tongBP(){
       return  list.stream().mapToDouble(nhanVien->Math.pow(nhanVien.getLuong(),2)).sum();
    }

}

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

    List<NhanVien> list = new ArrayList<>();

    public List<NhanVien> getAll() {
        list.add(new NhanVien("a", 10, 70));
        list.add(new NhanVien("b", 9, 10));
        list.add(new NhanVien("c", 18, 30));
        list.add(new NhanVien("a", 20, 40));
        return list;
    }

    public List<NhanVien> loc() {
        return list.stream().filter(o -> o.getTuoi() >= 10 && o.getTuoi() <= 20 && o.getLuong() > 20).collect(Collectors.toList());
    }

    public Optional<NhanVien> luongCao() {
        return list.stream().max(Comparator.comparing(NhanVien::getLuong));
    }

    //natural -> tăng
    //reverse -> giảm
    public List<NhanVien> sort() {
        list.sort(Comparator.comparing(NhanVien::getLuong, Comparator.reverseOrder()));
        return list;
    }

    public List<NhanVien> tuoi() {
       return   list.stream().filter(o -> o.getTuoi() >= 18).collect(Collectors.toList());

    }

    public double tongLuong() {
         return list.stream().mapToDouble(NhanVien::getLuong).sum();
    }
}

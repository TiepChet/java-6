package com.demo.service;

import com.demo.model.HoaDon;
import com.demo.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    HoaDonRepo hoaDonRepo;

    public List<HoaDon> getAll(){
        return hoaDonRepo.findAll();
    }

    public HoaDon findByID(long maHoaDon){
        return hoaDonRepo.findById(maHoaDon).get();
    }
}

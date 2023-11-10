package com.demo.controller;

import com.demo.entity.HangKhachHang;
import com.demo.service.HangKhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HangKhachHangController {

    @Autowired
    HangKhachHangService hangKhachHangService;

    @GetMapping("/hien-thi")
    public String hienThi(Model model) {
        List<HangKhachHang> hkh = hangKhachHangService.getAll();
        model.addAttribute("listHKH", hkh);
        model.addAttribute("hangKhachHang",new HangKhachHang());
        return "index";
    }


    @GetMapping("/detail/{maHang}")
    public String detail(Model model, @PathVariable("maHang") int maHang) {
        HangKhachHang hangKhachHang = hangKhachHangService.getOne(maHang);
        List<HangKhachHang> hkh = hangKhachHangService.getAll();
        model.addAttribute("listHKH", hkh);
        model.addAttribute("hangKhachHang",new HangKhachHang());
        model.addAttribute("hangKhachHang",hangKhachHang);
        return "index";
    }

    @GetMapping("/delete/{maHang}")
    public String delete(Model model, @PathVariable("maHang") int maHang) {
        hangKhachHangService.delete(maHang);
        List<HangKhachHang> hkh = hangKhachHangService.getAll();
        model.addAttribute("listHKH", hkh);
        model.addAttribute("hangKhachHang",new HangKhachHang());
        return "index";
    }


    @PostMapping("/add")
    public String hienThi(HangKhachHang hangKhachHang,Model model) {
        hangKhachHangService.save(hangKhachHang);
        List<HangKhachHang> hkh = hangKhachHangService.getAll();
        model.addAttribute("listHKH", hkh);
        model.addAttribute("hangKhachHang",new HangKhachHang());
        return "index";
    }


    @GetMapping("/view-update/{maHang}")
    public String viewUpdate(Model model, @PathVariable("maHang") int maHang) {
        HangKhachHang hangKhachHang = hangKhachHangService.getOne(maHang);
        List<HangKhachHang> hkh = hangKhachHangService.getAll();
        model.addAttribute("listHKH", hkh);
        model.addAttribute("hangKhachHang",new HangKhachHang());
        model.addAttribute("hangKhachHang",hangKhachHang);
        return "update";
    }

    @PostMapping("/update/{maHang}")
    public String update(HangKhachHang hangKhachHang,Model model) {
        hangKhachHangService.save(hangKhachHang);
        List<HangKhachHang> hkh = hangKhachHangService.getAll();
        model.addAttribute("listHKH", hkh);
        model.addAttribute("hangKhachHang",new HangKhachHang());
        return "index";
    }
}

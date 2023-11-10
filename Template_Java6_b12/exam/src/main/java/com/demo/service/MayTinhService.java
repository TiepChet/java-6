package com.demo.service;

import com.demo.model.MayTinh;
import com.demo.repository.MayTinhRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MayTinhService {

    @Autowired
    private MayTinhRepo mayTinhRepo;

    public List<MayTinh> getAll() {
        return mayTinhRepo.findAll();
    }

    public Page<MayTinh> findAll(Pageable pageable) {
        return mayTinhRepo.findAll(pageable);
    }

//    public MayTinh getOne(UUID ma) {
//        Optional<MayTinh> getOne = mayTinhRepo.findById(ma);
//        return getOne.isPresent() ? getOne.get() : null;
//    }

    public MayTinh update(UUID ma, MayTinh mayTinh) {
        Optional<MayTinh> update = mayTinhRepo.findById(ma);
        return update.map(o -> {
            o.setTen(mayTinh.getTen());
            o.setBoNho(mayTinh.getBoNho());
            o.setGia(mayTinh.getGia());
            return mayTinhRepo.save(o);
        }).orElse(null);
    }

    public MayTinh delete(UUID ma) {
        Optional<MayTinh> delete = mayTinhRepo.findById(ma);
        return delete.map(o -> {
            mayTinhRepo.delete(o);
            return o;
        }).orElse(null);
    }

    public MayTinh edit(UUID ma, MayTinh mayTinh) {
        MayTinh update = mayTinhRepo.findById(ma).get();
        update.setTen(mayTinh.getTen());
        update.setGia(mayTinh.getGia());
        update.setBoNho(mayTinh.getBoNho());
        return mayTinhRepo.save(update);
    }
}


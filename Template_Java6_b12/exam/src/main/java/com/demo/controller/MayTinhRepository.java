package com.demo.controller;

import com.demo.model.MayTinh;
import com.demo.service.MayTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/maytinh")
public class MayTinhRepository {

    @Autowired
    private MayTinhService mayTinhService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        List<MayTinh> getAll = mayTinhService.getAll();
        return ResponseEntity.ok(getAll);
    }

    @GetMapping("/index")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, 2);
        Page<MayTinh> findAll = mayTinhService.findAll(pageable);
        return ResponseEntity.ok(findAll);
    }

//    @GetMapping("/detail/{ma}")
//    public ResponseEntity<?> detail(@PathVariable("ma") UUID ma) {
//        MayTinh detail = mayTinhService.getOne(ma);
//        return ResponseEntity.ok(detail);
//    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@Valid @PathVariable("ma") UUID ma, @RequestBody MayTinh mayTinh) {
        MayTinh update = mayTinhService.edit(ma, mayTinh);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable("ma") UUID ma) {
        MayTinh delete = mayTinhService.delete(ma);
        return ResponseEntity.ok(delete);
    }

    @PutMapping("/edit/{ma}")
    public ResponseEntity<?> edit(@Valid @PathVariable("ma") UUID ma, @RequestBody MayTinh mayTinh) {
        MayTinh edit= mayTinhService.edit(ma, mayTinh);
        return ResponseEntity.ok(edit);
    }
}

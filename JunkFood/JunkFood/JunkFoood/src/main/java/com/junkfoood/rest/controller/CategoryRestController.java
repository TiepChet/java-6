package com.junkfoood.rest.controller;

import com.junkfoood.model.dto.CategoryDto;
import com.junkfoood.model.entity.CategoryEntity;
import com.junkfoood.model.response.Pagination;
import com.junkfoood.model.response.SamplePagingResponse;
import com.junkfoood.model.response.SampleResponse;
import com.junkfoood.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5501/"})
@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<SamplePagingResponse> getAll
            (
                    @RequestParam(value = "page") int page,
                    @RequestParam(value = "page_size") int page_size
            ) {
        Page<CategoryDto> categoryDtos = categoryService.getAllAndPage(page, page_size);
        return ResponseEntity.ok(SamplePagingResponse.builder().success(true).message("Get all category Success")
                .data(categoryDtos.getContent()).pagination(Pagination.builder().page(page)
                        .pageSize(page_size).totalPage(categoryDtos.getTotalPages())
                        .totalItem(categoryDtos.getTotalElements()).build()).build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<SampleResponse> getOne(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Get one success")
                .data(categoryService.getOne(id)).build());
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('STAF')")
    public ResponseEntity<SampleResponse> create(@Validated @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Create Successs")
                .data(categoryService.create(categoryDto)).build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<SampleResponse> update(@Validated @PathVariable("id") Integer id, @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Update Success")
                .data(categoryService.update(id, categoryDto)).build());
    }


    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAuthority('STAF')")
    public ResponseEntity<SampleResponse> delete(@PathVariable("id") Integer id) {
        categoryService.delete(id);
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Delete Success")
                .data(null).build());
    }


}

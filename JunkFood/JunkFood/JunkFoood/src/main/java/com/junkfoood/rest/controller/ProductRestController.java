package com.junkfoood.rest.controller;

import com.junkfoood.model.dto.ProductDto;
import com.junkfoood.model.entity.ProductEntity;
import com.junkfoood.model.response.Pagination;
import com.junkfoood.model.response.SamplePagingResponse;
import com.junkfoood.model.response.SampleResponse;
import com.junkfoood.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://127.0.0.1:5501/"})
@RestController
@RequestMapping("/api/product")
public class ProductRestController {

    @Autowired
    private ProductService productService;


    @GetMapping()
    public ResponseEntity<SamplePagingResponse> getAllAndPage
            (
                    @RequestParam(value = "page", required = false) Integer page ,
                    @RequestParam(value = "page_size" , required = false) Integer page_size
            )
    {
        Page<ProductDto> productDtos = productService.getAllAndPage(page,page_size);

        System.out.println(productDtos.getContent()+"cvbnm,.");
        return ResponseEntity.ok(SamplePagingResponse.builder()
                .success(true).message("Get all product success").data(productDtos.getContent()).
                pagination(Pagination.builder().page(page).pageSize(page_size)
                        .totalPage(productDtos.getTotalPages())
                        .totalItem(productDtos.getTotalElements())
                        .build()).build());
    }

    @GetMapping("/get-all")
    public ResponseEntity<SampleResponse> getAll()
    {
        return ResponseEntity.ok(SampleResponse.builder()
                .success(true).message("Get all product success").data(productService.getAll()).build());
    }


    @GetMapping("/get-proid")
    public ResponseEntity<SampleResponse> getAlla(@RequestParam("cid")Optional<Integer> id) {
        List<ProductDto> productDtoList = null;
        if (id.isPresent()) {
            productDtoList = productService.getProductCateId(id.get());
        }
        return ResponseEntity.ok(SampleResponse.builder()
                .success(true).message("Get all product success").data(productDtoList).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleResponse> getOne(@PathVariable("id") Integer id){
        return ResponseEntity.ok(SampleResponse.builder().success(true)
                .message("Get one success").data(productService.getOne(id)).build());
    }


    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SampleResponse> create(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(SampleResponse.builder().success(true)
                .message("Create success").data(productService.create(productDto)).build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<SampleResponse> update(@PathVariable("id") Integer id, @RequestBody ProductDto productDto){
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Update success")
                .data(productService.update(id,productDto)).build());
    }

    @DeleteMapping({"/{id}"})
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SampleResponse> delete(@PathVariable("id") Integer id){
        productService.delete(id);
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Delete success")
                .data(null).build());
    }




}

package com.junkfoood.rest.controller;

import com.junkfoood.model.dto.AuthorityDto;
import com.junkfoood.model.response.SampleResponse;
import com.junkfoood.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/authority")
public class AuthorityRestController {

    @Autowired
    private AuthorityService authorityService;


    @GetMapping
    public ResponseEntity<SampleResponse> getAll(){
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Get authority success")
                .data(authorityService.getAll()).build());
    }

    @PostMapping
//    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<SampleResponse> create(@RequestBody AuthorityDto authorityDto){
        return ResponseEntity.ok(SampleResponse.builder().success(true).message("Create succsee")
                .data(authorityService.create(authorityDto)).build());
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<SampleResponse> delete(@PathVariable("id") Integer id){
        authorityService.delete(id);
        return ResponseEntity.ok(SampleResponse.builder().data(true).message("Delete succsee")
                .data(null).build());
    }


}

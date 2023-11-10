package com.junkfoood.rest.controller;

import com.junkfoood.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = {"http://127.0.0.1:5501/"})
@RestController
public class FileManagerRestController {

    @Autowired
    FileManagerService fileManagerService;

    @GetMapping("/rest/files/{folder}/{file}")
    public byte[] dowload(@PathVariable("folder") String folder, @PathVariable("file") String file){
        return fileManagerService.read(folder,file);
    }

    @PostMapping("/rest/files/{folder}")
    public List<String> upload(@PathVariable("folder") String folder, @PathVariable("files") MultipartFile[] files){
        return fileManagerService.save(folder,files);
    }

    @DeleteMapping("/rest/files/{folder}/{file}")
    public void delete(@PathVariable("folder") String folder, @PathVariable("file") String file){
         fileManagerService.delete(folder,file);
    }

    @GetMapping("/rest/files/{folder}")
    public List<String> list(@PathVariable("folder") String folder){
        return fileManagerService.list(folder);
    }



}

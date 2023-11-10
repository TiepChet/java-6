package com.junkfoood.service.impl;

import com.junkfoood.service.FileManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileManagerServiceImpl implements FileManagerService {
    @Autowired
    ServletContext app;

    @Override
    public Path getPath(String folder, String filename){
        File dir = Paths.get(app.getRealPath("/files/"),folder).toFile();
        if(!dir.exists()){
            dir.mkdirs();
        }
        return Paths.get(dir.getAbsolutePath(),filename);
    }

    @Override
    public byte[] read(String folder, String filename){
        Path path = this.getPath(folder,filename);
        try {
            // đưa path vào trong magnr byte
            return Files.readAllBytes(path);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> save(String folder, MultipartFile[] files){

        List<String> filenames = new ArrayList<String>();
        // file.getOriginalFilename() tên file gốc từ client
        // System.currentTimeMillis() thời gian hiện tại của server
        for (MultipartFile file: files){
            String name = System.currentTimeMillis() + file.getOriginalFilename();
            // đổi tên ngắn gọn
            String filename = Integer.toHexString(name.hashCode()) + name.substring(name.lastIndexOf("."));
            Path path = this.getPath(folder,filename); // lấy dường dẫn chỉ tới file đó
            try {
                file.transferTo(path);// lưu file upload vào trong path
                filenames.add(filename);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return filenames;
    }

    @Override
    public void delete(String folder, String filename){
        Path path = this.getPath(folder,filename);
        path.toFile().delete();
    }

    @Override
    public List<String> list(String folder){
        List<String> filenames = new ArrayList<String>();

        // tạo ra đường dẫn chỉ folder
        File dir = Paths.get(app.getRealPath("/files/"),folder).toFile();
        if(dir.exists()){// nếu tồn tại
            File[] files = dir.listFiles();// lấy ra file trong thư mục đó
            for (File file: files) {// duyệt qua từng file 1
                filenames.add(file.getName());// lấy tên bỏ vào trong list
            }
        }
        return filenames;
    }

}

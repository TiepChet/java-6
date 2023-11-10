package com.example.demo;

import com.example.demo.model.SinhVien;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
//
//        List<Integer> list = Arrays.asList(1,2,3,4,5,7,8,9);
//        list.forEach(n-> System.out.println(n));
//
//        List<SinhVien> listSV = Arrays.asList(
//                new SinhVien("Nguyễn Văn A",true,5),
//                new SinhVien("Nguyễn Văn D",false,6),
//                new SinhVien("Nguyễn Văn C",true,7),
//                new SinhVien("Nguyễn Văn B",false,8));
//        Collections.sort(listSV,((o1, o2) -> o1.getTenSV().compareTo(o2.getTenSV())));
//        Collections.sort(listSV,(o1, o2) -> (int) (o1.getMarks()- o2.getMarks()));
////        listSV.forEach(sinhVien-> System.out.println(sinhVien.getTenSV()));
//        listSV.forEach(sinhVien-> System.out.println(sinhVien));


//        List<Integer> listNumber = Arrays.asList(1,2,3,5,6,7,8,9);
//        List<Double> number = listNumber.stream()
//                .filter(n ->n % 2==0)
//                .map(n->Math.sqrt(n))
//                .peek(d-> System.out.println(d))
//                .collect(Collectors.toList());
//        number.forEach(n-> System.out.println(n));
//
//        List<SinhVien> listSV = Arrays.asList(
//                new SinhVien("Nguyễn Văn A", true, 5),
//                new SinhVien("Nguyễn Văn D", false, 6),
//                new SinhVien("Nguyễn Văn C", true, 7),
//                new SinhVien("Nguyễn Văn B", false, 8));
//        List<SinhVien> result = listSV.stream()
//                .filter(sinhVien -> sinhVien.getMarks() > 6)
//                .collect(Collectors.toList());
//        result.forEach(n -> System.out.println(n));
//
//        double sum = listSV.stream()
//                .mapToDouble(sinhVien -> sinhVien.getMarks())
//                .sum();
//        System.out.println("sum: "+sum);
//
//        double min = listSV.stream()
//                .mapToDouble(sinhVien -> sinhVien.getMarks())
//                .min().getAsDouble();
//        System.out.println("sum: "+min);
//
//
    }

}

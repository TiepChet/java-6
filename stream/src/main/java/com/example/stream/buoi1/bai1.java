package com.example.stream.buoi1;


import java.util.Arrays;
import java.util.List;

public class bai1 {
    //Duyệt :forEach
    //Lọc : filter
    //Chuyển Đổi : map(), mapToDouble(), mapToInt(), mapToLong()
    //Tích lũy : reduce()
    //Tổng Hợp : sum(), count(), min(), max(), avg()
    //Ktra: allMatch, anyMatch(), noneMatch()
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 3, 7, 8, 4, 5);
        //•	Tính tổng các số chẵn trong danh sách
        int sums = list.stream().filter(o-> o%2 ==0).reduce(0,Integer::sum);
        System.out.println("Tổng các số chẵn: "+sums);
        //Tính tích các số lẻ
        int tichs = list.stream().filter(o-> o%2 !=0).reduce(1,(o1,o2)->o1*o2);
        System.out.println("Tích số lẻ: "+tichs);
        //tổng các giá trị
        int sum = list.stream().reduce(0,Integer::sum);
        System.out.println(sum);
        //tổng bình phương các số lẻ
        int tbp = list.stream().filter(o->o%2 !=0).reduce(0,(o1,o2)->o1+o2*o2);
        System.out.println(tbp);
    }

}

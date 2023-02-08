package com.hema.edu.info.manager.controller;

import com.hema.edu.info.manager.domain.Student;
import com.hema.edu.info.manager.server.StudentServer;

import java.util.Scanner;

public  class StudentControll extends BaseStudentControll{
    private Scanner sc=new Scanner(System.in);
    public  Student inputid(String deid){
        System.out.println("请输入学生姓名");
        String name=sc.next();
        System.out.println("请输入学生年龄");
        String age=sc.next();
        System.out.println("请输入学生生日");
        String day=sc.next();
        Student student=new Student();
        student.setId(deid);
        student.setName(name);
        student.setAge(age);
        student.setDay(day);
        return student;

    }


}

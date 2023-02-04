package com.hema.edu.info.manager.controller;

import com.hema.edu.info.manager.domain.Student;
import com.hema.edu.info.manager.server.StudentServer;

import java.util.Scanner;

public class StudentControll {
    private StudentServer studentServer= new StudentServer();
    Scanner sc=new Scanner(System.in);
    public void start() {


         lo:while(true){
            System.out.println("---------------------欢迎来到管理系统----------------------");
            System.out.println("请输入你的选择：1.添加学生 2.删除学生 3.查看学生 4.修改学生 5.退出");
            String choice=sc.next();
            switch (choice){
                case  "1":
                     addStudnet();
                   break;
                case  "2":
                    deleteStudent();

                    break;
                case "3":
                    selectStudent();

                   // System.out.println("查看学生");
                    // System.exit(0);
                    break ;
                case "4":
                    updateStudent();


                    // System.out.println("修改学生");
                     break ;
                case "5":
                      System.out.println("退出");
                     break lo;
                default:
                    System.out.println("输入有误");
                    break;

            }
        }
    }

    public void updateStudent() {
        String deid;
        while (true){
            System.out.println("请输入修改的学号");
            deid =sc.next();
            boolean isexist=studentServer.isExists(deid);
            if (isexist) {
                System.out.println("请输入学生姓名");
                String name=sc.next();
                System.out.println("请输入学生年龄");
                String age=sc.next();
                System.out.println("请输入学生生日");
                String day=sc.next();
                Student upstudent=new Student();
                upstudent.setId(deid);
                upstudent.setName(name);
                upstudent.setAge(age);
                upstudent.setDay(day);
                boolean updatestudent=studentServer.update(upstudent,deid);
                if (updatestudent) {
                    System.out.println("sucess");
                }else{
                    System.out.println("false");
                }
                break;
            }else {
                System.out.println("输入有误");
                break;
            }

        }




    }

    public void selectStudent() {

       Student[] st= studentServer.select();
        if (st == null) {
            System.out.println("没有数据");
            return;
        }
        else{
            System.out.println("学号\t姓名\t年龄\t生日");
            for (int i = 0; i < st.length; i++) {
                Student stu=st[i];
                if (stu != null) {
                    System.out.println(stu.getId()+stu.getName()+stu.getAge()+stu.getDay());
                }
            }
        }
    }

    public void deleteStudent() {
        String dsc;
        while(true){
            System.out.println("请输入删除的学生id");
             dsc=sc.next();

         boolean isexist=studentServer.isExists(dsc);
//        boolean destu= studentServer.delete();
       if(isexist){
           break;
       }else {
           System.out.println("输入有误");
       }
    }
        studentServer.delete(dsc);
        System.out.println("yes");
    }

    public void addStudnet() {
        String id;
         while (true){
             System.out.println("请输入学生id");
                     id =sc.next();
             boolean isexist=studentServer.isExists(id);
             if (isexist == true) {
                 System.out.println("存在");
             }
             else{
                    break;
             }

         }
         System.out.println("请输入学生姓名");
        String name=sc.next();
        System.out.println("请输入学生年龄");
        String age=sc.next();
        System.out.println("请输入学生生日");
        String day=sc.next();
        Student student=new Student();
        student.setId(id);
        student.setName(name);
        student.setAge(age);
        student.setDay(day);
       boolean stud= studentServer.add(student);
        if(stud){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}

package com.hema.edu.info.manager.controller;

import com.hema.edu.info.manager.domain.Student;
import com.hema.edu.info.manager.server.StudentServer;

import java.util.Scanner;

public class StudentControll {
     StudentServer studentServer= new StudentServer();
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
        studentServer.update();
    }

    public void selectStudent() {

        studentServer.select();
    }

    public void deleteStudent() {


        studentServer.delete();
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

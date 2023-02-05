package com.hema.edu.info.manager.entry;

import com.hema.edu.info.manager.controller.StudentControll;
import com.hema.edu.info.manager.controller.TeacherControll;

import java.util.Scanner;

public class infoManagerEntry {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

             lo:while(true){
                 System.out.println("---------------------欢迎来到管理系统----------------------");
                 System.out.println("请输入你的选择：1.学生管理系统 2.老师管理系统 3.推出");
                 String choice=sc.next();
                 switch (choice){
                     case  "1":
                         //System.out.println("学生管理系统");
                         StudentControll studentControll=new StudentControll();
                         studentControll.start();
                         break;
                     case  "2":
                         //System.out.println("老师管理系统");
                         TeacherControll teacherControll=new TeacherControll();
                         teacherControll.start();
                          break;
                     case "3":
                         System.out.println("退出");
                        // System.exit(0);
                          break lo;
                     default:
                         System.out.println("输入有误");
                         System.out.println("123");
                         break;

                 }
             }



    }
}

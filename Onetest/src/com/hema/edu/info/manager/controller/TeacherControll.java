package com.hema.edu.info.manager.controller;

import com.hema.edu.info.manager.domain.Student;
import com.hema.edu.info.manager.domain.Teacher;
import com.hema.edu.info.manager.server.TeacherServer;

import java.util.Scanner;

public class TeacherControll {
    private TeacherServer teacherServer=new TeacherServer();
    Scanner sc=new Scanner(System.in);
    public void start() {
        lo:while (true){
              System.out.println("---------------------欢迎来到管理系统----------------------");
              System.out.println("请输入你的选择：1.添加老师 2.删除老师 3.查看老师 4.修改老师 5.退出");
              String choice=sc.next();
              switch (choice){
                  case "1":
                     // System.out.println("添加");
                      addteacher();
                      break;
                  case "2":
                      System.out.println("删除");
                      break;
                  case "3":
                      //System.out.println("查看");
                      selectTeacher();
                      break;
                  case "4":
                      System.out.println("修改");
                      break;
                  case "5":
                      break lo;
                  default:
                      System.out.println("输入有误");
                      break;
              }
          }

    }

    public void selectTeacher() {
        Teacher[] teachers= teacherServer.selectTeacher();
        if (teachers == null) {
            System.out.println("没有数据");
        }else {
            System.out.println("工号\t姓名\t年龄\t生日");
         for (int i = 0; i <teachers.length ; i++) {
            Teacher teacher=teachers[i];
            if (teacher != null) {
                System.out.println(teacher.getId()+teacher.getName()+teacher.getAge()+teacher.getDay());
            }

        }

    }}

    public void addteacher() {
        String id;
        while(true){
            System.out.println("请输入老师工号");
            id=sc.next();
            boolean idisexist=teacherServer.isExist(id);
            if (idisexist) {
                System.out.println("学号存在");
            }else {
                break;
            }
        }

        System.out.println("请输入老是姓名");
        String name=sc.next();
        System.out.println("请输入老师年龄");
        String age=sc.next();
        System.out.println("请输入老师生日");
        String day=sc.next();
        Teacher teacher=new Teacher();
        teacher.setId(id);
        teacher.setName(name);
        teacher.setAge(age);
        teacher.setDay(day);

       boolean flag=teacherServer.addTeacher(teacher);
        if (flag) {
            System.out.println("success");
        }else {
            System.out.println("false");
        }

    }
}

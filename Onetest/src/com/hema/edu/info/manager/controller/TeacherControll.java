package com.hema.edu.info.manager.controller;

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
                      updateTeacher();
                      System.out.println("删除");
                      break;
                  case "3":
                      //System.out.println("查看");
                      selectTeacher();
                      break;
                  case "4":
                      upteacher();
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

    private void updateTeacher() {

        String id=fanfu();
        boolean delid=teacherServer.deleteTeacher(id);
        if (delid) {
            System.out.println("delete成功");
        }else {
            System.out.println("delete失败");
        }
    }

    public void upteacher() {

        String id=fanfu();
        Teacher teacher=chongfu(id);
        boolean teacher1=teacherServer.updateTeather(teacher,id);
        if (teacher1) {
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
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
                System.out.println("工号存在");
            }else {
                break;
            }
        }
      Teacher teacher=  chongfu(id);


       boolean flag=teacherServer.addTeacher(teacher);
        if (flag) {
            System.out.println("success");
        }else {
            System.out.println("false");
        }

    }
    public String fanfu(){
        String id;
        while(true){
            System.out.println("请输入老师工号");
            id=sc.next();
            boolean idisexist=teacherServer.isExist(id);
            if (idisexist) {
                break;
            }else {
                System.out.println("工号不存在");

            }

        }
        return id;
    }
    public Teacher chongfu(String id){
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
        return teacher;
    }
}

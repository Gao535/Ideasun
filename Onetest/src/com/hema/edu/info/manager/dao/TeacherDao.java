package com.hema.edu.info.manager.dao;

import com.hema.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private Teacher[] teachers=new Teacher[5];
    public  boolean addstudent(Teacher teacher) {
        int flag=-1;
        for (int i = 0; i <teachers.length ; i++) {
          Teacher teachers1=teachers[i];
            if (teachers1 == null) {
                flag=i;
                break;
            }
        }
        if (flag == -1) {
            System.out.println("满了");
            return false;
        }else{
            teachers[flag]=teacher;
            return true;
        }


    }

    public Teacher[] findAll() {
        return teachers;
    }
}

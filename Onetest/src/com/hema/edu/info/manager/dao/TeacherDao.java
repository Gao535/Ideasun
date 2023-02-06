package com.hema.edu.info.manager.dao;

import com.hema.edu.info.manager.domain.Teacher;

public class TeacherDao {
    private Teacher[] teachers=new Teacher[5];

    public  boolean deleteTeacherDao(String id) {
        boolean flag=false;
        int deleteid=getindex(id);
        if (deleteid !=-1) {
            teachers[deleteid]=null;
            flag=true;
        }
        return flag;
    }


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

    public boolean updateTeacher1(Teacher teacher, String id) {
        boolean flag=false;
        int upid=getindex(id);
        if (upid != -1) {
            teachers[upid]=teacher;
            flag=true;
        }

        return flag;
    }

    private int getindex(String id) {
        int index=-1;
        for (int i = 0; i <teachers.length ; i++) {
            Teacher teacher=teachers[i];
            if (teacher != null&&teacher.getId().equals(id)) {
                index=i;
                break;
            }

        }
        return index;
    }

}

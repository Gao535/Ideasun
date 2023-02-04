package com.hema.edu.info.manager.dao;

import com.hema.edu.info.manager.domain.Student;

public class StudentDao {
    private  Student[] students=new Student[5];
    public boolean add(Student student) {

      int index =-1;
        for (int i = 0; i < students.length; i++) {
                 Student student1=students[i];
                 if (student1==null)
                     index=i;
                 break;
        }
        if(index==-1){
            //System.out.println("满了");
            return false;
        }else{
            students[index]=student;
            return true;
        }

    }

    public Student[] findAll() {
        return students;
    }
}

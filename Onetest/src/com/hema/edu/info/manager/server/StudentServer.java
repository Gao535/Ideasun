package com.hema.edu.info.manager.server;

import com.hema.edu.info.manager.dao.StudentDao;
import com.hema.edu.info.manager.domain.Student;

public class StudentServer {
   private StudentDao studentDao=new StudentDao();

    public boolean add(Student student) {

        //Student[] Students=new Student[5];
//        if (student.getId() ==studentDao ) {
//
//        }

        return studentDao.add(student);
    }

    public void delete( ) {
    }

    public void select( ) {

    }

    public void update( ) {
    }

    public boolean isExists(String id) {

          Student[] stus=studentDao.findAll();
          boolean exists=false;
        for (int i = 0; i < stus.length; i++) {
           Student students=stus[i];
            if (students != null && students.getId().equals(id) ) {
                exists=true;
                     break;
            }
//            else {
//                return false;
//            }
        }
        return exists;
    }
}

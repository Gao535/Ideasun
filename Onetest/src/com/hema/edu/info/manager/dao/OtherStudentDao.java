package com.hema.edu.info.manager.dao;

import com.hema.edu.info.manager.domain.Student;

import java.util.ArrayList;

public class OtherStudentDao {
    //private static Student[] students=new Student[5];
    private static ArrayList<Student> students=new ArrayList<>();
    static {
        Student students1=new Student("1","高大辉","1","1977-10-11");
        Student student2=new Student("2","高小辉","2","1987-10-11");
        students.add(students1);
        students.add(student2);
    }
    public boolean add(Student student) {
            students.add(student);
            return true;
    }

    public Student[] findAll() {
        Student[] students12=new Student[students.size()];
        for (int i = 0; i <students12.length ; i++) {
            students12[i]=students.get(i);
        }
        return students12;
    }

    public void deleteStudent(String dsc) {
        int index=getIndex(dsc);
        students.remove(index);
    }
    public int getIndex(String id){
    int index=-1;
        for (int i = 0; i <students.size() ; i++) {
            Student student=students.get(i);
            if (student!= null && id.equals(student.getId())) {
                index=i;
            }
        }
    return index;
    }

    public boolean updatestudent(Student student, String deid) {
       int up= getIndex(deid);
        if (up != -1) {
            students.set(up,student);
            return true;
        }
       return false;


    }

}

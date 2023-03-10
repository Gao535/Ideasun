package com.hema.edu.info.manager.dao;

import com.hema.edu.info.manager.domain.Student;

public class StudentDao {
    private static Student[] students=new Student[5];
    static {
        Student students1=new Student("1","高大辉","1","1977-10-11");
        Student student2=new Student("2","高小辉","2","1987-10-11");
        students[0]=students1;
        students[1]=student2;
    }
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

    public void deleteStudent(String dsc) {
        int index=getIndex(dsc);
        students[index]=null;
    }
    public int getIndex(String id){
    int index=-1;
        for (int i = 0; i < students.length; i++) {
            Student stu=students[i];
            if(stu!=null&&stu.getId().equals(id)){
                index=i;
                break;
            }
        }
    return index;
    }

    public boolean updatestudent(Student student, String deid) {
       int up= getIndex(deid);
        if (up !=-1) {
            students[up]=student;
            return true;
        }else {
            return false;
        }


    }

}

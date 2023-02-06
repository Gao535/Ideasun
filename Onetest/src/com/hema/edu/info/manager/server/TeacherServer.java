package com.hema.edu.info.manager.server;


import com.hema.edu.info.manager.dao.TeacherDao;
import com.hema.edu.info.manager.domain.Teacher;

public class TeacherServer {
    private TeacherDao teacherDao=new TeacherDao();
    public  boolean addTeacher(Teacher teacher) {

        return teacherDao.addstudent(teacher);
    }

    public boolean isExist(String id) {
        boolean flag=false;
        Teacher[] teachers=teacherDao.findAll();
        for (int i = 0; i <teachers.length ; i++) {
           Teacher teach=teachers[i];
            if (teach!=null&&teach.getId().equals(id)){
                flag=true;
                break;
            }
        }
        return flag;
    }

    public Teacher[] selectTeacher() {
        Teacher[] tea=teacherDao.findAll();
        boolean flag=false;
        for (int i = 0; i < tea.length; i++) {
            Teacher te=tea[i];
            if (te != null) {
                flag=true;
                break;
            }
        }
        if (flag) {
            return tea;
        }

        return null;
    }

    public boolean updateTeather(Teacher teacher, String id) {

        return teacherDao.updateTeacher1(teacher,id);
    }

    public boolean deleteTeacher(String id) {


        return  teacherDao.deleteTeacherDao(id);
    }
}

package org.osgi.project.impl;

import org.osgi.project.Student;
import org.osgi.project.service.StudentApplication;
import org.osgi.project.service.StudentService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component(service = StudentService.class, immediate = true)
public class StudentServiceImpl implements StudentService {

    List<Student> studentList = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Reference
    StudentApplication studentApplication;

    @Activate
    public void activate() {

        logger.info("StudentService Started");

        Student student;
        student = new Student();
        student.setAge(22);
        student.setMarks(95);
        student.setName("abhishek");
        student.setStudentId(1);
        addStudent(student);


        Student student1;
        student1 = new Student();
        student1.setAge(21);
        student1.setMarks(50);
        student1.setName("varun");
        student1.setStudentId(2);
        addStudent(student1);

        Student student2;
        student2 = new Student();
        student2.setAge(22);
        student2.setMarks(25);
        student2.setName("utkarsh");
        student2.setStudentId(3);
        addStudent(student2);

        Student student3;
        student3 = new Student();
        student3.setAge(21);
        student3.setMarks(75);
        student3.setName("varnika");
        student3.setStudentId(4);
        addStudent(student3);

        studentList = getAllStudents();
        Iterator<Student> iterator = studentList.listIterator();
        while (iterator.hasNext()) {
            Student studentObj;
            studentObj = iterator.next();
            logger.info(studentObj.getName() + " " + studentObj.getMarks() + " ");
            if (isStudentPassed(studentObj.getId()))
                logger.info("Student Passed");
            else
                logger.info("Student failed");
        }

        Student student4;
        student4 = new Student();
        student4.setAge(22);
        student4.setMarks(81);
        student4.setName("astha");
        student4.setStudentId(5);
        addStudent(student4);

        deleteStudent(4);


        student4 = new Student();
        student4.setAge(22);
        student4.setMarks(81);
        student4.setName("astha");
        student4.setStudentId(5);
        addStudent(student4);

        student = getStudent(5);
        student.toString();

    }

    @Override
    public void addStudent(Student student) {
        if (studentApplication.isClassLimitReached(studentList)) {
            logger.error("Sorry, the list is full");
        } else {
            studentList.add(student);
            logger.info("Student added successfully \n" + student.toString());
        }

    }

    @Override
    public void deleteStudent(int id) {
        Student student = null;
        student = getStudent(id);
        if (student != null) {
            studentList.remove(student);
            logger.info("Student with id = " + id + " removed");
        }
    }

    @Override
    public boolean isStudentPassed(int id) {
        Student student = null;
        student = getStudent(id);

        if (student != null) {
            return student.getMarks() >= studentApplication.getPassingMarks();
        }

        return false;
    }

    @Override
    public Student getStudent(int id) {
        Student student = null;
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            student = iterator.next();
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List getAllStudents() {
        return studentList;
    }
}

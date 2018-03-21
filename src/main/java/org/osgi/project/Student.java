package org.osgi.project;

public class Student {

    protected String stdname;
    protected int stdId;
    protected int stdmks;
    protected int stdage;


    public void setStudentId(int id) {
        this.stdId = id;

    }

    public int getId() {
        return stdId;
    }

    public void setName(String name) {
        this.stdname = name;
    }

    public String getName() {
        return stdname;
    }

    public void setMarks(int mks) {
        this.stdmks = mks;
    }

    public int getMarks() {
        return stdmks;
    }

    public void setAge(int age) {
        this.stdage = age;
    }

    public int getAge() {
        return stdage;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + stdId +
                ", name='" + stdname + '\'' +
                ", marks_obtained=" + stdmks +
                ", age=" + stdage +
                '}';

    }
}

package com.leetcode.editor.test;

import org.springframework.beans.BeanUtils;

/**
 * @author： chenr
 * @date： Created on 2020/11/30 16:10
 * @version： v1.0
 * @modified By:
 */
public class TestBeanUtils {

   static class Student {
        private String id;
        private String name;
        private String gender;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }
    }
    static class Teacher {
        private String id;
        private String name;
        private String sex;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.setId("1");
        student.setName("张三");
        student.setGender("男");

        Teacher teacher = new Teacher();

        BeanUtils.copyProperties(student,teacher);
        System.out.println(teacher.sex);
        System.out.println(teacher.name);
    }

}

package edu.javacourse.studentorder.dao;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SimpleRunner {

    public static void main(String[] args) {
        try {
            Class<?> cl = Class.forName("edu.javacourse.studentorder.dao.DictionaryDaoImplTest");

            Constructor cst = cl.getConstructor();
            Object entity = cst.newInstance();

            Method[] methods = cl.getMethods();
            for (Method m : methods) {
                Annotation ann = m.getAnnotation(Test.class);
                if (ann != null) {
                    m.invoke(entity);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

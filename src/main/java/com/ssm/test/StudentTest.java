package com.ssm.test;

import com.ssm.domain.Student;
import com.ssm.domain.StudentParamter;
import com.ssm.mapper.StudentDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public class StudentTest {

    private ApplicationContext context;
    private StudentDao studentDao;

    @Before
    public void init() {
        context = new
                ClassPathXmlApplicationContext(
                "classpath*:spring-*.xml");

        studentDao = context.getBean(StudentDao.class);
    }

    @Test
    public void test() {
        StudentParamter paramter = new StudentParamter();

        String username = "";

        paramter.setPageIndex(0);
        paramter.setPageSize(3);
        paramter.setUsername(username);

        int total = studentDao
                .getTotalRecord(paramter);

        List<Student> students = studentDao
                .select(paramter);

        System.out.println(total);
        System.out.println(students);


    }

    @Test
    public void selectByID() {
        Student student = studentDao.selectByID(1);

        System.out.println(student);
    }

}

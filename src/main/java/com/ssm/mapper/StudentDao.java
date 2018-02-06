package com.ssm.mapper;

import com.ssm.domain.Student;
import com.ssm.domain.StudentParamter;

import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface StudentDao {
    /**
     * 带分页的模糊查询
     **/
    List<Student> select(StudentParamter paramter);

    /**
     * 条件查询总条数
     **/
    Integer getTotalRecord(StudentParamter paramter);

    Student selectByID(int id);

    Student selectByName(String username);
}

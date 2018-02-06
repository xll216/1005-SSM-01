package com.ssm.service;

import com.ssm.domain.Student;
import com.ssm.util.BaseResult;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
public interface StudentService {

    BaseResult<Student> select(
            int pageIndex,
            int pageSize,
            String username);

    Student selectByID(int id);

    Student selectByName(String username);
}

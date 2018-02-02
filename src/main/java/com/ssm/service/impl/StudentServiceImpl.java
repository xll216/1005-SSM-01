package com.ssm.service.impl;

import com.ssm.domain.Student;
import com.ssm.domain.StudentParamter;
import com.ssm.mapper.StudentDao;
import com.ssm.service.StudentService;
import com.ssm.util.BaseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Service
public class StudentServiceImpl
        implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public BaseResult<Student> select(
            int pageIndex, int pageSize,
            String username) {

        BaseResult<Student> result = new BaseResult<>();

        StudentParamter paramter = new StudentParamter();

        pageIndex = pageIndex * pageSize;

        paramter.setUsername(username);
        paramter.setPageIndex(pageIndex);
        paramter.setPageSize(pageSize);

        List<Student> data = studentDao
                .select(paramter);

        int total = studentDao
                .getTotalRecord(paramter);

        result.setTotal(total);
        result.setData(data);


        return result;
    }
}

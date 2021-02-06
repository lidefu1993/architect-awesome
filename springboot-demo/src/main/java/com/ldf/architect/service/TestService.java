package com.ldf.architect.service;

import com.ldf.architect.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {

    @Autowired
    public TestMapper testMapper;

    @Transactional
    public void transactionTest(){
        testMapper.selectList();
    }

}

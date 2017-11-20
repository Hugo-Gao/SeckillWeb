package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest
{

    @Autowired
    private SuccessKilledDao successKilledDao;
    @Test
    public void testInsertSuccessKilled() throws Exception
    {
        int count=successKilledDao.insertSuccessKilled(1001L, 17396224045L);
        System.out.println("count=" + count);
    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception
    {
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(1000L, 17396224045L);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}
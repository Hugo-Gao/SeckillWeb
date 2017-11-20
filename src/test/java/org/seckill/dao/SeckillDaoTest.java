package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest
{
    //注入Dao实现类依赖
    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testQueryById() throws Exception
    {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }
    /**
     * 1000元秒杀iPhone7
     Seckill{seckillId=1000, name='1000元秒杀iPhone7', number=100, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Thu Nov 16 16:31:14 CST 2017}
     *
     */


    @Test
    public void testQueryAll() throws Exception
    {
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills)
        {
            System.out.println(seckill);
        }
    }

    /**
     * Seckill{seckillId=1000, name='1000元秒杀iPhone7', number=100, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Thu Nov 16 16:31:14 CST 2017}
     Seckill{seckillId=1001, name='500元秒杀小米MIX2', number=200, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Thu Nov 16 16:31:14 CST 2017}
     Seckill{seckillId=1002, name='200元秒杀坚果Pro2', number=300, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Thu Nov 16 16:31:14 CST 2017}
     Seckill{seckillId=1003, name='100元秒杀三星S8', number=50, startTime=Wed Nov 01 00:00:00 CST 2017, endTime=Thu Nov 02 00:00:00 CST 2017, createTime=Thu Nov 16 16:31:14 CST 2017}
     */

    @Test
    public void testReduceNumber() throws Exception
    {
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount"+updateCount);
    }


}
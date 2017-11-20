package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by gaoyunfan on 2017/11/19
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceTest
{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception
    {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void getById() throws Exception
    {
        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }


    //测试代码完整逻辑 注意可重复执行
    @Test
    public void SeckillLogic() throws Exception
    {
        long id=1001;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        if(exposer.isExposed())
        {
            logger.info("exposer={}", exposer);
            long phone=15309099198L;
            String md5 = exposer.getMd5();
            try
            {
                SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
                logger.info("result={}", seckillExecution);
            }catch (RepeatKillException | SeckillCloseException e)
            {
                logger.error(e.getMessage());
            }
        }else {
            logger.warn("exposer={}", exposer);
        }
        //16:36:54.835 [main] INFO
        // o.seckill.service.SeckillServiceTest - exposer=Exposer{exposed=true, md5='ce3614441488b74b7ea92d5ff56d8156', seckillId=1000, now=0, start=0, end=0}

    }


}
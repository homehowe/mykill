package howe.mykill.service;

import java.util.List;

import howe.mykill.dto.Exposer;
import howe.mykill.dto.MykillExecution;
import howe.mykill.entity.Mykill;
import howe.mykill.exception.MykillCloseException;
import howe.mykill.exception.MykillException;
import howe.mykill.exception.RepeatKillException;

/**业务接口:站在使用者(程序员)的角度设计接口
 * 三个方面:1.方法定义粒度，方法定义的要非常清楚2.参数，要越简练越好
 * 3.返回类型(return 类型一定要友好/或者return异常，我们允许的异常)
 */
public interface MykillService {

    /**
     * 查询全部的秒杀记录
     * @return
     */
    List<Mykill> getMykillList();

    /**
     *查询单个秒杀记录
     * @param mykillId
     * @return
     */
    Mykill getById(long mykillId);


    //再往下，是我们最重要的行为的一些接口

    /**
     * 在秒杀开启时输出秒杀接口的地址，否则输出系统时间和秒杀时间
     * @param mykillId
     */
    Exposer exportMykillUrl(long mykillId);


    /**
     * 执行秒杀操作，有可能失败，有可能成功，所以要抛出我们允许的异常
     * @param mykillId
     * @param userPhone
     * @param md5
     * @return
     */
    MykillExecution executeMykill(long mykillId,long userPhone,String md5)
            throws MykillException,RepeatKillException,MykillCloseException;
}

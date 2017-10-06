package howe.mykill.dao;
import org.apache.ibatis.annotations.Param;

import howe.mykill.entity.SuccessKill;

/**
 * Created by codingBoy on 16/11/27.
 */
public interface SuccessKilledDao {

    /**
     * 插入购买明细,可过滤重复
     * @param mykillId
     * @param userPhone
     * @return插入的行数
     */
    int insertSuccessKilled(@Param("mykillId") long mykillId, @Param("userPhone") long userPhone);


    /**
     * 根据秒杀商品的id查询明细SuccessKilled对象(该对象携带了mykill秒杀产品对象)
     * @param mykillId
     * @return
     */
    SuccessKill queryByIdWithMykill(@Param("mykillId") long mykillId,@Param("userPhone") long userPhone);

}

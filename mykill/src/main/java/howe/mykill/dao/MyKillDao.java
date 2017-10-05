package howe.mykill.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import howe.mykill.entity.Mykill;

public interface MyKillDao {
	/**
     * 减库存
     * @param mykillId
     * @param killTime
     * @return 如果影响行数>1，表示更新库存的记录行数
     */
    int reduceNumber(@Param("mykillId") long mykillId, @Param("killTime") Date killTime);

    /**
     * 根据id查询秒杀的商品信息
     * @param mykillId
     * @return
     */
    Mykill queryById(long mykillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<Mykill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}

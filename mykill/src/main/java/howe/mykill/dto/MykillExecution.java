package howe.mykill.dto;

import howe.mykill.entity.SuccessKill;
import howe.mykill.enums.MykillStatEnum;

/**
 * 封装执行秒杀后的结果:是否秒杀成功
 * Created by codingBoy on 16/11/27.
 */
public class MykillExecution {

    private long mykillId;

    //秒杀执行结果的状态
    private int state;

    //状态的明文标识
    private String stateInfo;

    //当秒杀成功时，需要传递秒杀成功的对象回去
    private SuccessKill successKilled;

    //秒杀成功返回所有信息
    public MykillExecution(long mykillId, MykillStatEnum statEnum, SuccessKill successKilled) {
        this.mykillId = mykillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
        this.successKilled = successKilled;
    }

    //秒杀失败
    public MykillExecution(long mykillId, MykillStatEnum statEnum) {
        this.mykillId = mykillId;
        this.state = statEnum.getState();
        this.stateInfo = statEnum.getInfo();
    }

    public long getMykillId() {
        return mykillId;
    }

    public void setMykillId(long mykillId) {
        this.mykillId = mykillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKill getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKill successKilled) {

        this.successKilled = successKilled;
    }

    @Override
    public String toString() {
        return "MykillExecution{" +
                "mykillId=" + mykillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }
}

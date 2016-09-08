package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStartEnum;

/**
 * 封装秒杀执行后结果
 * Created by teng on 2016/5/18.
 */
public class SeckillExecution {

    private long seckillId;

    private int state;

    private String stateInfo;

    private SuccessKilled suceessKilled;

    public SeckillExecution(long seckillId, SeckillStartEnum seckillStartEnum, SuccessKilled suceessKilled) {
        this.seckillId = seckillId;
        this.state = seckillStartEnum.getState();
        this.stateInfo = seckillStartEnum.getStateInfo();
        this.suceessKilled = suceessKilled;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
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

    public SuccessKilled getSuceessKilled() {
        return suceessKilled;
    }

    public void setSuceessKilled(SuccessKilled suceessKilled) {
        this.suceessKilled = suceessKilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", suceessKilled=" + suceessKilled +
                '}';
    }
}

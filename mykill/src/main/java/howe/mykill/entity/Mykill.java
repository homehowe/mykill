package howe.mykill.entity;

import java.util.Date;

public class Mykill {
	private long mykillId;
	private String name;
	private int number;
	private Date startTime;
	private Date endTime;
	private Date createTime;
	
	public long getMykillId() {
	    return mykillId;
	}
	
	public void setMykillId(long mykillId) {
	    this.mykillId = mykillId;
	}
	
	public String getName() {
	    return name;
	}
	
	public void setName(String name) {
	    this.name = name;
	}
	
	public int getNumber() {
	    return number;
	}
	
	public void setNumber(int number) {
	    this.number = number;
	}
	
	public Date getStartTime() {
	    return startTime;
	}
	
	public void setStartTime(Date startTime) {
	    this.startTime = startTime;
	}
	
	public Date getEndTime() {
	    return endTime;
	}
	
	public void setEndTime(Date endTime) {
	    this.endTime = endTime;
	}
	
	public Date getCreateTime() {
	    return createTime;
	}
	
	public void setCreateTime(Date createTime) {
	    this.createTime = createTime;
	}
	
	@Override
	public String toString() {
	    return "Mykill{" +
	            "mykillId=" + mykillId +
	            ", name='" + name + '\'' +
	            ", number=" + number +
	            ", startTime=" + startTime +
	            ", endTime=" + endTime +
	            ", createTime=" + createTime +
	            '}';
	}
}

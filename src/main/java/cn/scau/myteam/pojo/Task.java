package cn.scau.myteam.pojo;

import java.util.Date;

public class Task {
    private Integer id;

    private Integer ppid;

    private Integer uid;
    
    private ProjectPhase projectPhase;//add
    
    private User user;//add

    private Date createTime;

    private Date endTime;

    private Date setRemind;

    private String setRepeat;

    private String content;

    private String remark;

    private String priority;

    private String label;

    private String isFinished;

    private String record;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPpid() {
        return ppid;
    }

    public void setPpid(Integer ppid) {
        this.ppid = ppid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
    
    //add
    public ProjectPhase getProjectPhase() {
		return projectPhase;
	}

	public void setProjectPhase(ProjectPhase projectPhase) {
		this.projectPhase = projectPhase;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getSetRemind() {
        return setRemind;
    }

    public void setSetRemind(Date setRemind) {
        this.setRemind = setRemind;
    }

    public String getSetRepeat() {
        return setRepeat;
    }

    public void setSetRepeat(String setRepeat) {
        this.setRepeat = setRepeat == null ? null : setRepeat.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(String isFinished) {
        this.isFinished = isFinished == null ? null : isFinished.trim();
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record == null ? null : record.trim();
    }

	
}
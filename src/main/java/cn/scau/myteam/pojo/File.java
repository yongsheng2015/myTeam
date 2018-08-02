package cn.scau.myteam.pojo;

public class File {
    private Integer id;

    private Integer ptid;

    private Integer tid;
    
    private ProjectTable projectTable;//add:增加部分
    private Task task;//add:增加部分
    
	private String type;

	private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getPtid() {
		return ptid;
	}

	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}


    //增加部分：start
    public ProjectTable getProjectTable() {
		return projectTable;
	}

	public void setProjectTable(ProjectTable projectTable) {
		this.projectTable = projectTable;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	//增加部分：end

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
package cn.scau.myteam.pojo;

public class ProjectPhase {
    private Integer id;

    private Integer ptid;
    private ProjectTable projectTable;//add:增加部分

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
    //update start
    public ProjectTable getProjectTable() {
		return projectTable;
	}

	public void setProjectTable(ProjectTable projectTable) {
		this.projectTable = projectTable;
	}
	//update end

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
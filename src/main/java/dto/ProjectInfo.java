package dto;

public class ProjectInfo {

	private int projectid = 0;
	private String projectname = "";
	private int member = 0;
	private String startdate = "";
	private String enddate = "";

	public ProjectInfo(int projectid, String projectname, int member, String startdate, String enddate) {
		this.projectid = projectid;
		this.projectname = projectname;
		this.member = member;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
}

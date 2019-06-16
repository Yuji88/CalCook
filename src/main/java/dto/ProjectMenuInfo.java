package dto;

public class ProjectMenuInfo {

	private int id = 0;
	private int projectid = 0;
	private int menuid = 0;
	private int ingredientid = 0;
	private int amount = 0;
	private String unit = "";
	private int eatmember = 0;
	private String eatdate = "";

	public ProjectMenuInfo() {
		this.id = 0;
		this.projectid = 0;
		this.menuid = 0;
		this.ingredientid = 0;
		this.amount = 0;
		this.unit = "";
		this.eatmember = 0;
		this.eatdate = "";
	}

	public ProjectMenuInfo(int id, int projectid, int menuid, int ingredientid, int amount, String unit, int eatmember, String eatdate) {
		this.id = id;
		this.projectid = projectid;
		this.menuid = menuid;
		this.ingredientid = ingredientid;
		this.amount = amount;
		this.unit = unit;
		this.eatmember = eatmember;
		this.eatdate = eatdate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public int getIngredientid() {
		return ingredientid;
	}

	public void setIngredientid(int ingredientid) {
		this.ingredientid = ingredientid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getEatmember() {
		return eatmember;
	}

	public void setEatmember(int eatmember) {
		this.eatmember = eatmember;
	}

	public String getEatdate() {
		return eatdate;
	}

	public void setEatdate(String eatdate) {
		this.eatdate = eatdate;
	}
}

package dto;

public class ProjectCookDisp {

	private int projectid = 0;
	private int menuid = 0;
	private String menuname = "";
	private int ingredientid = 0;
	private String ingredientname = "";
	private int amount = 0;
	private String unit = "";
	private int eatmember = 0;
	private String eatdate = "";

	public ProjectCookDisp() {
		this.projectid = 0;
		this.menuid = 0;
		this.menuname = "";
		this.ingredientid = 0;
		this.ingredientname = "";
		this.amount = 0;
		this.unit = "";
		this.eatmember = 0;
		this.eatdate = "";
	}

	public ProjectCookDisp(int projectid, int menuid, String menuname, int ingredientid, String ingredientname,
			int amount, String unit, int eatmember, String eatdate) {
		this.projectid = projectid;
		this.menuid = menuid;
		this.menuname = menuname;
		this.ingredientid = ingredientid;
		this.ingredientname = ingredientname;
		this.amount = amount;
		this.unit = unit;
		this.eatmember = eatmember;
		this.eatdate = eatdate;
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

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getIngredientid() {
		return ingredientid;
	}

	public void setIngredientid(int ingredientid) {
		this.ingredientid = ingredientid;
	}

	public String getIngredientname() {
		return ingredientname;
	}

	public void setIngredientname(String ingredientname) {
		this.ingredientname = ingredientname;
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

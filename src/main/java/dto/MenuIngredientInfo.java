package dto;

import model.IngredientData;
import model.MenuData;

public class MenuIngredientInfo {

	private int id = 0;
	private int menuid = 0;
	private String menuname = "";
	private int ingredientid = 0;
	private String ingredientname = "";
	private int amount = 0;
	private String unit = "";

	public MenuIngredientInfo(){
		this.id = 0;
		this.menuid = 0;
		this.menuname = "";
		this.ingredientid = 0;
		this.ingredientname = "";
		this.amount = 0;
		this.unit = "";
	}

	public MenuIngredientInfo(int id, int menuid, int ingredientid, int amount, String unit){
		this.id = id;
		this.menuid = menuid;
		this.ingredientid = ingredientid;
		this.amount = amount;
		this.unit = unit;

		MenuData menudata = new MenuData();
		this.menuname = menudata.MenuNameSelect(menuid);

		IngredientData ingredientdata = new IngredientData();
		this.ingredientname = ingredientdata.IngredientNameSelect(menuid);
	}

	public MenuIngredientInfo(int id, String menuname, String ingredientname, int amount, String unit){
		this.id = id;
		this.menuname = menuname;
		this.ingredientname = ingredientname;
		this.amount = amount;
		this.unit = unit;

		MenuData menudata = new MenuData();
		this.menuid = menudata.MenuIdSelect(menuname);

		IngredientData ingredientdata = new IngredientData();
		this.ingredientid = ingredientdata.IngredientIdSelect(menuname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}

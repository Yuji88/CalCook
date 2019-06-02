package dto;

public class IngredientInfo {

	private int ingredientid = 0;
	private String ingredientname = "";

	public IngredientInfo() {
		this.ingredientid = 0;
		this.ingredientname = "";
	}

	public IngredientInfo(int ingredientid, String ingredientname) {
		this.ingredientid = ingredientid;
		this.ingredientname = ingredientname;
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

}

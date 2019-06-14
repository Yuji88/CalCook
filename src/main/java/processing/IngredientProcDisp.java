package processing;

import java.util.ArrayList;

import dto.IngredientDispInfo;
import dto.MenuInfo;
import dto.MenuIngredientInfo;
import model.MenuIngredientData;

public class IngredientProcDisp {

	public IngredientDispInfo IngredientNameProc(MenuInfo menuInfo) {

		ArrayList<MenuIngredientInfo> MenuIngredientInfoList = new ArrayList<>();
		IngredientDispInfo dispString = new IngredientDispInfo();
		String IngredientDisp = "";

		dispString.setMenuId(menuInfo.getMenuid());
		dispString.setMenuName(menuInfo.getMenuname());

		MenuIngredientData menuIngredientData = new MenuIngredientData();
		MenuIngredientInfoList = menuIngredientData.EssMenuIngredientSelect(menuInfo.getMenuid());

		for(int i = 0; i < MenuIngredientInfoList.size(); i++) {
			if(i == 0) {
				IngredientDisp = MenuIngredientInfoList.get(i).getIngredientname();
			} else {
				IngredientDisp = IngredientDisp + "、" + MenuIngredientInfoList.get(i).getIngredientname();
			}
		}
		IngredientDisp.trim();
		if(IngredientDisp.length() >= 20) {
			IngredientDisp = IngredientDisp.substring(0,19);
			IngredientDisp = IngredientDisp + "...";
		}

		dispString.setIngredientDisps(IngredientDisp);
		return(dispString);
	}
}
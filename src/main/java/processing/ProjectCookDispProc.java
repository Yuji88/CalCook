package processing;

import java.util.ArrayList;

import dto.ProjectCookDisp;
import dto.ProjectMenuInfo;
import model.IngredientData;
import model.MenuData;
import model.ProjectMenuData;

public class ProjectCookDispProc {

	public ArrayList<ProjectCookDisp> ProjectCookDispPrepare(int projectId) {
		ArrayList<ProjectCookDisp> projectCookDispList = new ArrayList<>();
		ArrayList<ProjectMenuInfo> projectMenuInfoList = new ArrayList<>();
		ProjectMenuData projectMenuData = new ProjectMenuData();

		projectMenuInfoList = projectMenuData.ProjectMenuSelect(projectId);

		for(int i = 0; i < projectMenuInfoList.size(); i++) {
			ProjectCookDisp projectCookDisp = new ProjectCookDisp();
			MenuData menuData = new MenuData();
			IngredientData ingredientData = new IngredientData();

			projectCookDisp.setProjectid(projectMenuInfoList.get(i).getProjectid());
			projectCookDisp.setMenuid(projectMenuInfoList.get(i).getMenuid());
			projectCookDisp.setMenuname(menuData.MenuNameSelect(projectMenuInfoList.get(i).getMenuid()));
			projectCookDisp.setIngredientid(projectMenuInfoList.get(i).getMenuid());
			projectCookDisp.setIngredientname(ingredientData.IngredientNameSelect(projectMenuInfoList.get(i).getIngredientid()));
			projectCookDisp.setAmount(projectMenuInfoList.get(i).getAmount());
			projectCookDisp.setUnit(projectMenuInfoList.get(i).getUnit());
			projectCookDisp.setEatmember(projectMenuInfoList.get(i).getEatmember());
			projectCookDisp.setEatdate(projectMenuInfoList.get(i).getEatdate());

			projectCookDispList.add(projectCookDisp);
		}

		return(projectCookDispList);
	}
}

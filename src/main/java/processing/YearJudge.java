package processing;

public class YearJudge {

	public boolean YearJudgement(String searchYear, String startDate) {
		boolean result = true;

		final String[] YEARLIST = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

		String month = startDate.substring(5, 7);
		String year = startDate.substring(0, 4);

		int tmp = Integer.parseInt(year) + 1;
		String nextYear = String.valueOf(tmp);

		if(searchYear.equals(year)) {
			for(int i = 0; i < 2; i++) {
				if(month.equals(YEARLIST[i])) {
					result = false;
				}
			}

		} else if(searchYear.equals(nextYear)) {
			for(int i = 3; i < 11; i++) {
				if(month.equals(YEARLIST[i])) {
					result = false;
				}
			}

		} else {
			result = false;
		}

		return(result);
	}
}

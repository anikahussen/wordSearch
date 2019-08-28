package ah3866_asg_wordSearch;

import java.util.Comparator;

public class abcComp implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		//So ASCII does not separate cap and lower 
		String Lo1 = o1.toLowerCase();
		String Lo2 = o2.toLowerCase();
		return((Lo1).compareTo((Lo2)));
		
	}
	

}


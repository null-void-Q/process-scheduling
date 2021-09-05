import java.util.Comparator;

public class CompareArrival implements Comparator<Process> {

	@Override
	public int compare(Process ps1, Process ps2) {
	 
		 return Integer.compare(ps1.getArrivalTime(), ps2.getArrivalTime());
	}



}

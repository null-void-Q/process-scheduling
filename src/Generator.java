import java.util.ArrayList;
import java.util.Random;

public class Generator {

	public static ArrayList<Process> generateProcesses(int[] priRange,int nmOfProcesses, int prRange, int bRange, int numOfBursts) {
		ArrayList<Process> ps = new ArrayList<Process>();

		int priority;

		int arrivalTime = -1;// initial value/ real value given in schdule

		int startTime = -1, endTime = -1, waitTime = -1;// initial value/ real value given in schdule

		ArrayList<Burst> burstList;

		int numOfProcesses = getRandom(1, prRange);
		if(nmOfProcesses!=-1)
			numOfProcesses=nmOfProcesses;

		Process process;
		for (int i = 0; i < numOfProcesses; i++) {
			 priority = getRandom(priRange[0], priRange[1]);
			arrivalTime = -1;// initial value/ real value given in schdule
			startTime = -1;
			endTime = -1;
			waitTime = -1;// initial value/ real value given in schdule
			burstList = generateBursts(bRange, numOfBursts);

			process = new Process(i, priority, arrivalTime, burstList, startTime, endTime, waitTime);
			ps.add(process);
		}
		return ps;
	}

	public static int getRandom(int start, int end) {
		Random r = new Random();
		int priority = r.nextInt(((end - start) + 1)) + start;
		return priority;

	}

	public static ArrayList<Burst> generateBursts(int bRange, int fixedNum) {

		ArrayList<Burst> burstList = new ArrayList<Burst>();
		int numOfBursts = getRandom(1, bRange);
		if (fixedNum != -1)
			numOfBursts = fixedNum;
		
		char type = 'C';
		int burstDuration=getRandom(9, 101);
		Burst burst = new Burst(type,burstDuration);
		burstList.add(burst);
		boolean flag=false;
		for (int i = 0; i < numOfBursts - 1; i++) {
			type = getBurstType();
			burstDuration=getRandom(9, 101);
			if(flag) {
				type='C';
				flag=false;
			}
			if(type=='O') {
				burstDuration=getRandom(500-1, 1000+1);
				flag=true;
			}
			burst = new Burst(type,burstDuration);
			burstList.add(burst);
		}
		
		if (burstList.get(numOfBursts - 1).getType() == 'O')
			burstList.add(new Burst('C', getRandom(9, 101)));
		return burstList;
	}


	public static char getBurstType() {
		int n = binomialInt(50, 0, 100);
		System.out.println("num is " + n);
		if (n < 75)
			return 'C';
		return 'O';
	}

	public static int binomialInt(double mean, int min, int max) {
		if (max < min || mean < min || mean > max) {
			throw new IllegalArgumentException();
		}
		int n = max - min;
		double p = ((double) (mean - min)) / n;
		int val = min;
		for (int i = 0; i < n; i++) {
			if (Math.random() <= p) {
				val++;
			}
		}
		return val;
	}

}

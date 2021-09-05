import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

public class Scheduler {
	static ArrayList<Process> Disk;
	static ArrayList<Process> Processes;
	static PriorityQueue<Process> readyQueue;
	static ArrayList<Process> waitQueue;
	
 public static void FCFS() {	
	int [] priRange=new int[2];
	priRange[0]=0;
	priRange[1]=5;
	
	Disk=new ArrayList<Process>();
	Processes=new ArrayList<Process>();
	waitQueue=new ArrayList<Process>();
	
	Disk=Generator.generateProcesses(priRange, -1, 10, 7, 4);
	
	Processes.addAll(Disk);
	int numOfProcess=Processes.size();
	
	readyQueue=new PriorityQueue<Process>(numOfProcess,new CompareArrival());
	
	
	while(true) {
		
	if(Processes.isEmpty()) //check if done
		break;
	
	boolean ProcessorAvailable=true; //tells if processor vacant
	
	Random r= new Random();
	int num = r.nextInt(((numOfProcess)));
	
	for(int i=0; i<num;i++) //fetch new process disk to memory
		if(readyQueue.size()<20)
			readyQueue.add(fetchProcess(numOfProcess));
	
	Process currentProcess=null;
	
	if(ProcessorAvailable) //if processor available then start working on a process
		currentProcess=startProcess();
	
	if(!doWork(currentProcess)) // process until cpu burst is done
		ProcessorAvailable=false;
	
	waitIo(); // decrement the wait time for process in wait queue;
	
	TheTime.incTime(); //all the above take one time unit.
	
	
	}	
	
	
 }
public static Process fetchProcess(int numOfProcess) {
	Process process;
	Random r= new Random();
	int ps = r.nextInt(((numOfProcess-1))); 
	process=Processes.get(ps);
	Processes.remove(ps);
	process.setArrivalTime(TheTime.Time);
	
	log("Process add to memory"+process.getID());
	
	return process;
}

public static Process startProcess() {
	Process process;
	process=readyQueue.poll();
	process.setStartTime(TheTime.Time);
	
	log("Process Entered The Processor"+process.getID());
	
	return process;
}

public static boolean doWork(Process process) {
	
	if( !process.getBurstList().get(0).decTime()) {
		process.getBurstList().remove(0);
		if(process.getBurstList().get(0).getType()=='O') {
			waitQueue.add(process);
			return false;
		}
		else if (process.getBurstList().isEmpty())
			return false;
	}
	
	log("Processed 1 Time unit of P["+process.getID()+"]. Remaining:"+process.getBurstList().get(0).getDuration());
	
	return true;
}

public static void waitIo() {
	
	for(int i=0; i<waitQueue.size();i++) {
		if(!waitQueue.get(i).getBurstList().get(0).decTime()) {
			
			log("waiting Time done for P["+waitQueue.get(i).getID()+"].");
			
			waitQueue.get(i).setArrivalTime(TheTime.Time+1);
			readyQueue.add(waitQueue.get(i));
			waitQueue.remove(i);
		}
		log("Wait time decremented by 1 Time unit for P["+waitQueue.get(i).getID()+"].");
	}
	
	
}

public static void log(String message) {
	System.out.println(message);
	
}



}

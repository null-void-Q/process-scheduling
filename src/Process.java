import java.util.ArrayList;

public class Process {
	private int ID;
	private  int priority;
	private int arrivalTime;
	private ArrayList<Burst> burstList;
	private int startTime;
	private int endTime;
	private int waitTime;
	
	
	
	
	public Process(int iD, int priority, int arrivalTime, ArrayList<Burst> burstList, int startTime, int endTime, int waitTime) {
		super();
		ID = iD;
		this.priority = priority;
		this.arrivalTime = arrivalTime;
		this.burstList = burstList;
		this.startTime = startTime;
		this.endTime = endTime;
		this.waitTime = waitTime;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public ArrayList<Burst> getBurstList() {
		return burstList;
	}
	public void setBurstList(ArrayList<Burst> burstList) {
		this.burstList = burstList;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public String toString() {
		return "Process [ID=" + ID + ", priority=" + priority + ", arrivalTime=" + arrivalTime + ", burstList="
				+ burstList + ", startTime=" + startTime + ", endTime=" + endTime + ", waitTime=" + waitTime + "]";
	}
	
	
	

}

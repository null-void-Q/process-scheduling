
public class Burst {
	private char type;
	private int duration;
	public Burst(char type, int duration) {
		super();
		setType(type);
		setDuration(duration);
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public boolean decTime() {
		this.duration -= 1;
		if(this.getDuration() == 0)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Burst [type=" + type + ", duration=" + duration + "]";
	}
	
	
}

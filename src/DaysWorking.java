
public enum DaysWorking {
	Thứ_Hai(0),
	Thứ_Ba(1),
	Thứ_Tư(2),
	Thứ_Năm(3),
	Thứ_Sáu(4),
	Thứ_Bảy(5);
	
	private final int index;
	
	private DaysWorking(int o) {
		this.index = o;
	}
	
	public int getIndex() {
		return this.index;
	}
}

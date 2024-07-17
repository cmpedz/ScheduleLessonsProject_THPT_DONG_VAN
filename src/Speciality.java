
public enum Speciality {
	 Lý(true),
	 Hóa(true),
	 Sinh(true),
	 GDKT_PL(false),
	 Tin(true),
	 CN(true),
	 Địa(true),
	 CD_Toán(false),
	 CD_Lý(false),
	 CD_Hóa(false),
	 CD_Sinh(false),
	 CD_Văn(false),
	 CD_Sử(false),
	 CD_Địa(false),
	 GDĐP(false),
	 HĐTN(false);
	
	private boolean isInMorning;
	
	private int index;
	
	private Speciality(boolean b) {
		
		this.isInMorning = b;
		
	}
	
	public boolean IsInMorning() {
		return this.isInMorning;
	}
	
	public void setIndex(int i) {
		this.index = i;
	}
	
	public int getIndex() {
		return this.index;
	}
}

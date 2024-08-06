
public class QuantitiesLessonsTaughtPerDay extends Pairs<String, Integer> 
	implements Comparable<QuantitiesLessonsTaughtPerDay>{

	public QuantitiesLessonsTaughtPerDay(String v1, Integer v2) {
		super(v1, v2);
		// TODO Auto-generated constructor stub
	}
	
	public void setCurrentDayWorking(String dayName) {
		this.setValue1(dayName);
	}
	
	public String getCurrentDayWorking() {
		return this.getValue1();
	}

	public void setQuantitiesLessons(int quas) {
		this.setValue2(quas);
	}
	
	public int getQuantitiesLessons() {
		return this.getValue2();
	}
	
	@Override
	public int compareTo(QuantitiesLessonsTaughtPerDay o) {
		// TODO Auto-generated method stub
		
		return this.getValue2() - o.getValue2();
	}
	
	
}

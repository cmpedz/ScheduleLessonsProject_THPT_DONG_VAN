import java.util.TreeMap;

public class QuantitiesLessonsPerClassStorage {
	
	private static QuantitiesLessonsPerClassStorage instance;
	
	private TreeMap<String, Integer[]> quantitiesLessonsPerClass = new TreeMap<String, Integer[]>();
	
	
	
	private QuantitiesLessonsPerClassStorage() {
		// TODO Auto-generated constructor stub
		for(String className : SchoolInformations.getInstance().getClassesNameList()) {
			
			quantitiesLessonsPerClass.put(className, new Integer[SchoolInformations.MAX_STUDYING_SESSIONS]);
			
			for(int i = 0; i < SchoolInformations.MAX_STUDYING_SESSIONS; i++ ) {
				
				quantitiesLessonsPerClass.get(className)[i] = 0;
						
			}
		}
		
	}
	
	public void addQuantitiesLessonsIntoStorage(String className, int quantities, boolean isInMorning) {
		 
		int indexSessions = SchoolInformations.MORNING;
		
		if(!isInMorning) {
			indexSessions = SchoolInformations.AFTERNOON;
		}
			
		quantitiesLessonsPerClass.get(className)[indexSessions] += quantities;
		
	
	}
	
	public void checkData() {
		
		for(String className : quantitiesLessonsPerClass.keySet()) {
			System.out.println(className + " has quantities lessons in the morning : " + quantitiesLessonsPerClass.get(className)[SchoolInformations.MORNING] + ", "+
					" has quantities lessons in the afternoon : " + quantitiesLessonsPerClass.get(className)[SchoolInformations.AFTERNOON]);
		}
		
	}
	
	public int getMaxLessonsCanTeachEachDay(String className, boolean isInMorning) {
		
		int studyingDays = SchoolInformations.getInstance().getDayWorkingList().size();
		
		int sessionIndex = SchoolInformations.MORNING;
		
		if(isInMorning) {
			sessionIndex = SchoolInformations.AFTERNOON;
		}
		
		
		return (int)Math.ceil(quantitiesLessonsPerClass.get(className)[sessionIndex] / studyingDays);
	
	}
	
	public static QuantitiesLessonsPerClassStorage getInstance() {
		
		if(instance == null) {
			instance = new QuantitiesLessonsPerClassStorage();
		}
		
		return instance;
	}
	
	

}

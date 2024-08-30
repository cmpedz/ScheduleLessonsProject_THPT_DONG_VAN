
public class Course {
	
	private boolean isInMorning;
	
	private final int MAX_CONTINUES_LESSONS_CAN_TEACH;
	
	private final String NAME;
	
	private final boolean IS_MAIN_COURSE;
	
	private final String GROUP;
	

	public Course( String nAME, int mAX_CONTINUES_LESSONS_CAN_TEACH, boolean iS_IN_MORNING,
			boolean iS_MAIN_COURSE, String gROUP) {
		
		super();
		
		isInMorning = iS_IN_MORNING;
		
		MAX_CONTINUES_LESSONS_CAN_TEACH = mAX_CONTINUES_LESSONS_CAN_TEACH;
		
		NAME = nAME;
		
		IS_MAIN_COURSE = iS_MAIN_COURSE;
		
		GROUP = gROUP;
	}

	public boolean isInMorning() {
		return isInMorning;
	}
	
	public void setIsInMorning(boolean isInMorning) {
		
		this.isInMorning = isInMorning;
		
	}

	public int getMaxContinuesLessonCanTeach() {
		return MAX_CONTINUES_LESSONS_CAN_TEACH;
	}


	public String getName() {
		return NAME;
	}

	public boolean isIS_MAIN_COURSE() {
		return IS_MAIN_COURSE;
	}

	public String getGROUP() {
		return GROUP;
	}
	

	@Override
	public String toString() {
		
		return "Specialty Name: " + NAME + "\n" +
			   "Max Lesson Continues: " + MAX_CONTINUES_LESSONS_CAN_TEACH + "\n" +
			   "Is In Morning: " + isInMorning + "\n" +
			   "Is Main Course: " + IS_MAIN_COURSE + "\n" +
			   "Group: " + GROUP + "\n" ;
	}

	
}

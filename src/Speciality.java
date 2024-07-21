
public class Speciality {
	
	private final boolean IS_IN_MORNING;
	
	private final int MAX_CONTINUES_LESSONS_CAN_TEACH;
	
	private final String NAME;
	
	private final boolean IS_MAIN_COURSE;
	
	private final Group GROUP;

	public Speciality( String nAME, int mAX_CONTINUES_LESSONS_CAN_TEACH, boolean iS_IN_MORNING,
			boolean iS_MAIN_COURSE, Group gROUP) {
		super();
		IS_IN_MORNING = iS_IN_MORNING;
		MAX_CONTINUES_LESSONS_CAN_TEACH = mAX_CONTINUES_LESSONS_CAN_TEACH;
		NAME = nAME;
		IS_MAIN_COURSE = iS_MAIN_COURSE;
		GROUP = gROUP;
	}

	public boolean isInMorning() {
		return IS_IN_MORNING;
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

	public Group getGROUP() {
		return GROUP;
	}


	
	
}

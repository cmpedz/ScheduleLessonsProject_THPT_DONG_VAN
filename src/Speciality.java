
public class Speciality {
	
	private final boolean IS_IN_MORNING;
	
	private final int MAX_CONTINUES_LESSONS_CAN_TEACH;
	
	private final String NAME;
	
	

	public Speciality( String nAME, int mAX_CONTINUES_LESSONS_CAN_TEACH, boolean iS_IN_MORNING) {
		super();
		IS_IN_MORNING = iS_IN_MORNING;
		MAX_CONTINUES_LESSONS_CAN_TEACH = mAX_CONTINUES_LESSONS_CAN_TEACH;
		NAME = nAME;
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


	
	
}

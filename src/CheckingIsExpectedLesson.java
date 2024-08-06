import java.util.ArrayList;
import java.util.TreeMap;

public class CheckingIsExpectedLesson extends ArrangeLessonConditionWithIndex{

	public CheckingIsExpectedLesson(TreeMap<String, String[]> scheduleTable) {
		super(scheduleTable);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkConditionWithIndexLesson(int indexLesson) {
		// TODO Auto-generated method stub
		ArrayList<Integer> lessonsExpectedNotTeaching = teacher.getLessonsExpectedNotTeaching();
		
		if(lessonsExpectedNotTeaching == null) return true;
	
		
		for(Integer lesson : lessonsExpectedNotTeaching) {
			if(lesson == indexLesson) {
				return false;
			}
		}
		
		return true;
	}

}

import java.util.TreeMap;

public class CheckCanBeAddingdIfClassIsHavingMainCourseCondition extends ArrangeLessonCondition{

	private TreeMap<String, Pairs<String, Boolean>> isHavingMainCourse = new TreeMap<String, Pairs<String, Boolean>>();
	

	@Override
	public boolean checkIsMeetingCondition() {
		// TODO Auto-generated method stub
		Pairs<String, Boolean> currentClassInfors = isHavingMainCourse.get(_class.getName());
		
		boolean isCurrentClassHavingMainCourse = currentClassInfors.getValue2();
		
		boolean isCourseAddedDistinctFromCurrentMainCourse = !_class.getSpeciality().getName().equals(currentClassInfors.getValue1());
		
		if(isCurrentClassHavingMainCourse && _class.getSpeciality().isIS_MAIN_COURSE() &&
				isCourseAddedDistinctFromCurrentMainCourse) {
			return false;
		}
		
		return true;
	}

	public TreeMap<String, Pairs<String, Boolean>> getIsHavingMainCourse() {
		return isHavingMainCourse;
	}

	@Override
	public void constructDataForEachClass(String className) {
		// TODO Auto-generated method stub
		this.isHavingMainCourse.put(className , new Pairs<String, Boolean>("",false));
	}
	

}

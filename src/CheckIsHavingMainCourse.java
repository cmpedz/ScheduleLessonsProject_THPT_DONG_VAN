import java.util.TreeMap;

import java.lang.Boolean;

public class CheckIsHavingMainCourse extends ArrangeLessonConditionWithoutIndex{

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
	
	@Override
	public void changeDataAfterAddingNewLesson() {
		// specify that current lesson has main course
		String className = _class.getName();
		
		Speciality speciality = _class.getSpeciality();
		
		TreeMap<String, Pairs<String, Boolean>> isHavingMainCourse = getIsHavingMainCourse();
		
		if(!isHavingMainCourse.get(className).getValue2()) {
			
			isHavingMainCourse.get(className).setValue1( speciality.getName());
			
			isHavingMainCourse.get(className).setValue2( speciality.isIS_MAIN_COURSE());
		}
	}
	
	

}

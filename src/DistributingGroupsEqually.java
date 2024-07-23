import java.util.TreeMap;

public class DistributingGroupsEqually extends ArrangeLessonCondition{
	
	public static final int XÃ_HỘI = 0;	
	
	public static final int TỰ_NHIÊN = 1;	
	
	private TreeMap<String, Pairs<Group, Integer>[]> quantitiesEachGroup = new TreeMap<String, Pairs<Group,Integer>[]>();
	

	@Override
	public boolean checkIsMeetingCondition() {
		// TODO Auto-generated method stub
		String className = this._class.getName();
		
		Speciality lessonNeedAdding = this._class.getSpeciality();
		
		int quantities_XÃ_HỘI_Lessons_Has = quantitiesEachGroup.get(className)[XÃ_HỘI].getValue2();
		
		int quantities_TỰ_NHIÊN_Lessons_Has = quantitiesEachGroup.get(className)[TỰ_NHIÊN].getValue2();
		
		int quantitiesLessonHaveGroupSimilarToLessonNeedAdding = 0;
		
		int quantitiesRemainLesson = 0;
		
		if(lessonNeedAdding.getGROUP().equals(Group.TỔ_TỰ_NHIÊN)) {
			
			quantitiesLessonHaveGroupSimilarToLessonNeedAdding = quantities_TỰ_NHIÊN_Lessons_Has;
			
			quantitiesRemainLesson = quantities_XÃ_HỘI_Lessons_Has;
			
		} else {
			
			quantitiesLessonHaveGroupSimilarToLessonNeedAdding = quantities_XÃ_HỘI_Lessons_Has;
			
			quantitiesRemainLesson = quantities_TỰ_NHIÊN_Lessons_Has;
		}
		
		if(quantitiesLessonHaveGroupSimilarToLessonNeedAdding >= 2 && quantitiesRemainLesson < 2) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public void constructDataForEachClass(String className) {
		// TODO Auto-generated method stub
		quantitiesEachGroup.put(className, new Pairs[2]);
		
		quantitiesEachGroup.get(className)[XÃ_HỘI] = new Pairs<Group, Integer>(Group.TỔ_XÃ_HỘI, 0);
		
		quantitiesEachGroup.get(className)[TỰ_NHIÊN] = new Pairs<Group, Integer>(Group.TỔ_TỰ_NHIÊN, 0);
	
		
	}

	public TreeMap<String, Pairs<Group, Integer>[]> getQuantitiesEachGroup() {
		return quantitiesEachGroup;
	}

	@Override
	public void changeDataAfterAddingNewLesson() {
		// TODO Auto-generated method stub
		String className = _class.getName();
		
		Group groupOfLessonAdded = _class.getSpeciality().getGROUP();
		
		int indexGroupOfLessonAdded = -1;
		
		if(groupOfLessonAdded.equals(Group.TỔ_TỰ_NHIÊN)) {
			
			indexGroupOfLessonAdded = TỰ_NHIÊN;
					
		}else {
			indexGroupOfLessonAdded = XÃ_HỘI;
		}
		
		Pairs<Group, Integer> quantitesEachGroupData = quantitiesEachGroup.get(className)[indexGroupOfLessonAdded];
		
		quantitesEachGroupData.setValue2(quantitesEachGroupData.getValue2() + 1);
		
	}
	
	

}

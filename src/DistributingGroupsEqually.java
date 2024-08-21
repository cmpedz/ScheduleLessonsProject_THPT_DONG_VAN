import java.util.ArrayList;
import java.util.TreeMap;


public class DistributingGroupsEqually extends ArrangeLessonConditionWithoutIndex{

	
	private TreeMap<String, Pairs<String, Integer>[]> quantitiesEachGroup = new TreeMap<String, Pairs<String,Integer>[]>();
	
	
	public ArrayList<String> currentGroups = SchoolInformations.getInstance().getGroupsList();
	

	@Override
	public boolean checkIsMeetingCondition() {
		// TODO Auto-generated method stub
		String className = this._class.getName();
		
		Speciality lessonNeedAdding = this._class.getSpeciality();
	
		int quasLessonHasGroSameGroOfLessonNeedAdding = 0;
		
		int quantitiesRemainLesson = 0;
		
		
		for(int i = 0; i < currentGroups.size(); i++) {
			
			if(lessonNeedAdding.getGROUP().equals(currentGroups.get(i))) {
				
				quasLessonHasGroSameGroOfLessonNeedAdding = quantitiesEachGroup.get(className)[i].getValue2();
				
			} else {
				
				quantitiesRemainLesson += 
						quantitiesEachGroup.get(className)[i].getValue2();
			}
			
		}
		
		if(quasLessonHasGroSameGroOfLessonNeedAdding >= 3 && quantitiesRemainLesson < 2) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public void constructDataForEachClass(String className) {
		// TODO Auto-generated method stub
		
		int groupSize = this.currentGroups.size();
		
		quantitiesEachGroup.put(className, new Pairs[groupSize]);
		
		for(int i = 0; i < groupSize; i++) {
			quantitiesEachGroup.get(className)[i] = new Pairs<String, Integer>(this.currentGroups.get(i),0);
		}
		
	}

	public TreeMap<String, Pairs<String, Integer>[]> getQuantitiesEachGroup() {
		return quantitiesEachGroup;
	}

	@Override
	public void changeDataAfterAddingNewLesson() {
		// TODO Auto-generated method stub
		String className = _class.getName();
		
		String groupOfLessonAdded = _class.getSpeciality().getGROUP();
		
		for(int i =0; i < this.currentGroups.size(); i++) {
			
			if( groupOfLessonAdded.equals(currentGroups.get(i)) ) {
				
				Pairs<String, Integer> currentGroupData = quantitiesEachGroup.get(className)[i];
				
				int quantitiesCurrentGroupHas = currentGroupData.getValue2();
				
				currentGroupData.setValue2(quantitiesCurrentGroupHas + 1);
						
				break;
			}
			
		}
		
	
		
	}
	
	

}

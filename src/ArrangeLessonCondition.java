
public abstract class ArrangeLessonCondition{
	protected SchoolClass _class;
	
	protected Teacher teacher;
	
	public abstract boolean checkIsMeetingCondition();
	
	public abstract void constructDataForEachClass(String className);
	
	public void set_class(SchoolClass _class) {
		this._class = _class;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	

}

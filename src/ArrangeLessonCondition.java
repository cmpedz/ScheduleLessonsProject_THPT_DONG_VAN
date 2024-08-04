
public abstract class ArrangeLessonCondition{
	protected SchoolClass _class;
	
	protected Teacher teacher;
	
	public void set_class(SchoolClass _class) {
		this._class = _class;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	public abstract int getConditionType();
	
	
	

}

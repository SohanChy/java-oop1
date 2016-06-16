class Course{
	
	private final int MAX_STUDENTS = 30;
	private String courseName;
	private int studentsCount;
	private Student[] studentsEnrolled = new Student[30];
	
	Course(String courseName){
		this.courseName = courseName;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public boolean addStudent(Student student){
		
		if(studentsCount <MAX_STUDENTS){
			studentsCount++;
			studentsEnrolled[studentsCount - 1] = student;
			
			return true;
		}
		
		System.out.println("Failed to add student");
		return false;
	}
	
	public boolean removeStudent(Student student){
				
		if(studentsCount > 0){
			
			for(int i = 0; i < studentsEnrolled.length; i++){
				if(studentsEnrolled[i] == student){
					studentsEnrolled[i] = null;
					studentsCount--;
					
					if(i <= studentsCount){
						cleanstudentsEnrolled();
					}
					
					return true;
				
				}
		
			}
		
		}
		System.out.println("Failed to remve student");
		return false;
	}
		
	private void cleanstudentsEnrolled(){
		for(int i = 0; i < studentsCount; i++){
			if(studentsEnrolled[i] == null){
				for(int j = i; j < studentsCount; j++){
					studentsEnrolled[j] = studentsEnrolled[j + 1];
				}
			}
		}
		
	}
	
	public void showAllStudents(){
		System.out.println("-----------------------\n");
		System.out.println(getCourseName() + " : "+studentsCount);

		for(int i = 0; i < studentsCount; i++){
			System.out.println(studentsEnrolled[i].getName());
		}
		System.out.println("-----------------------\n");
	}
	
	public void printInfo(){
		System.out.println("-----------------------\n");
		System.out.println(getCourseName() + " : "+studentsCount);
		System.out.println("-----------------------\n");
	}
	

		
	
	
}

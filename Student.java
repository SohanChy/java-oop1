class Student{
	private final int MAX_COURSES = 5;
	
	private Course[] coursesTaken = new Course[5];
	private int courseCount;
	
	private String name,id,department;
	private float cgpa;

	//Constructors
	Student(){
		name = id = department= "N/A";
		cgpa = 0.0f;
	}
	
	Student(String name, String id, String department, float cgpa){
		this.name = name;
		this.id = id;
		this.department = department;
		this.cgpa = cgpa;
	}

	void showInfo(){
		System.out.println("-----------------------\n");
		System.out.println("Name: "+name+"\n"
						+"Id: "+id+"\n"
						+"department: "+department+"\n"
						+"Cgpa: "+cgpa);
		printCourses();
		System.out.println("-----------------------\n");
	}

	//Setter methods
	void setName(String name){
		this.name = name;
	}

	void setId(String id){
		this.id = id;
	}

		void setDepartment(String department){
		this.department = department;
	}

		void setCgpa(float cgpa){
		this.cgpa = cgpa;
	}

	//Getter methods
	String getName(){
		return this.name;
	}

	String getId(){
		return this.id;
	}

	String getDepartment(){
		return this.department;
	}

	float getCgpa(){
		return this.cgpa;
	}
	
	
	//course
	
	public boolean addCourse(Course course){
		
		if(courseCount < MAX_COURSES){
			
			if(course.addStudent(this)){
				
				courseCount++;
				coursesTaken[courseCount - 1] = course;
				
				System.out.println("Successfully added course");
				return true;
			}
		}
		System.out.println("Failed to add course");
		return false;
	}
	
	public boolean dropCourse(Course course){
		if(courseCount > 0){
			if(course.removeStudent(this)){
				for(int i = 0; i < courseCount; i++){
					if(coursesTaken[i] == course){
						coursesTaken[i] = null;

						System.out.println("Successfully removed course");
						return true;
					}
				}
			}
		}
		System.out.println("Failed to drop course");
		return false;
	}
	
	public void printCourses(){
		System.out.println(getName()+"'s Courses:");
		for(int i = 0; i < courseCount; i++){
			if(coursesTaken[i] != null){
			System.out.println(coursesTaken[i].getCourseName());
			}
		}
	}
						
		


	public static void main(String args[]){
		
		Course phy = new Course("Physics");
		Course che = new Course("Chem");
		Course mat = new Course("Math");
		Course bio = new Course("Bio");
		Course soc = new Course("Sociology");
		Course eng = new Course("English");
		
		phy.printInfo();

		Student rahim = new Student("Rahim","111-2","BBA",0.0f);
		rahim.showInfo();

		Student karim = new Student("Kahim","211-2","BBA",0.0f);
		karim.showInfo();
		
		Student abdul = new Student("Abdul","151-2","CSE",0.0f);
		abdul.showInfo();

		
		rahim.addCourse(phy);
		rahim.addCourse(che);
		rahim.addCourse(mat);
		rahim.addCourse(bio);
		rahim.addCourse(soc);
		rahim.addCourse(eng);
		
		rahim.showInfo();
		
		karim.addCourse(phy);
		karim.addCourse(che);
		karim.addCourse(mat);
		karim.addCourse(bio);
		karim.addCourse(soc);
		karim.addCourse(eng);
	
		karim.showInfo();
		
		abdul.addCourse(phy);
		abdul.addCourse(che);
		abdul.addCourse(mat);
		abdul.addCourse(bio);
		abdul.addCourse(soc);
		abdul.addCourse(eng);

		abdul.showInfo();
		
			
		phy.showAllStudents();
		che.showAllStudents();
		mat.showAllStudents();
		bio.showAllStudents();
		soc.showAllStudents();
		eng.showAllStudents();
		
		rahim.dropCourse(phy);
		rahim.dropCourse(che);
		rahim.showInfo();
		
		
		phy.showAllStudents();
		

	}


}
public abstract class Department{
	protected String deptName;
	protected int creditFee;
	
	Department(){
		deptName = "None";
	}
	
	Department(String deptName, int creditFee){
		this.deptName = deptName;
		this.creditFee = creditFee;
	}
	
	String getName(){
		return deptName;
	}
	
	public abstract void calculateSemesterFee(int credit);
	
	public static void main(String args[]){
		Department CS = new CS();
		CS.calculateSemesterFee(50);
		
		Department EEE = new EEE();
		CS.calculateSemesterFee(60);
		
		Department BBA = new BBA();
		CS.calculateSemesterFee(40);
		
		
		Student Karim = new Student("karim mia",CS);
		
		Karim.showStudentInfo();
		Karim.setDepartment(BBA);
		Karim.changeDepartment(BBA);
		
		Karim.showStudentInfo();		
	}
}


class CS extends Department{
	
	CS(){
		deptName = "CS";
	}
	
	public void calculateSemesterFee(int credit){
		creditFee = credit * 100;
		System.out.println("Credit Fee = "+creditFee);
	}
}
	
class EEE extends Department{
	
	EEE(){
		deptName = "EEE";
	}
	
	public void calculateSemesterFee(int credit){
		creditFee = credit * 150;
		System.out.println("Credit Fee = "+creditFee);
	}
}
	
	
class BBA extends Department{
	
	BBA(){
		deptName = "BBA";
	}
	
	public void calculateSemesterFee(int credit){
		creditFee = credit * 80;
		System.out.println("Credit Fee = "+creditFee);
	}
}


class Student{
	String stuName; 
	Department dept;
	
	Student(String stuName){
		this.stuName = stuName;
	}
	
	Student(String stuName, Department dept){
		this(stuName);
		this.dept = dept;
	}
	
	public void showStudentInfo(){
		System.out.println(
			"Name : "+stuName+"\n"
			+"Department : "+dept.getName());
			
		dept.calculateSemesterFee(10);
		
	}
	
	public void setDepartment(Department dept){
		if(dept == null){
			this.dept = dept;
		}
		else{
			System.out.println("Failed to set, Already have a dept.");
		
		}
	}
	
	public void changeDepartment(Department dept){
		System.out.println("Dept change application submitted");
		this.dept = dept;
	}
	
	void semesterFee(int totalCredit){      
		dept.calculateSemesterFee(totalCredit); 
		} 

}	
 


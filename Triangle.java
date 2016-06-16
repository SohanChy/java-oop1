class Triangle{
	private int x,y,z;

	Triangle(){
		this.x = 5;
		this.y = 6;
		this.z = 7;
	}

	Triangle(int x,int y,int z){
		this.x = x;
		this.y = y;
		this.z = z;
	}


	/*
	Check whether the triangle is 
	equilateral(3 equal sides), 
	isosceles(2 equal sides), 
	scalene(no equal sides)
	*/
	
	void testTriangle(){
		int status = 0;

		if(x==y){
			status++; 
		}
		if(y==z){
			status++; 
		}
		if(z==x){
			status++; 
		}

		if(status >= 2){
			System.out.println("Type: Equilateral");
		}
		else if(status > 0){
			System.out.println("Type: Isosceles");			
		}
		else{
			System.out.println("Type: Scalene");			
		}

	}

	void showInfo(){
		System.out.println("This is a Triangle\n"
			+"x : "+x+"\n"
			+"y : "+y+"\n"
			+"z : "+z);

		this.testTriangle();
	}


	public static void main(String args[]){
		Triangle test = new Triangle();
		Triangle three = new Triangle(3,3,3);
		Triangle two = new Triangle(5,4,5);
		Triangle none = new Triangle(4,5,6);

		test.showInfo();
		three.showInfo();
		two.showInfo();
		none.showInfo();
			
	}
}

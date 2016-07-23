public interface BasicCalculatorInterface{
	public int sum(int x, int y);
	public int sub(int x, int y);
	public int multiplication(int x, int y); 
	public int division(int x, int y); 

	public static void main(String args[]){
		BasicCalculatorInterface b = new BasicCalc();
		
		System.out.println(b.sum(1,5));
		
		
		ScientificCalculatorInterface s = new ScientificCalc();
		
		System.out.println(s.XtoY(1,5));
	}
}

interface ScientificCalculatorInterface{
	int XtoY(int x, int y);
}


class BasicCalc implements BasicCalculatorInterface{
	public int sum(int x, int y){
		return x+y;
	}
	
	public int sub(int x, int y){
		return x-y;
	}
	
	public int multiplication(int x, int y){
		return x*y;
	}
	
	public int division(int x, int y){
		if(y!=0){
			return x/y;
		}
		else return 0;
	}
}

class ScientificCalc extends BasicCalc implements ScientificCalculatorInterface{
	public int XtoY(int x, int y){
		int sum = 0;
		
		if(x<y){
			return 0;
		}
		
		for(int i = x; x <= y; x++){
			sum = sum + i;
		}
		
		return sum;
	}
	
}

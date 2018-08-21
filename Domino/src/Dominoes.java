import java.util.ArrayList;

public class Dominoes {
		
	int a;	int b;
	ArrayList<Dominoes> dominoSet;
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
		
	public ArrayList<Dominoes> getDominoSet() {
		return dominoSet;
	}

	public void setDominoSet(ArrayList<Dominoes> dominoSet) {
		this.dominoSet = dominoSet;
	}

	public Dominoes() {		
	}
	
	public Dominoes(int a, int b) {
		this.a = a;
		this.b = b;		
	}	
	
	public ArrayList<Dominoes> genDominoSet() {		

		ArrayList<Dominoes> dominoSet  = new ArrayList<>();
		for (int i = 0; i <= 6; i++) {
			for (int j = 0 + i; j <= 6; j++) {							
				Dominoes k = new Dominoes(i,j);
				dominoSet.add(k);				
			}			
		}
		return dominoSet;
	}	
}

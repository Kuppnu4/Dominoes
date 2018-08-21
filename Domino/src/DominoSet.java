import java.util.ArrayList;

public class DominoSet {
	private Chain chain;
	private ArrayList<Dominoes> dominoSet;		

	public DominoSet() {		
		dominoSet = new ArrayList<>();	
		chain = new Chain();
	}
	public void setDominoSet(Dominoes[] dominoArray) {		
		dominoSet = new ArrayList<>();	
		chain = new Chain();
		for(int i = 0; i < dominoArray.length; i++)
			dominoSet.add(dominoArray[i]);			
	}

	public DominoSet(int n) {			
								
		dominoSet = new ArrayList<>();
		chain = new Chain();
		
		Dominoes dominoes = new Dominoes();
		ArrayList<Dominoes> dominoTake = dominoes.genDominoSet();
	
		if (n < 0 || n > 28) {System.out.println("Некорректное число камней"); return;} // условие по колличеству камней
			
		if (dominoTake.size() == n) {return;}  // если выюираются все 28 камней, просто передается первоначальный лист
	
		for(int i = 0; i < n; i++) {						  
			Dominoes dominoTemp = dominoTake.get((int)(Math.random()*(dominoTake.size()-1) + 1));			
			dominoSet.add(dominoTemp);
			dominoTake.remove(dominoTemp);
		}		
			
	}
	
	public boolean addRightToChain(Dominoes d){			
		boolean isAdd = chain.addRight(d);
		if (isAdd){
			dominoSet.remove(d);
		}
		return isAdd;
	}

	public boolean addLeftToChain(Dominoes d){			
		boolean isAdd = chain.addLeft(d);
		if (isAdd){
			dominoSet.remove(d);
		}
		return isAdd;
	}
	
	public ArrayList<DominoSet> generateChains(){
		int size = chain.getSize();	
		ArrayList<DominoSet> chainList = new ArrayList<>();
		if (size == 0) {				
			for (int i = 0; i <  dominoSet.size(); i++) {
				Dominoes d = dominoSet.get(i);						
				DominoSet dominoChain = new DominoSet();
				dominoChain.setDominoSet(dominoSet);
				dominoChain.addLeftToChain(d);
				chainList.add(dominoChain);
			}		
			
		}else {			
			for (int i = 0; i < dominoSet.size(); i++) {				
				Dominoes dTemp = dominoSet.get(i);
			
				DominoSet dRight = new DominoSet();				
				dRight.setChain(chain);
				dRight.setDominoSet(dominoSet);				
				if (dRight.addRightToChain(dTemp))
					chainList.add(dRight);
				DominoSet dLeft = new DominoSet();
				dLeft.setChain(chain);
				dLeft.setDominoSet(dominoSet);				
				if (dLeft.addLeftToChain(dTemp))
					chainList.add(dLeft);	
						
			}
		}			
		return chainList;
			
	}
					
	
	
	public boolean isSame(DominoSet dList) {
		return this.chain.isSame(dList.getChain());
	}
	
	
	public String dominoesToString() {
		String txt = "";
		for (Dominoes d : dominoSet)
			txt += "| " + d.a + ":" + d.b + " "; 
		
		return txt;
	}
			

	public ArrayList<Dominoes> getDominoSet() {
		return dominoSet;
	}

	public void setDominoSet(ArrayList<Dominoes> dList) {
		this.dominoSet = new ArrayList<Dominoes>();
		for(Dominoes d : dList)
			dominoSet.add(d);
	}

	public Chain getChain() {
		return chain;
	}

	public void setChain(Chain chain) {
		this.chain = new Chain();
		ArrayList<Dominoes> list = this.chain.getList();
		for(Dominoes n: chain.getList()){
			list.add(n);
		}
		this.chain.setT1(chain.getT1());
		this.chain.setT2(chain.getT2());
	}
}

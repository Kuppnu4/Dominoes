import java.util.ArrayList;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int n = Integer.parseInt(args[0]);		
		DominoSet domies = new DominoSet(n);
		System.out.println(domies.dominoesToString());
		ArrayList<DominoSet> chains = findMaxChain(n, domies);		
		
		for(DominoSet doms : chains) {
			System.out.println("Цепочка: " + doms.getChain().toString() + " оставшиеся кости: " + doms.dominoesToString());
		}
		long stop = System.currentTimeMillis();		
		System.out.println("Колличество доминошек: " + n +"\nКолличество цепочек: " + chains.size() + "\nМаксимальная длина цепочек: " + chains.get(0).getChain().getSize() + "\nВремя расчета: " + (stop - start) + " ms");
		
		
				
	}
	

	public static ArrayList<DominoSet> findMaxChain(int n, DominoSet dominoDistrib){			
		long start = System.currentTimeMillis();
		ArrayList<DominoSet> dominoChains = dominoDistrib.generateChains();
				
		int count = 1;
		while(count < n) {
			ArrayList<DominoSet> chainsNext = new ArrayList<>();
			for (DominoSet d : dominoChains) {				
				ArrayList<DominoSet> chainsTemp = d.generateChains();
				for(DominoSet dom : chainsTemp) 					
					chainsNext.add(dom);			
			}
			if (chainsNext.size() == 0) break;
			ArrayList<DominoSet> chainsTemp = new ArrayList<>();
		 U: for(DominoSet kcN : chainsNext) {
				
				for(DominoSet kcT : chainsTemp)
					if(kcN.isSame(kcT)) {continue U;}
				chainsTemp.add(kcN);
			}
			dominoChains.clear();
			for(DominoSet k : chainsTemp)
				dominoChains.add(k);
			count++;
			long stopNext = System.currentTimeMillis();
			System.out.println("длина цепей: " + count + "  время расчета: " + (stopNext - start) + " ms");
			start = System.currentTimeMillis();			
		}
		
		return dominoChains;			
	}

}

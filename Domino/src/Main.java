import java.util.ArrayList;

public class Main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();     	//time start
		int n = Integer.parseInt(args[0]);		//quantity of dominoes which should be calculated
		DominoSet domies = new DominoSet(n);		//creating new dominoes set for calculation
		System.out.println(domies.dominoesToString());
		ArrayList<DominoSet> chains = findMaxChain(n, domies);	// creating ArrayList of chains with maximum length
		
		for(DominoSet doms : chains) {   		//print all chains with max length
			System.out.println("Chain: " + doms.getChain().toString() + " Remained dominoes: " + doms.dominoesToString());
		}
		long stop = System.currentTimeMillis();		//time stop
		System.out.println("Quantity of dominoes: " + n +"\nQantity of chains: " + chains.size() + "\nMaximum Length of Chains: " + chains.get(0).getChain().getSize() + "\nCalculation time: " + (stop - start) + " ms");
					
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
			System.out.println("äëèíà öåïåé: " + count + "  âðåìÿ ðàñ÷åòà: " + (stopNext - start) + " ms");
			start = System.currentTimeMillis();			
		}
		
		return dominoChains;			
	}

}

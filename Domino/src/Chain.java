import java.util.ArrayList;

public class Chain {
	private ArrayList<Dominoes> list = null; // последовательность номеров костей, входящих в цепь
	private int t1; // число в начале последовательности (слева)
	private int t2; // число в конце последовательности (справа)

	public Chain(){
		list = new ArrayList<Dominoes>();
		t1 = -1;
		t2 = -1;
	}
	
	public ArrayList<Dominoes> getList() {
		return list;
	}


	public void setList(ArrayList<Dominoes> list) {
		this.list = list;
	}


	public int getT1() {
		return t1;
	}


	public void setT1(int t1) {
		this.t1 = t1;
	}


	public int getT2() {
		return t2;
	}


	public void setT2(int t2) {
		this.t2 = t2;
	}


	public boolean addRight(Dominoes domi){
		if (t1 == -1){
			list.add(domi);
			t1 = domi.a;
			t2 = domi.b;
			return true;
		}
		if ((domi.a == t2) || (domi.b == t2)){
			list.add(domi);
			if (domi.a == t2){
				t2 = domi.b;
			} else{
				t2 = domi.a;
			}
			return true;
		}
		return false;
	}
	
	public boolean addLeft(Dominoes domi){
		if (t1 == -1){
			list.add(domi);
			t1 = domi.a;
			t2 = domi.b;
			return true;
		}
		if ((domi.a == t1) || (domi.b == t1)){
			list.add(0, domi);
			if ((domi.a == t1)){
				t1 = domi.b;
			} else{
				t1 = domi.a;
			}
			return true;
		}
		return false;
	}
	
	public int getSize(){
		return list.size();
	}
	
	public void clear(){
		list = new ArrayList<Dominoes>();
		t1 = -1;
		t2 = -1;
	}
	
	public String toString(){
		String text = "";
		for(Dominoes n: list){
			//Tile tile = new Tile(n.intValue());
			text += n.a + ":" + n.b + " -> ";
		}
		return text;
	}
	
	public boolean isSame(Chain c){ 
		if(list.size() != c.getList().size()){
			return false;
		}

		for(int i = 0; i < c.getSize(); i++){
			Dominoes thisD = list.get(i);
			Dominoes compD = c.getList().get(i);
			if(thisD != compD){
				return false;
			}
		}
		return true;

	}
}

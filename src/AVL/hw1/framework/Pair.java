package AVL.hw1.framework;

public class Pair<T1, T2> {
	T1 t1;
	T2 t2;

	public Pair(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		
		Pair pair = (Pair)obj;
		
		if (this.t1.equals(pair.t1)) {
			if (this.t2.equals(pair.t2)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.t1.hashCode();
		result = prime * result + this.t2.hashCode();
		return result;
	}
}

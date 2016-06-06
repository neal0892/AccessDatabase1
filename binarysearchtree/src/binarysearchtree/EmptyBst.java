package binarysearchtree;

public class EmptyBst<D extends Comparable> implements Tree<D>{
	public boolean isEmpty(){
		return true;
	}
	
	public int cardinality(){
		return 0;
	}

	public boolean member(D elt){
		return false;
	}
	
	public NonEmptyBst<D> add(D elt){
		return new NonEmptyBst<D>(elt);
	}
}

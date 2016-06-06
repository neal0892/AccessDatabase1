package binarysearchtree;

public class NonEmptyBst<D extends Comparable> implements Tree<D> {
	D data;
	Tree<D> left;
	Tree<D> right;

	public NonEmptyBst(D elt) {
		data = elt;
		left = new EmptyBst<D>();
		right = new EmptyBst<D>();
	}

	public NonEmptyBst(D elt, Tree<D> left, Tree<D> right) {
		data = elt;
		this.left = left;
		this.right = right;
	}

	public boolean isEmpty() {
		return false;
	}

	public int cardinality() {
		return 1 + left.cardinality() + right.cardinality();
	}

	@SuppressWarnings("unchecked")
	public boolean member(D elt) {
		if (data.equals(elt))
			return true;
		else {
			if (elt.compareTo(data) < 0)
				return left.member(elt);
			else
				return right.member(elt);
		}

	}

	@SuppressWarnings("unchecked")
	public NonEmptyBst<D> add(D elt){
		if(data.equals(elt))
			return this;
		else{
			if (elt.compareTo(data) < 0){
				System.out.println(elt+" is lesser than "+ data);
				return left.add(elt);
			}
			
			else{
				System.out.println(elt +" is greater than "+ data);
				return right.add(elt);
			}
				
		}
	}
}

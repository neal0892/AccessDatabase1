package binarysearchtree;

public interface Tree<D extends Comparable> {
	public boolean isEmpty();
	public int cardinality();
	public boolean member(D elt);
	public NonEmptyBst<D> add(D elt);
}

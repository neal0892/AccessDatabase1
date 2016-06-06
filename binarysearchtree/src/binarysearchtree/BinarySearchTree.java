package binarysearchtree;

public class BinarySearchTree {
	public static void main(String[] args) throws Exception{
		NonEmptyBst<Integer> trial = new NonEmptyBst<Integer>(20);
		System.out.println(trial.isEmpty());
		System.out.println(trial.cardinality());
		trial.add(22);
		trial.add(25);
		trial.add(27);
		System.out.println("finding 20 in tree: "+ trial.member(20));
		System.out.println("finding 22 in tree: "+ trial.member(22));
		System.out.println("finding 25 in tree: "+ trial.member(25));
		System.out.println("finding 27 in tree: "+ trial.member(27));
		
		System.out.println(trial.cardinality());


	}

}
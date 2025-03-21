public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.insert(77);
		list.insert(65);
		list.insert(77);
		list.insert(77);
		list.insert(99);
		list.delete(99);
		System.out.println(list);
		list.getLength();
		list.removeDuplicates();
		System.out.println(list);
	}
}

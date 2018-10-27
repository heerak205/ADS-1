class SequentialSearchST<Key, Value> {
	/**
	 * {no.of.key value pairs}.
	 */
	private int n;
	/**
	 * {linked list}.
	 */
	private Node first;
	private class Node {
		private Key key;
		private Value val;
		private Node next;
		public Node(Key key, Value val, Node next) {
			this.key  = key;
			this.val  = val;
			this.next = next;
		}
	}
	/**
	 * Constructs the object.
	 */
	public SequentialSearchST() {
	}
	/**
	 * {size method}.
	 *
	 * @return     {returns the no.of key value pairs}.
	 */
	public int size() {
		return n;
	}
	/**
	 * Determines if empty.
	 *
	 * @return     True if empty, False otherwise.
	 */
	public boolean isEmpty() {
		return size() == 0;
	}
	/**
	 * {contains method to check}.
	 *
	 * @param      key   The key
	 *
	 * @return     {returns true or false dependig on the existence}.
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}
	/**
	 * {get method}.
	 *
	 * @param      key   The key
	 *
	 * @return     {returns the value associated with the given key}.
	 */
	public Value get(Key key) {
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key))
				return x.val;
		}
		return null;
	}
	/**
	 * {inserts the specified key-value pair}.
	 *
	 * @param      key   The key
	 * @param      val   The value
	 */
	public void put(Key key, Value val) {
		if (val == null) {
			delete(key);
			return;
		}
		for (Node x = first; x != null; x = x.next) {
			if (key.equals(x.key)) {
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		n++;
	}
	/**
	 * {delete method to remove the specified key and its associated value}.
	 *
	 * @param      key   The key
	 */
	public void delete(Key key) {
		first = delete(first, key);
	}
	/**
	 * {method delete}.
	 *
	 * @param      x     .
	 * @param      key   The key
	 *
	 * @return     {deletes key in linked list beginning at Node x and returns}.
	 */
	private Node delete(Node x, Key key) {
		if (x == null) return null;
		if (key.equals(x.key)) {
			n--;
			return x.next;
		}
		x.next = delete(x.next, key);
		return x;
	}
	/**
	 * {keys method}.
	 *
	 * @return     {returns all the keys}.
	 */
	public Iterable<Key> keys()  {
		Queue<Key> queue = new Queue<Key>();
		for (Node x = first; x != null; x = x.next)
			queue.enqueue(x.key);
		return queue;
	}
}
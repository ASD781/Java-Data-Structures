public class DoublyLinkedList<T> {

	private ListNode<T> head,end,current;
	private int size;

	public DoublyLinkedList() {
		setAll(null);
		size= 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return (head==null);
	}

	public void getNext() {
		remove(0);
	}

	public ListNode get(int n) {
		if (n<0 || n>=size)
			throw new IndexOutOfBoundsException("Out of bounds!");
		ListNode<T> node= head;
		for (int i=0; i<n; i++)
			node= node.getNext();
		return node;
	}

	public ListNode<T> getHead() {
		return head;
	}

	//for DDLRunner.java
	public ListNode<T> getRoot() {
			return head;
	}

	public ListNode<T> getEnd() {
		return end;
	}

	public void add(T obj) {
		ListNode<T> node= new ListNode<T>(obj);
		if (size==0) {
			setAll(node);
		}
		else {
			ListNode<T> oldEnd= get(size-1);
			oldEnd.setNext(node);
			node.setPrevious(oldEnd);
			end= node;
		}

		size++;
	}

	public void add(int n, T obj) {
		ListNode<T> node= new ListNode<T>(obj);
		if (n==0) {
			ListNode<T> node1= get(0);
			node.setNext(node1);
			node1.setPrevious(node);
			head= node;
		}
		else if (n==size) {
			add(obj);
		}
		else {
			ListNode<T> node1= get(n-1);
			ListNode<T> node2= get(n);
			node1.setNext(node);
			node.setPrevious(node1);
			node.setNext(node2);
			node2.setPrevious(node);
		}

		size++;
	}

	public void remove(int n) {

		ListNode<T> removedNode= get(n);

		if (size==1) {
			setAll(null);
		}
		else if (size==2) {
			if (n==0) {
				ListNode<T> node2= get(1);
				node2.setPrevious(null);
				setAll(node2);
			}
			else {
				ListNode<T> node1= get(0);
				node1.setNext(null);
				setAll(node1);
			}
		}
		else {
			if (n==0) {
				ListNode<T> node1= get(1);
				node1.setPrevious(null);
				head= node1;
			}
			else if (n==(size-1)) {
				ListNode<T> node2= get(size-2);
				node2.setNext(null);
				end= node2;
			}
			else {
				ListNode<T> node1= get(n-1);
				ListNode<T> node2= get(n+1);
				node1.setNext(node2);
				node2.setPrevious(node1);
				if (n==1)
					head= node1;
				if (n==(size-2))
					end= node2;
			}
		}

		//removedNode.destroyLinks();
		size--;
	}

	public void clear() {
		while (size>0)
			remove(0);
	}

	public boolean contains(T obj) {
		for (int i=0; i<size; i++)
			if (get(i).getValue().equals(obj))
				return true;
		return false;
	}

	public void setAll(ListNode listNode) {
		head= listNode;
		end= listNode;
		current= null;
	}

	public String toString() {
		String str= "";
		if (size==0)
			str+="[]";
		else {
			ListNode<T> node= head;
			str+="[";
			while (node.getNext()!=null) {
				str+=node.getValue()+", ";
				node= node.getNext();
			}
			str+=node.getValue()+"]";
		}
		return str;
	}

	public String toReversedString() {
		String str= "";
		if (size==0)
			str+="null";
		else {
			ListNode<T> node= end;
			str+="[";
			while (node.getPrevious()!=null) {
				str+=node.getValue()+", ";
				node= node.getPrevious();
			}
			str+=node.getValue()+"]";
		}
		return str;
	}




}
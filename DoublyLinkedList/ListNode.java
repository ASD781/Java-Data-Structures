	public class ListNode <T> {

	private T value;
	private ListNode previous,next;
	public ListNode(T initValue) {
		value=initValue;
		previous=null;
		next=null;
	}
	public T getValue() {
		return value;
	}
	public int getIntValue() {
		return (Integer)value;
	}
	public ListNode getPrevious() {
		return previous;
	}
	public ListNode getNext() {
		return next;
	}
	public void setValue(T newValue) {
		value=newValue;
	}
	public void setPrevious(ListNode newPrevious) {
		previous=newPrevious;
	}
	public void setNext(ListNode newNext) {
		next=newNext;
	}
	public void destroyLinks() {
		next= null;
		previous= null;
	}
	public boolean hasPrevious() {
		return (previous!=null);
	}
	public boolean hasNext() {
		return (next!=null);
	}
	public String toString() {
		return value.toString();
	}
}

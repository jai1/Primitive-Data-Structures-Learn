package org.learn.interview;

public class BTNode<A extends Comparable> {
    BTNode<A> left, right;
    A data;

    public BTNode(A data){
        this.data = data;
    }

	@Override
	public String toString() {
		return "BTNode [ data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BTNode other = (BTNode) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}
	
	
    
}

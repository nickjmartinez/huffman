
public class MinHeap {
	private int size;
	private int n;
	private HuffTree heap[];

	public MinHeap() {
		size = 128;
		n= 0;
		heap = new HuffTree[size];
	}

	int getHeapSize() {
		return n;
	}
	
	//return position for left child of pos
	int leftchild(int pos) {
		//if (pos >= n/2) return -1;
		return 2*pos + 1;
	}

	// Return position for right child of pos
	int rightchild(int pos) {
		//if (pos >= (n-1)/2) return -1;
		return 2*pos + 2;
	}

	// Return position for parent
	int parent(int pos) {
		//if (pos <= 0) return -1;
		return (pos-1)/2;
	}

	void insert(HuffTree h) {
		int placeMeHere = 0;
		for(int i =0; i < heap.length; i++) {
			placeMeHere = i;
			if (heap[i] == null) {
				break;
			}
		}
		
		heap[placeMeHere] = h;
		if (n != 0) {
			int curr = placeMeHere;

			while(curr != 0) {
				int parentPos = parent(curr);
				HuffTree parent = heap[parentPos];
				if (h.compareTo(parent) < 0) {
					heap[parentPos] = h;
					heap[curr] = parent;
					curr = parentPos;
				}else {
					curr = 0;
				}
			}
		}
		n++;
	}

	HuffTree popMin() {
		HuffTree min = heap[0];
		n--;
		int curr = 0;

		while(true) {
			HuffTree left = heap[leftchild(curr)];
			HuffTree right = heap[rightchild(curr)];

			if (right == null && left == null) {
				heap[curr] = null;
				break;
			}else if(right == null) {
				heap[curr] = left;
				curr = leftchild(curr);
			}else if(left == null) {
				heap[curr] = right;
				curr = rightchild(curr);
			}else {
				if (left.compareTo(right) < 0) { 		//take left child
					heap[curr] = left;
					curr = leftchild(curr);
				}else {
					heap[curr] = right;
					curr = rightchild(curr);
				}
			}
		}

		return min;
	}

	HuffTree[] getHeap() {
		return heap;
	}

	HuffTree getRoot() {
		return heap[0];
	}
}

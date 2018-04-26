//The heap will be an array of Hufftrees!
public class MinHeap {
	private int size;			//max size of the minheap array
	private int n;				//number of items in heap
	private HuffTree heap[];	//heap array

	public MinHeap() {			//constructor
		size = 128;
		n= 0;
		heap = new HuffTree[size];
	}

	int getHeapSize() {			//return number of items in heap
		return n;
	}
	
	//Code in following block was used from OpenDSA
	/*------------------------------------------*/
	//return position for left child of pos
	int leftchild(int pos) {
		return 2*pos + 1;
	}

	// Return position for right child of pos
	int rightchild(int pos) {
		return 2*pos + 2;
	}

	// Return position for parent
	int parent(int pos) {
		return (pos-1)/2;
	}
	/*------------------------------------------*/

	void insert(HuffTree h) {
		int placeMeHere = 0;
		for(int i =0; i < heap.length; i++) {			//find first open spot in heap, break
			placeMeHere = i;
			if (heap[i] == null) {
				break;
			}
		}
		
		heap[placeMeHere] = h;							//place arg into heap
		if (n != 0) {									//cascade
			int curr = placeMeHere;

			while(curr != 0) {							//while we arent at the root
				int parentPos = parent(curr);			//find parent position
				HuffTree parent = heap[parentPos];		//make parent node
				if (h.compareTo(parent) < 0) {			//if current node is less than its parent node...
					heap[parentPos] = h;				//switch them
					heap[curr] = parent;
					curr = parentPos;					//go to parent's position and go again
				}else {
					curr = 0;							//if parent is less than current node, go to root as we are done
				}
			}
		}
		n++;
	}

	HuffTree popMin() {									//method to pop the root off min heap
		HuffTree min = heap[0];							//we are returning this
		
		int curr = 0;
		
		HuffTree left;
		HuffTree right;
		
		while(true) {									//cascade
			left = null;
			right = null;
			
			int leftNum = leftchild(curr);
			if (leftNum < 128) {						//if the child index is out of the max size, it's null
				 left = heap[leftchild(curr)];
			}
			
			int rightNum = rightchild(curr);
			
			if (rightNum < 128) {						//same as above
				right = heap[rightNum];				
			}
			

			if (right == null && left == null) {		//if no children, break
				heap[curr] = null;
				break;
			}else if(right == null) {					//if no right child, take left
				heap[curr] = left;
				curr = leftchild(curr);
			}else if(left == null) {					//if no left, take right
				heap[curr] = right;
				curr = rightchild(curr);
			}else {										//compare kids
				if (left.compareTo(right) < 0) { 		//take left child
					heap[curr] = left;
					curr = leftchild(curr);
				}else {									//take right
					heap[curr] = right;
					curr = rightchild(curr);
				}
			}
		}
		n--;											//we popped a node, decrease #
		return min;
	}

	HuffTree[] getHeap() {
		return heap;
	}

	HuffTree getRoot() {
		return heap[0];
	}
}

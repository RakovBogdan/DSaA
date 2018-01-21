package lafore.chapter02;

class OrdArray {

	private long[] a;
	private int nElems;

	public OrdArray(int max) {
		a = new long[max];
		nElems = 0;
	}

	public int size() {
		return nElems; 
	}


	public int find(long searchKey) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int curIn;
		
		while(true) {
			curIn = (lowerBound + upperBound ) / 2;
			if(a[curIn]==searchKey)
				return curIn;
			else if(lowerBound > upperBound)
				return nElems;
			else {
				if(a[curIn] < searchKey)
					lowerBound = curIn + 1;
				else
					upperBound = curIn - 1;
			} 
		} 
	} 

	public void insert(long value) {
		int lowerBound = 0;
		int upperBound = nElems - 1;
		int j = 0;
		while(true)
		{
			if(lowerBound > upperBound) break;
			j = (lowerBound + upperBound) / 2;
			if(value > a[j]) 
			{
				lowerBound = j + 1;
				j++;
			}
			else upperBound = j - 1;
		}
		for(int k=nElems; k>j; k--) // move bigger ones up
			a[k] = a[k-1];
		a[j] = value; // insert it
		nElems++;
	} 

	public boolean delete(long value) {
		int j = find(value);
		if(j==nElems)
			return false;
		else {
			for(int k=j; k<nElems; k++) 
				a[k] = a[k+1];
			nElems--;
			return true;
		}
	}

	public void display() {
		for(int j=0; j<nElems; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println("");
	}

	public long getValueAt(int index) {
		return a[index];
	}

	public void setValueAt(int index, long value) {
		a[index] = value;
		nElems++;
	}

	public static OrdArray merge(OrdArray ord1, OrdArray ord2) {
		int sizeOfSmaller = ord1.size();
		if(ord2.size() < ord1.size()) {
			sizeOfSmaller = ord2.size();
		}
		int sizeOfBoth = ord1.size() + ord2.size();
		OrdArray result = new OrdArray(sizeOfBoth); 

		int i=0;
		int j=0;
		int k=0;
		while(j < ord1.size() && k < ord2.size()) {
			if(ord1.getValueAt(j) < ord2.getValueAt(k)) {
				result.setValueAt(i, ord1.getValueAt(j));
				i++;
				j++;
				while(j < ord1.size() && ord1.getValueAt(j) < ord2.getValueAt(k)) {
						result.setValueAt(i, ord1.getValueAt(j));
						i++;
						j++;
				}
			} else {
				result.setValueAt(i, ord2.getValueAt(k));
				i++;
				k++;
				while(k < ord1.size() && ord2.getValueAt(k) < ord1.getValueAt(j)) {
						result.setValueAt(i, ord2.getValueAt(k));
						i++;
						k++;
				}
			}
		}
		if(j == ord1.size()) {
			while(k < ord2.size()) {
				result.setValueAt(i, ord2.getValueAt(k));
				i++;
				k++;
			}
		} else if(k == ord2.size()){
			while(j < ord1.size()) {
				result.setValueAt(i, ord1.getValueAt(j));
				i++;
				j++;
			}
		}

		return result;
	}
} 


class OrderedApp {

	public static void main(String[] args) {
		int maxSize = 100;
		OrdArray arr = new OrdArray(maxSize); 
		arr.insert(77);
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(0);
		arr.insert(66);
		arr.insert(33); 

		int searchKey = 55;
		if(arr.find(searchKey) != arr.size())
			System.out.println("Found " + searchKey);
		else
			System.out.println("Can’t find " + searchKey);

		arr.display(); 
		arr.delete(0);
		arr.delete(55);
		arr.delete(99); 
		arr.display();

		OrdArray arr1 = new OrdArray(100); 
		OrdArray arr2 = new OrdArray(100);
		for(int i=0; i<20; i++) {
			arr1.insert((long)(Math.random() * 200));
			arr2.insert((long)(Math.random() * 200)); 
		}
		arr1.display();
		arr2.display();

		OrdArray.merge(arr1, arr2).display();
	} 
} 
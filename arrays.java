//To list out all elements in an array
for(int i = 0; i < array.length; i++) {
	System.out.println(array[i]);
}

//To list out all elements in an arrayList
for(int i = 0; i < arrayList.size(); i++) {
	System.out.println(arrayList.get(i));
}

public int indexOf(String s) {
	//the following line is not valid
	if(array) {
		for(int i = 0; i < array.length; i++) {
			if(array[i] == s) {
				return i;
			}
		}
	}
	//the following line is not valid
	else if(arrayList) {
		for(int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i) == s) {
				return i;
			}
		}
	}
}
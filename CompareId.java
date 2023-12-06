package com.collection.pojo;

import java.util.Comparator;

public class CompareId implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
		//compareTo(
	}

}

package com.java.practice.geometry;

public class Rectangle extends Shape {
	public Rectangle() {
		super();
	}
	
	public Rectangle(int width, int height) {
		super(width,height);
	}
	
	public String toString() {
		return super.toString() + "\\Rectangle";
	}
	
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o.getClass() != Rectangle.class)
			return false;
		Rectangle temp = (Rectangle) o;
		if (this.width == temp.width
				&& this.height == temp.height)
			return true;
		return false;
	}
}

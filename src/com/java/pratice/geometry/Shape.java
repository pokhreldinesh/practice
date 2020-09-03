package com.java.pratice.geometry;

public class Shape {
	protected int width, height;
	
	public Shape() {
		this(1,1);
	}
	public Shape(int width, int height) {
		setWidth(width);
		setHeight(height);
	}
	public void setWidth(int width) {
		this.width = Math.max(width, 1);
	}
	public int getWidth() {
		return width;
	}
	public void setHeight(int height) {
		this.height = Math.max(height, 1);
	}
	public int getHeight() {
		return height;
	}
	public double getArea() {
		return width * height;
	}
	public double getPerimeter() {
		return 2 * (width + height);
	}
	public String toString() {
		return "(" + width + ", " + height + "), area = " + getArea() + ", perimeter = " + 
	getPerimeter() + ", type = Shape";
	}
	
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o.getClass() != Shape.class)
			return false;
		Shape temp = (Shape) o;
		if (this.width == temp.width
				&& this.height == temp.height)
			return true;
		return false;
	}

}

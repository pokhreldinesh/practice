package com.java.practice.geometry;

public class Triangle extends Shape{
	
	public Triangle() {
		super();
	}
	public Triangle(int width, int height) {
		super(width,height);
	}
	
	public double getArea() {
		return (width * height) / 2;
	}
	
	public double getPerimeter() {
		return width + 2 * Math.sqrt(width * width / 4 + height * height);
	}
	
	public String toString() {
		return super.toString() + "\\Triangle";
	}
	
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o.getClass() != Triangle.class)
			return false;
		Triangle temp = (Triangle) o;
		if (this.width == temp.width
				&& this.height == temp.height)
			return true;
		return false;
	}

}

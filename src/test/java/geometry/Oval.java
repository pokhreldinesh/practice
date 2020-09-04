package test.java.geometry;

public class Oval extends Shape {
	
	public Oval() {
		super();
	}

	public Oval(int width, int height) {
		super(width, height);
	}
	
	public String toString() {
		return super.toString() + "\\Oval";
	}
	
	public double getArea() {
		return width * height / 2 * Math.PI;
	}
	
	public double getPerimeter() {
		return Math.PI * Math.sqrt((width * width + height * height) / 2);
	}
}

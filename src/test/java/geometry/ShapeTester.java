package test.java.geometry;

public class ShapeTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s1 = new Shape();
		System.out.println("Shape s1: " + s1.toString());
		
		Shape s2 = new Shape(-10,-10);
		System.out.println("Shape s2: " + s2);
		
		Shape s3 = new Rectangle(10,15);
		System.out.println("Shape s3: " + s3);
		
		Shape s4 = new Triangle (10,20);
		System.out.println("Shape s4: " + s4);
		
		Rectangle r1 = new Rectangle(-1,5);
		System.out.println("Rectangle r1: " + r1);
		
		Triangle t1 = new Triangle(10,20);
		System.out.println("Triangle t1: " + t1.toString());
		
		Triangle t2 = new Triangle(10,20);
		System.out.println("Triangle t2: " + t2);
		
		System.out.println("s1 equals s2: " + s1.equals(s2));
		System.out.println("s4 equals t1: " + s4.equals(t1));
		System.out.println("r1 equals t2: " + r1.equals(t2));
		

	}

}

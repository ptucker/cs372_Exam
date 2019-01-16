
public class Circle extends interfaceShape{
	private int radius;
	private double area;
	private double perimeter;
	public Circle(String n, String id, int r, String color)
	{
		name = n;
		ID= id;
		radius =r;
		Color = color;
		area = 3.14*radius*radius;
		perimeter = 2* 3.14* radius;
	}
	//function to return all of the relevant information
	public String getDetailedString()
	{
		return String.format("Shape: %s\n ID: %s\n color: %s\n Area:  " + area + " \n Circumference: "+ perimeter + " \n Radius: " + radius, name, ID, Color);
	}
	
	public int getradius()
	{
		return radius;
	}
	public double getArea()
	{
		return area;
	}
	public double getPerimeter()
	{
		return perimeter;
	}
	
	//these can be ignored, they were an attempt at making a bunch of abstract functions in the parent class
	public int getside()
	{
		return 1;
	}

	@Override
	int getlength() {
		
		return 0;
	}

	@Override
	int getwidth() {
		
		return 0;
	}

	@Override
	int getside1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getside2() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	int getside3() {
		// TODO Auto-generated method stub
		return 0;
	}

}

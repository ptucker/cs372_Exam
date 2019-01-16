
public class Triangle extends interfaceShape{

	private int side1;
	private int side2;
	private int side3;
	private double area;
	private int Perimeter;
	private double p;
	private double areaformula;
	public Triangle(String n, String i, int s1, int s2, int s3, String c)
	{
		name = n;
		ID = i;
		side1=s1;
		side2=s2;
		side3=s3;
		Color=c;
		p= Perimeter/2;
		areaformula = p*(p-side1)*(p-side2)*(p-side3);
		area =  Math.sqrt(areaformula);
		Perimeter = side1+side2+side3;
	}
	public String getDetailedString()
	{
		String info = "Shape: " + name + " \n ID: "+ID + "\n side1: "+side1+ "\n side2: "+side2+  "\n Side3: " +side3+ "\n Area: " +area+"\n Perimeter: " +Perimeter+"\n Color: "+Color;
		return info;
	}
	public int getradius()
	{
		return 0;
	}
	public double getArea()
	{
		return area;
	}
	public double getPerimeter()
	{
		return Perimeter;
	}
	public int getside()
	{
		return 1;
	}
	//these can be ignored
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
		return side1;
	}
	@Override
	int getside2() {
		
		return side2;
	}
	@Override
	int getside3() {
		
		return side3;
	}

}

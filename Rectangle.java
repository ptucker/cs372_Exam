
public class Rectangle extends interfaceShape{

	private int length;
	private int width;
	private int area;
	private int perimeter;
	
	public Rectangle(String n, String i, int h, int w, String c)
	{
		name = n;
		ID = i;
		length = h;
		width = w;
		Color = c;
		area = length*width;
		perimeter = 2*(length + width);
	}
	public String getDetailedString()
	{
		String info = "Shape: " + name + " \n ID: "+ID + "\n length: "+length+ "\n Width: "+width+ "\n Area: " +area+"\n perimeter" +perimeter+"\n Color: "+Color;
		return info;
	}
	public int getradius()
	{
		return 1;
	}
	public double getArea()
	{
		return area;
	}
	public double getPerimeter()
	{
		return perimeter;
	}
	
	//these can be ignored
	public int getside()
	{
		return 1;
	}
	@Override
	int getlength() {
		return length;
	}
	@Override
	int getwidth() {
		// TODO Auto-generated method stub
		return width;
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

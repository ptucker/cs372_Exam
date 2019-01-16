
public class Square extends interfaceShape{

	private int side;
	private int area;
	private int perimeter;
	
	public Square(String n, String i, int s, String c)
	{
		name = n;
		ID = i;
		side = s;
		Color = c;
		area = side*side;
		perimeter = 4*side;
	}
	public String getDetailedString()
	{
		return String.format("Shape: %s\n ID: %s\n Side: %d\n Area: %d\n Perimeter: %d\n Color: %s", name, ID, side, area, perimeter, Color);
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
	public int getside()
	{
		return side;
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

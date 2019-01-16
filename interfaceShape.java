
public abstract class interfaceShape {

		protected String name;
		protected String ID;
		protected String Color;
		
		public interfaceShape() {
			name = "square";
			ID = "1";
			Color = "red";
		}
		//overwritten toString function to return the name and id of the shape
		public String toString()
		{
			return String.format("%s (%s)", name, ID);
		}
		//generic getfunctions
		public String getKind()
		{
			return name;
		}
		
		public String getID() 
		{
			return ID;
		}
		public String getColor() 
		{
			return Color;
		}
		abstract int getradius();
		abstract double getArea();
		abstract double getPerimeter();
		abstract int getside();
		abstract int getlength();
		abstract int getwidth();
		abstract int getside1();
		abstract int getside2();
		abstract int getside3();
		abstract String getDetailedString();
	
}

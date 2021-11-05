import pkg.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

public class starter implements InputControl, InputKeyControl {
	static Line vector;
	static Rectangle rectRotate;
	
	public static void main(String args[]) {
		// please leave following line alone, necessary for keyboard/mouse input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
		
		Random rand = new Random();
		boolean d1 = false;
		boolean d2 = false;
		boolean d3 = false;
		double pointX = 100;
		double pointY = 150;
		double originX = pointX;
		double originY = 100;
		double tempX,tempY;
		double angle = 0.1;
		double useless;
		int colorCounter1 = rand.nextInt(255);
		int colorCounter2 = rand.nextInt(254);
		int colorCounter3 = rand.nextInt(253);
		vector = new Line(originX,originY, pointX,pointY);
		rectRotate = new Rectangle(pointX,pointY, 10,10);
		vector.draw();
		rectRotate.draw();
		Ellipse origin = new Ellipse(originX-10,originY-10, 20,20);
		Color oC = new Color(255,0,0);
		origin.setColor(oC);
		origin.fill();
		for(int i=0;i>=0;i++) {
			useless = i/2;
			if(!d1) {colorCounter1++;}
			if(!d2) {colorCounter2++;}       
			if(!d3) {colorCounter3++;}
			
			if(colorCounter1>254) {colorCounter1 = 254;d1=true;}
			if(colorCounter2>254) {colorCounter2 = 254;d2=true;}   //these if statements are so stupid
			if(colorCounter3>254) {colorCounter3 = 254;d3=true;}
			
			if(d1) {colorCounter1--;}
			if(d2) {colorCounter2--;}
			if(d3) {colorCounter3--;}
			
			if(colorCounter1<1) {colorCounter1 = 0;d1=false;}
			if(colorCounter2<1) {colorCounter2 = 0;d2=false;}     //all of them
			if(colorCounter3<1) {colorCounter3 = 0;d3=false;}
			
			tempX = ((pointX-originX) * Math.cos(angle)) - ((pointY-originY) * Math.sin(angle))+originX;
			tempY = ((pointX-originX) * Math.sin(angle)) + ((pointY-originY) * Math.cos(angle))+originY;
			pointX = tempX;
			pointY = tempY;
			oC = new Color(colorCounter1,colorCounter2,colorCounter3);
			vector.setCoordB(pointX+useless,pointY+useless);
			rectRotate = new Rectangle(pointX+useless,pointY+useless, 20,20);
			rectRotate.setColor(oC);
			vector.draw();
			rectRotate.fill();
			Canvas.pause(10);
		}
	}

	public void onMouseClick(double x, double y) {
		// enter code here

	}

	public void keyPress(String s) {
		// enter code here

	}
}

import pkg.*;
import java.util.ArrayList;
import java.lang.Math;

public class starter implements InputControl, InputKeyControl {
	static Line vector;
	static Rectangle rectRotate;
	
	public static void main(String args[]) {
		// please leave following line alone, necessary for keyboard/mouse input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
		
		double pointX = 400;
		double pointY = 200;
		double originX = 150;
		double originY = 150;
		double tempX,tempY;
		double angle = 0.1;
		int colorCounter1 = 0;
		int colorCounter2 = 50;
		int colorCounter3 = 100;
		vector = new Line(originX,originY, pointX,pointY);
		rectRotate = new Rectangle(pointX,pointY, 10,10);
		vector.draw();
		rectRotate.draw();
		Ellipse origin = new Ellipse(originX-10,originY-10, 20,20);
		Color oC = new Color(255,0,0);
		origin.setColor(oC);
		origin.fill();
		for(int i=0;i<500;i++) {
			colorCounter1++;
			colorCounter2++;
			colorCounter3++;
			if(colorCounter1>254) {colorCounter1 = 0;}
			if(colorCounter2>254) {colorCounter2 = 0;}
			if(colorCounter3>254) {colorCounter3 = 0;}
			tempX = ((pointX-originX) * Math.cos(angle)) - ((pointY-originY) * Math.sin(angle))+originX;
			tempY = ((pointX-originX) * Math.sin(angle)) + ((pointY-originY) * Math.cos(angle))+originY;
			pointX = tempX;
			pointY = tempY;
			oC = new Color(colorCounter1,colorCounter2,colorCounter3);
			vector.setCoordB(pointX+i,pointY+i);
			rectRotate = new Rectangle(pointX+i,pointY+i, 20,20);
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

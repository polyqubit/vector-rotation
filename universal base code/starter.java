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
		double pointX = 100;
		double pointY = 150;
		double originX = pointX;
		double originY = 100;
		double tempX,tempY;
		double angle = 0.1;
		double useless;
		int colorCounter1 = 0;
		int colorCounter2 = 150;
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
			useless = i/2;
			colorCounter1 += rand.nextInt(5)+1;
			colorCounter2 += rand.nextInt(5)+1;
			colorCounter3 += rand.nextInt(5)+1;
			if(colorCounter1>254) {colorCounter1 = 0;}
			if(colorCounter2>254) {colorCounter2 = 0;}
			if(colorCounter3>254) {colorCounter3 = 0;}
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

import pkg.*;
import java.util.ArrayList;
import java.lang.Math;

public class starter implements InputControl, InputKeyControl {
	static Line vector;
	
	public static void main(String args[]) {
		// please leave following line alone, necessary for keyboard/mouse input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
		
		double pointX = 400;
		double pointY = 50;
		double originX = 300;
		double originY = 250;
		double tempX,tempY;
		double angle = 1;
		vector = new Line(originX,originY, pointX,pointY);
		vector.draw();
		Ellipse origin = new Ellipse(originX-10,originY-10, 20,20);
		Color oC = new Color(255,0,0);
		origin.setColor(oC);
		origin.fill();
		while(true) {
			tempX = ((pointX-originX) * Math.cos(angle)) - ((pointY-originY) * Math.sin(angle))+originX;
			tempY = ((pointX-originX) * Math.sin(angle)) + ((pointY-originY) * Math.cos(angle))+originY;
			pointX = tempX;
			pointY = tempY;
			vector = new Line(originX,originY, pointX,pointY);
			vector.draw();
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

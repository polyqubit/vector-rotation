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
		double tempX,tempY;
		double angle = 1;
		vector = new Line(400,300, pointX,pointY);
		vector.draw();
		Ellipse origin = new Ellipse(390,290, 20,20);
		Color oC = new Color(255,0,0);
		origin.setColor(oC);
		origin.fill();
		while(true) {
			tempX = (pointX * Math.cos(angle)) - (pointY * Math.sin(angle))+400;
			tempY = (pointX * Math.sin(angle)) + (pointY * Math.cos(angle));
			pointX = tempX;
			pointY = tempY;
			vector = new Line(400,50, pointX,pointY);
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

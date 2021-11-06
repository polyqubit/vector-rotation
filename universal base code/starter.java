import pkg.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

public class starter implements InputControl, InputKeyControl {
	static Line vector;
	static Ellipse eRot;
	
	public static void main(String args[]) {
		// please leave following line alone, necessary for keyboard/mouse input
		KeyController kC = new KeyController(Canvas.getInstance(),new starter());
		MouseController mC = new MouseController(Canvas.getInstance(),new starter());
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter mode(circle, spiral)");
		String inp = sc.nextLine();
		boolean tar = false;
		if(inp.equals("circle")) {tar = true;}
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
		eRot = new Ellipse(pointX-5,pointY-5, 10,10);
		//vector.draw();
		eRot.draw();
		//Ellipse origin = new Ellipse(originX-10,originY-10, 20,20);
		Color oC = new Color(255,0,0);
		//origin.setColor(oC);
		//origin.fill();
		for(int i=0;i>=0;i++) {
			useless = i/25;
			if(!d1) {colorCounter1++;}
			if(!d2) {colorCounter2+=2;}       
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
			if(tar) {
				//vector.setCoordB(pointX,pointY);
				eRot = new Ellipse(pointX-5,pointY-5, 20,20);
			}
			else {
				//vector.setCoordB(pointX+useless,pointY+useless);
				eRot = new Ellipse(pointX+useless-5,pointY+useless-5, 20,20);
			}
			eRot.setColor(oC);
			//vector.draw();
			eRot.fill();
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

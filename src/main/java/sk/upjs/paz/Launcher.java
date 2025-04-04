package sk.upjs.paz;

import sk.upjs.jpaz2.*;

import java.util.Arrays;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		//WinPane sandbox = new AnimatedWinPane();
		WinPane sandbox = new WinPane();

		// create new turtle and add it to the "sandbox"
		Turtle franklin = new Turtle();
		//sandbox.add(franklin);

		// create new object inspector
		//ObjectInspector oi = new ObjectInspector();
		// ask the inspector to inspect "franklin" and "sandbox"
		//oi.inspect(franklin);
		//oi.inspect(sandbox);

		FraktarTurtle jozef = new FraktarTurtle();
		sandbox.add(jozef);
		//jozef.ciara();
		//jozef.vlocka(3,100);
		//int [] pole = {1,30,2,130,7,0};
		//System.out.println(Cvicenie.jeUsporiadane);
		//System.out.println(Cvicenie.binarneHladajIndex(pole,4));
		//BubbleSort b = new BubbleSort();
		//nie je to staticka klasa taze treba objekt
		//b.utried(pole);
		//System.out.println(Arrays.toString(pole));
		//int [] p1 = {1,30,2,130,7,0};
		//
		//SelectionSort S = new SelectionSort();
		//S.utried(p1);
		//yadavam pole metoda si yisti dlzku
		//pri buble sorte zalezi na poradi cisel
		//selection sort ma rovnaky pocet vymen
		//5 prvkove pole kedy urobi najmenej krokov ak je pole uz utriedene
		//najviac ked je vzorstupne
		//zistit ktore vstupy budu do 5 sekund
		//jozef.stvorec(3,70);
		//jozef.divnyStvorec(3,70);
		//jozef.fraktal(3,70);

		//jozef.mriezka(3,70);
		//jozef.stvorec2(3,70);
		//jozef.stvorec2(30,70);


	}
}
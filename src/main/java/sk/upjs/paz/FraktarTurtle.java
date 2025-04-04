package sk.upjs.paz;

import sk.upjs.jpaz2.Turtle;

public class FraktarTurtle extends Turtle {


    public void vlocka(int uroven, double rozmer){
        if (uroven==0){
          return;
        }

            for (int i = 0; i < 6; i++) {
                this.step(rozmer);
                //urobi sa krok
                this.vlocka(uroven - 1, rozmer/3);
                //zavola sa rovnaka metoda ale vykresli sa mensia ciara
                //metoda sa vola az kym uroven nie je jedna potom sa dokonci kod
                this.step(-rozmer);
                this.turn(60);
                //az ked je uroven = 0 tak sa bude otacat a potom sa bude vracat postupne o uroven vyssie
        }
    }


    public void mriezka(int uroven, double rozmer){

        if (uroven==0){
            return;
        }

        for (int i= 0; i < 4; i++){

        }
    }



    public void stvorec(int uroven, double rozmer){

        if (uroven==0){
            return;
        }

        for (int i= 0; i<4 ; i++){

            this.step(rozmer);
            this.turn(90);
            stvorec(uroven-1,rozmer/4);
            this.turn(180);

        }

    }

    public void divnyStvorec(int uroven,double rozmer){

        if (uroven==0){
            return;
        }

        for (int i = 0; i < 4; i++) {

        }
    }

    public void stvorec2(int uroven,double rozmer){

        if (uroven==0){
            return;
        }

        for (int i=0; i<4;i++){

            this.step(rozmer/3);
            this.turn(-90);
            stvorec2(uroven-1,rozmer/3);
            step(rozmer*2/3);
            turn(90);
        }
    }



}

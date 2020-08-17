import objectdraw.FilledOval;
import objectdraw.FilledRect;
import objectdraw.Location;
import objectdraw.WindowController;

import java.awt.*;

public class Broomball extends WindowController {
    private final int BROOM_SIZE = 20;
    private final int DUST_SIZE = 35;

    private FilledOval Broom;
    private FilledRect Dust;

    public void begin(){

        Broom = new FilledOval(170, 190, BROOM_SIZE, BROOM_SIZE,Color.BLACK, canvas );

        Dust = new FilledRect(100, 70, DUST_SIZE, DUST_SIZE, Color.GREEN, canvas);


    }

    public boolean isAbove (){

       if(Broom.getY() < Dust.getY() && Broom.overlaps(Dust)) {

           return true;

       }
       return false;
    }

    public boolean isBelow (){

        if(Broom.getY() > Dust.getY() && Broom.overlaps(Dust)) {

            return true;

        }
        return false;
    }

    public boolean isLeft (){

        if(Broom.getX() < Dust.getX() && Broom.overlaps(Dust)) {

            return true;

        }
        return false;
    }

    public boolean isRight (){

        if(Broom.getX() > Dust.getX() && Broom.overlaps(Dust)) {

            return true;

        }
        return false;
    }

    public void onMouseDrag(Location point) {
        //Point where we move the Broom to.
      Broom.moveTo(point);

      if(isAbove()) {
          Dust.moveTo(Dust.getX(), Dust.getY() + 3);
      }

        if(isBelow()) {
            Dust.moveTo(Dust.getX(), Dust.getY() - 3);
        }

        if(isLeft()) {
            Dust.moveTo(Dust.getX() + 3, Dust.getY() );
        }

        if(isRight()) {
            Dust.moveTo(Dust.getX() - 3, Dust.getY() );
        }
    }

    public void onMousePress(Location point){

    Broom.moveTo(point);
    Broom.show();

    }

    public void onMouseRelease(Location point){

        Broom.hide();
    }

    public void onMouseExit(Location point){

        Dust.hide();
        Dust = null; //Delete the location where where Dust was, so that we'r freeing up space.
        Dust = new FilledRect(100, 70, DUST_SIZE, DUST_SIZE, Color.GREEN, canvas);
        Dust.show();
    }
    public static void main(String[] args) {
        new Broomball().startController(400,400);

    }
}

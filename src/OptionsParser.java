package agh.ics.oop;
import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parse(String[] litery){

        String[] acceptable = {"f","forward","r","right","b","backward","l","left"};

        for(String i:litery){
            if(!Arrays.asList(acceptable).contains(i))
                throw new IllegalArgumentException(i + " is illegal");
        }

        MoveDirection[] output = new MoveDirection[litery.length];
        int k =0;
        for(String i : litery){
            switch(i){
                case "f": case "forward":
                    output[k] = MoveDirection.FORWARD;
                    k++;
                    break;
                case "r": case "right":
                    output[k] = MoveDirection.RIGHT;
                    k++;
                    break;
                case "b": case "backward":
                    output[k] = MoveDirection.BACKWARD;
                    k++;
                    break;
                case "l": case "left":
                    output[k] = MoveDirection.LEFT;
                    k++;
                    break;
            }

        }
        MoveDirection[] output2 = new MoveDirection[k];
        for (int ii=0;ii<k;ii++){
            output2[ii] = output[ii];
        }
        return output2;
    }
}

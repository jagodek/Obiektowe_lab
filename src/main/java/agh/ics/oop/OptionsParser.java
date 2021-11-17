package agh.ics.oop;

public class OptionsParser {
    public MoveDirection[] parse(String[] litery){
        MoveDirection[] output = new MoveDirection[litery.length];
        int k =0;
        for(String i : litery){
            String iUp = i.toLowerCase();
            switch(iUp){
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

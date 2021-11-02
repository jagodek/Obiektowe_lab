package agh.ics.oop;

public class OptionParsers {
    public MoveDirection[] parse(String[] hmm){
        MoveDirection[] output = new MoveDirection[hmm.length];
        int k =0;
        for(String i : hmm){
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

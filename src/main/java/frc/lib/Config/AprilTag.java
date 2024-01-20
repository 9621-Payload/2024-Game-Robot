package frc.lib.Config;

public class AprilTag {
    //When number is 1 team colour is blue, and 0 is team red
    private static int _teamSelected = 1;
    public static int TeamSelected() {
        return _teamSelected;
    }

    //Get the different tag ids based on selected team
    public static int humanPlayerLeft() {
        if (_teamSelected == 1) {
            return 2;
        } else {
            return 10;
        }
    }
    public static int humanPlayerRight() {
        if (_teamSelected == 1) {
            return 1;
        } else {
            return 9;
        }
    }
    public static int amp(){
        if(_teamSelected == 1) {
            return 6;
        } else {
            return 5;   
        }
    }
    public static int stageLeft() {
        if(_teamSelected == 1){
            return 15;
        } else {
            return 11;
        }
    }
    public static int stageRight() {
        if(_teamSelected == 1){
            return 16;
        } else {
            return 12;
        }
    }
    public static int stageBack() {
        if(_teamSelected == 1){
            return 14;
        } else {
            return 13;
        }
    }
    public static int speakerCenter() {
        if(_teamSelected == 1) {
            return 7;
        } else {
            return 4;
        }
    }
}

import jm.JMC;
import jm.music.data.*;
import jm.util.*;
import java.util.*;

public class LabC {
    public static void main(String[] args) {

        //Declare all notes I will use
        Note e5sx = new Note(76, JMC.EN * 0.5); //E5 1/16
        Note d5Ssx = new Note(75, JMC.EN * 0.5); //D#5 1/16
        Note d5sx = new Note(74, JMC.EN*0.5); //D5 1/16
        Note c5sx = new Note(72, JMC.EN * 0.5); //C5 1/16
        Note c5e = new Note(72, JMC.EN); //C5 1/8
        Note b4sx = new Note(71, JMC.EN * 0.5); //B4 1/16
        Note b4e = new Note(71, JMC.EN); //B4 1/8
        Note a4sx = new Note(69, JMC.EN * 0.5); //A4 1/16
        Note a4e = new Note(69, JMC.EN); //A4 1/8
        Note g4Ssx = new Note(68, JMC.EN*0.5); //G4# 1/16
        Note e4sx = new Note(64, JMC.EN * 0.5); //E4 1/16
        Note c4sx = new Note(60, JMC.EN * 0.5); //C4 1/16 (Middle C)
        Note a3sx = new Note(57, JMC.EN * 0.5); //A3 1/16
        Note g3Ssx = new Note(56, JMC.EN*0.5); //G3# 1/16
        Note e3sx = new Note(52, JMC.EN*0.5); //E3 1/16
        //Note c3sx = new Note(48, JMC.EN * 0.5); //C3 1/16
        //Note a2sx = new Note(45, JMC.EN * 0.5); //A2 1/16

        //Create array of song (1st measure of Fur Elise)
        Note[] FurElise = List.of(
                e5sx, d5Ssx, e5sx, d5Ssx, e5sx, b4sx, d5sx, c5sx, a4e, e3sx, a3sx,
                c4sx, e4sx, a4sx, b4e, e3sx, g3Ssx, e4sx, g4Ssx, b4sx, c5e, e3sx,
                a3sx, e4sx, e5sx, d5Ssx, e5sx, d5Ssx, e5sx, b4sx, d5sx, c5sx, a4e
        ).toArray(Note[]::new);

        var phrase = new Phrase(FurElise); //put the list of notes into a phrase
        var part = new Part(phrase); //turn the phrase into a part
        var score = new Score(part, "Fur Elise", 50.0); //turn the part into a score

        Play.midi(score); //play the score
    }
}

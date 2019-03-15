package model;

import java.util.*;

import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

public class State implements Constant {
    
    private Score music;
    
    public State(Score music) {
        this.music = music;
    }
    
    public State() {
        this.music = this.initialization();
    }
    
    public Score getMusic() {
        return this.music;
    }
    
    public String toString() {
        return this.music.toString();
    }
    
    public Score initialization() {
        //tmp
        Phrase phrase1 = new Phrase();
        phrase1.add(new Note(1, 1));//1
        phrase1.add(new Note(2, 1));//2
        
        Part part1 = new Part(phrase1);
        part1.setInstrument(0);
        
        Phrase phrase2 = new Phrase();
        phrase2.add(new Note(11, 1));//1
        phrase2.add(new Note(12, 1));//2
        Part part2 = new Part(phrase2);
        part2.setInstrument(10);
        
        Score score = new Score(part1);
        score.addPart(part2);
        
        return score;
    }
    
    public Score generateNextNotes() {
        Score score = new Score();
        for (Part part: this.music.getPartArray()) {
            Part partTmp = new Part();
            for (Phrase phrase: part.getPhraseArray()) {
                PhraseMatrix matrix = new PhraseMatrix(phrase, PATTERN);
                Phrase nextNotes = matrix.generate(true, true, true, NUMBER_NOTES_GENERATE);
                
                partTmp.addPhrase(nextNotes);
            }
            
            partTmp.setInstrument(part.getInstrument());
            score.addPart(partTmp);
        }
        return score;
    }
    
    public State concatenate(Score nextNotes) {
        Score next = new Score(this.music.getPartArray());
        for (int i=0; i<next.getPartArray().length; i++) {
            for (int j=0; j<next.getPartArray()[i].getPhraseArray().length; j++) {
                next.getPartArray()[i].getPhraseArray()[j].addNoteList(nextNotes.getPartArray()[i].getPhraseArray()[j].getNoteArray());
            }
        }
        return new State(next);
    }
    
    public void save(String name) {
        Write.midi(this.music, name+".mid");
    }
}
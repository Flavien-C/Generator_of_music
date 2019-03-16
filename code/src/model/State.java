package model;

import java.util.*;

import jm.music.data.*;
import jm.music.tools.*;
import jm.util.*;

/**

*/

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
    
    public void setMusic(Score music) {
        this.music = music;
    }
    
    public String toString() {
        return this.music.toString();
    }
    
    /**
    permet de generer de maniere aleatoire le debut d'une musique
    */
    /**
    Genere aleatoirement le 
    */
    public Score initialization() {
        Score init = new Score();
        for (int nbInst=0; nbInst<NUMBER_INSTRUMENT; nbInst++) {
            Part inst = new Part((int)(Math.random()*127));
            Phrase phr = new Phrase();
            for (int i=0; i<FIRST_NOTES; i++) {
                Note note = new Note((int)(Math.random()*127),
                                     (Math.random()*4));
                phr.addNote(note);
            }
            inst.addPhrase(phr);
            init.addPart(inst);
        }
        return init;
    }
    
    /**
    genere les notes suivantes d'une musique en fonction d'une chaine de markov
    */
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
    
    /**
    concatene la musique courante avec les notes generees par la chaine de markov
    */
    public State concatenate(Score nextNotes) {
        if (this.music.getPartArray().length == 0) {
            return new State(nextNotes);
        }
        Score next = new Score(this.music.getPartArray());
        for (int i=0; i<next.getPartArray().length; i++) {
            for (int j=0; j<next.getPartArray()[i].getPhraseArray().length; j++) {
                next.getPartArray()[i].getPhraseArray()[j].addNoteList(nextNotes.getPartArray()[i].getPhraseArray()[j].getNoteArray());
            }
        }
        return new State(next);
    }
    
    /**
    permet de sauvegarder sur le disque dur la musique actuelle
    */
    public void save(String name) {
        Write.midi(this.music, name+".mid");
    }
}
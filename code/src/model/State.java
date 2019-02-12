package model;

import java.util.*;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

/*
Un etat represente la musique a l'instant t
Il va generer des etats possibles en utilisant la chaine de markov
*/
public class State {
    
    private Score music;
    
    
    public State(Score music) {
        this.music = music;
    }
    
    public State() {
        this(null);
    }
    
    public Score getMusic() {
        return this.music;
    }
    
    public String toString() {
        return this.music.toString();
    }
    
    /*
    Permet de sauvegarder sur le DD l'etat actuel
    */
    public void save(String name) {
        Write.midi(this.music, name+".mid");
    }
}
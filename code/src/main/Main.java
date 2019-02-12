package main;

import model.*;
import vc.*;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class Main {
    
    public static void main(String[] args) {
        Phrase phrase = new Phrase();
        for (int i=0; i<10; i++) {
            Note n = new Note();
            phrase.add(n);
        }
        Part part = new Part(phrase);
        Score score = new Score(part);
        
        State state = new State(score);
        
        //System.out.println(state);
        //state.save("test");
        
    }
}
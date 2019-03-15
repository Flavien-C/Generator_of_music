package main;

import model.*;

import jm.JMC;
import jm.music.data.*;

public class Main implements JMC {
    
    public static void main(String[] args) {
        State state = new State();
        
        //state.save("test");
        
        //System.out.println(state);
        Score next = state.generateNextNotes();
        System.out.println(state.concatenate(next));
        
    }
}
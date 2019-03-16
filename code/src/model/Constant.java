package model;

public interface Constant {
    
    /**
    nombre de note a utiliserpour l'analyse de markov
    */
    public static final int PATTERN = 1;
    
    /**
    nombre de note genere par la chaine de markov
    */
    public static final int NUMBER_NOTES_GENERATE = 5;
    
    /**
    nombre d'instrument utilises dans la musique
    */
    public static final int NUMBER_INSTRUMENT = (int)((Math.random() * 2) +2);
    
    /**
    nombre de note genere pour le premier etat
    */
    public static final int FIRST_NOTES = 20;
}
package vc;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URISyntaxException;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public class FrameGUI extends JFrame implements ActionListener, JMC{
    
    private State stateLead;
    private State state1;
    private State state2;
    private State state3;
    private State state4;
    private Boolean occupied;
    //variable d'interface
    private JMenuBar  menuBar;
    private JMenu option;
    private JMenuItem exit;
    //panel
    private JPanel contenu;
    private JPanel panelPrincipal;
    //les différents lecteurs
    private JPanel lecLead;
    private JPanel lec1;
    private JPanel lec2;
    private JPanel lec3;
    private JPanel lec4;
    //label
    private JLabel titleLead;
    private JLabel title1;
    private JLabel title2;
    private JLabel title3;
    private JLabel title4;
    //les slides
    private JSlider slideLead;
    private JSlider slide1;
    private JSlider slide2;
    private JSlider slide3;
    private JSlider slide4;
    //bouton lecteur Lead
    private JButton playLead;
    private JButton pauseLead;
    private JButton stopLead;
    private JButton saveLead;
    //bouton lecteur 1
    private JButton play1;
    private JButton pause1;
    private JButton stop1;
    private JButton add1;
    //bouton lecteur 2
    private JButton play2;
    private JButton pause2;
    private JButton stop2;
    private JButton add2;
    //bouton lecteur 3
    private JButton play3;
    private JButton pause3;
    private JButton stop3;
    private JButton add3;
    //bouton lecteur 4
    private JButton play4;
    private JButton pause4;
    private JButton stop4;
    private JButton add4;
    
    
    public FrameGUI() throws URISyntaxException {
        super("Generateur de Musique");//nom de la Frame
        this.stateLead = new State(new Score());//State principal
        this.state1 = new State();
        this.state2 = new State();
        this.state3 = new State();
        this.state4 = new State();
        //enregistrement du state
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.contenu = (JPanel) this.getContentPane();
        this.contenu.setLayout(new BorderLayout(4,4));
        this.setPreferredSize(new Dimension(1000, 700));
        //___________________________ menu _____________________________
        menuBar = new JMenuBar();
        option = new JMenu("Option");
        exit = new JMenuItem("exit");
        option.add(exit);
        menuBar.add(option);
        this.setJMenuBar(menuBar);
        exit.addActionListener(this);
        //________________________________________________________________
        panelPrincipal = new JPanel();
        lecLead = new JPanel();
        lec1 = new JPanel();
        lec2 = new JPanel();
        lec3 = new JPanel();
        lec4 = new JPanel();
        titleLead = new JLabel("Piste de composition : LEAD");
        title1 = new JLabel("Piste generee numero 1");
        title2 = new JLabel("Piste generee numero 2");
        title3 = new JLabel("Piste generee numero 3");
        title4 = new JLabel("Piste generee numero 4");
        slideLead = new JSlider(0, 100, 0);
        slide1 = new JSlider(0, 100, 0);
        slide2 = new JSlider(0, 100, 0);
        slide3 = new JSlider(0, 100, 0);
        slide4 = new JSlider(0, 100, 0);
        playLead = new JButton("PLAY");
        pauseLead = new JButton("PAUSE");
        stopLead = new JButton("STOP");
        saveLead = new JButton("SAUVEGARDER");
        play1 = new JButton("PLAY");
        pause1 = new JButton("PAUSE");
        stop1 = new JButton("STOP");
        add1 = new JButton("AJOUTER A LA PISTE");
        play2 = new JButton("PLAY");
        pause2 = new JButton("PAUSE");
        stop2 = new JButton("STOP");
        add2 = new JButton("AJOUTER A LA PISTE");
        play3 = new JButton("PLAY");
        pause3 = new JButton("PAUSE");
        stop3 = new JButton("STOP");
        add3 = new JButton("AJOUTER A LA PISTE");
        play4 = new JButton("PLAY");
        pause4 = new JButton("PAUSE");
        stop4 = new JButton("STOP");
        add4 = new JButton("AJOUTER A LA PISTE");
        
        playLead.addActionListener(this);
        pauseLead.addActionListener(this);
        stopLead.addActionListener(this);
        saveLead.addActionListener(this);
        play1.addActionListener(this);
        pause1.addActionListener(this);
        stop1.addActionListener(this);
        add1.addActionListener(this);
        play2.addActionListener(this);
        pause2.addActionListener(this);
        stop2.addActionListener(this);
        add2.addActionListener(this);
        play3.addActionListener(this);
        pause3.addActionListener(this);
        stop3.addActionListener(this);
        add3.addActionListener(this);
        play4.addActionListener(this);
        pause4.addActionListener(this);
        stop4.addActionListener(this);
        add4.addActionListener(this);
        //_____________________________________________________________
        lecLead.setBackground(Color.BLUE);
        lecLead.setLayout(new FlowLayout());
        lecLead.setPreferredSize(new Dimension(900, 200));
        lec1.setBackground(Color.GREEN);
        lec1.setLayout(new FlowLayout());
        lec1.setPreferredSize(new Dimension(450, 100));
        lec2.setBackground(Color.ORANGE);
        lec2.setLayout(new FlowLayout());
        lec2.setPreferredSize(new Dimension(450, 100));
        lec3.setBackground(Color.RED);
        lec3.setLayout(new FlowLayout());
        lec3.setPreferredSize(new Dimension(450, 100));
        lec4.setBackground(Color.BLACK);
        lec4.setLayout(new FlowLayout());
        lec4.setPreferredSize(new Dimension(450, 100));
        //_______________________ add objet ans les lecteurs
        lecLead.add(titleLead);
        lec1.add(title1);
        lec2.add(title2);
        lec3.add(title3);
        lec4.add(title4);
        slideLead.setPreferredSize(new Dimension(850, 25));
        slide1.setPreferredSize(new Dimension(400, 25));
        slide2.setPreferredSize(new Dimension(400, 25));
        slide3.setPreferredSize(new Dimension(400, 25));
        slide4.setPreferredSize(new Dimension(400, 25));
        lecLead.add(slideLead);
        lec1.add(slide1);
        lec2.add(slide2);
        lec3.add(slide3);
        lec4.add(slide4);
        lecLead.add(playLead);
        lecLead.add(pauseLead);
        lecLead.add(stopLead);
        lecLead.add(saveLead);
        lec1.add(play1);
        lec1.add(pause1);
        lec1.add(stop1);
        lec1.add(add1);
        lec2.add(play2);
        lec2.add(pause2);
        lec2.add(stop2);
        lec2.add(add2);
        lec3.add(play3);
        lec3.add(pause3);
        lec3.add(stop3);
        lec3.add(add3);
        lec4.add(play4);
        lec4.add(pause4);
        lec4.add(stop4);
        lec4.add(add4);
        panelPrincipal.setLayout(new FlowLayout());
        panelPrincipal.add(lecLead);
        panelPrincipal.add(lec1);
        panelPrincipal.add(lec2);
        panelPrincipal.add(lec3);
        panelPrincipal.add(lec4);
        contenu.add(panelPrincipal);
        //usuel
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }


    /**
     *fonction qui capte les évènements et active les actions en conséquence
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String str = e.getActionCommand();
        Object src = e.getSource();
        //System.out.println("event : "+str);
        if (str.equals("exit")) {
            System.exit(0);
        }
        else if (src == add1 && occupied) {
            this.stateLead = this.stateLead.concatenate(state1.getMusic());
            this.newGenerationNotes();
        }
        else if (src == add2 && occupied) {
            this.stateLead = this.stateLead.concatenate(state2.getMusic());
            this.newGenerationNotes();
        }
        else if (src == add3 && occupied) {
            this.stateLead = this.stateLead.concatenate(state3.getMusic());
            this.newGenerationNotes();
        }
        else if (src == add4 && occupied) {
            this.stateLead = this.stateLead.concatenate(state4.getMusic());
            this.newGenerationNotes();
        }
        else if (str.equals("SAUVEGARDER") && occupied) {
            this.stateLead.save("demo");
        }
        else if (src == playLead) {
            occupied = false;
            Play.stopAudio();
            Play.midi(stateLead.getMusic());
            actionSliderLead((int) stateLead.getMusic().getEndTime());
            occupied = true;
        }
        else if (src == play1) {
            occupied = false;
            Play.stopAudio();
            Play.midi(state1.getMusic());
            actionSlider1((int) state1.getMusic().getEndTime());
            occupied = true;
        }
        else if (src == play2) {
            occupied = false;
            Play.stopAudio();
            Play.midi(state2.getMusic());
            actionSlider2((int) state2.getMusic().getEndTime());
            occupied = true;
        }
        else if (src == play3) {
            occupied = false;
            Play.stopAudio();
            Play.midi(state3.getMusic());
            actionSlider3((int) state3.getMusic().getEndTime());
            occupied = true;
        }
        else if (src == play4) {
            occupied = false;
            Play.stopAudio();
            Play.midi(state4.getMusic());
            actionSlider4((int) state4.getMusic().getEndTime());
            occupied = true;
        }
        else if (str.equals("PAUSE")) {
            Play.pauseAudio();
        }
        else if (str.equals("STOP")) {
            Play.stopAudio();
        }
    }

    public void newGenerationNotes(){
        this.state1 = new State(stateLead.generateNextNotes());
        this.state2 = new State(stateLead.generateNextNotes());
        this.state3 = new State(stateLead.generateNextNotes());
        this.state4 = new State(stateLead.generateNextNotes());
    }

    public void actionSliderLead(int time){
        slideLead.setMaximum(time);
        Thread playing = new Thread(){
            public void run(){
                while(slideLead.getValue() < slideLead.getMaximum()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException v){}
                    slideLead.setValue(slideLead.getValue()+1);
                }
                slideLead.setValue(0);
            }
        };
        playing.start();
    }

    public void actionSlider1(int time){
        slide1.setMaximum(time);
        Thread playing = new Thread(){
            public void run(){
                while(slide1.getValue() < slide1.getMaximum()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException v){}
                    slide1.setValue(slide1.getValue()+1);
                }
                slide1.setValue(0);
            }
        };
        playing.start();
    }

    public void actionSlider2(int time){
        slide2.setMaximum(time);
        Thread playing = new Thread(){
            public void run(){
                while(slide2.getValue() < slide2.getMaximum()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException v){}
                    slide2.setValue(slide2.getValue()+1);
                }
                slide2.setValue(0);
            }
        };
        playing.start();
    }

    public void actionSlider3(int time){
        slide3.setMaximum(time);
        Thread playing = new Thread(){
            public void run(){
                while(slide3.getValue() < slide3.getMaximum()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException v){}
                    slide3.setValue(slide3.getValue()+1);
                }
                slide3.setValue(0);
            }
        };
        playing.start();
    }

    public void actionSlider4(int time){
        slide4.setMaximum(time);
        Thread playing = new Thread(){
            public void run(){
                while(slide4.getValue() < slide4.getMaximum()){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException v){}
                    slide4.setValue(slide4.getValue()+1);
                }
                slide4.setValue(0);
            }
        };
        playing.start();
    }

}

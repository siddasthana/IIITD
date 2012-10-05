/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iiitd.ivr.simulator.model;

import edu.iiitd.ivr.simulator.LogicProcessor;
import java.util.TimerTask;

/**
 * An Event object schedules the events of CallEvent object to be generated by
 * LogicProcessor as per timestamp of the events.
 *
 * @author siddhartha
 */
public class Event extends TimerTask {

    int key;
    String temp = "", mesg="";
    LogicProcessor sm;

    /**
     * 
     * @param smlt
     * @param x
     */
    public Event(LogicProcessor smlt, int x) {
        this.key = x;
        this.sm = smlt;
    }

    /**
     * 
     * @param smlt
     * @param t
     */
    public Event(LogicProcessor smlt, String t) {
        this.temp = t;
        this.sm = smlt;
    }
   public Event(LogicProcessor smlt, String t, String value) {
        this.temp = t;
        this.sm = smlt;
        this.mesg = value;
    }
    /**
     * 
     */
    public void run() {
        try {
            if (temp.equals("call")) {
                sm.startCall();
            } else if (temp.equals("end")) {
                 sm.terminateCall();
            }else if (temp.equals("userstatus")) {
                sm.setuserstatus(mesg);
            } else {
                sm.sendDTMF(key);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
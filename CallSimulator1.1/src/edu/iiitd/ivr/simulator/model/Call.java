/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iiitd.ivr.simulator.model;

import java.util.ArrayList;
import java.util.List;


/**
 * A Call handles the events of a single call in pairs of Event data,
 * timestamp.
 *
 * @author siddhartha
 */
public class Call {

    int i = 0;
    /**
     *  A unique identifier for each call.
     */
    public String Callid;
    
    /**
     * A Timestamp of an event in seconds measured relatively
     * to the start of call
     */
    public List<Integer> time = new ArrayList<Integer>();
    
    /**
     * Data to be used by simulator for generating the event.
     */
    public List<Integer> key = new ArrayList<Integer>();
     public List<String> userstatus = new ArrayList<String>();
     public List<String> Loop = new ArrayList<String>();
     public List<String> ElementAT = new ArrayList<String>();
     public List<String> ElementRequested = new ArrayList<String>();
     //public List<String>  = new ArrayList<String>();
     
    //public List<Integer[][]> event = new ArrayList<Integer[][]>();
    @Override
    public String toString() {
        return this.Callid;
    }

}

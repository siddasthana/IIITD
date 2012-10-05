/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iiitd.ivr.simulator.model;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author siddhartha
 */
public class CallContext {
  List<String> ContextString = new ArrayList<String>();
  List<String> Time = new ArrayList<String>();  
  List<String> CallId = new ArrayList<String>();  
    
  public String getContext(int i){
      String Mesg= new String();
      Mesg=ContextString.get(i);
      Mesg+=","+Time.get(i);
      Mesg+=","+CallId.get(i);
return Mesg;
  }
    
    
    public void addContext(String CS, String t, String Cid){
    ContextString.add(CS);
    Time.add(t);
    CallId.add(Cid);
    }
    
    public void removeContext(int i){
    ContextString.remove(i);
    Time.remove(i);
    CallId.remove(i);
    
    }
}

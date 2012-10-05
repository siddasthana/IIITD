/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iiitd.ivr.simulator;

import edu.iiitd.ivr.simulator.model.CallContext;
import java.io.*;

/**
 *
 * @author siddhartha
 */
public class StatusMonitor extends Thread {
    CallContext cc;
    static boolean start=false;
    public StatusMonitor(){
    cc = LogicProcessor.getCallContext();
    }
    public void run(){
    if(start==false){
    start=true;
    	try {
			File wd = new File("/bin");
			Process P = null;
			P = Runtime.getRuntime().exec("/bin/bash", null, wd);
                PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(P
                                            .getOutputStream())), true);
                InputStreamReader is = new InputStreamReader(P.getInputStream());
                BufferedReader br = new BufferedReader(is);
                        pw.println("/usr/local/freeswitch/bin/fs_cli -H "+ LogicProcessor.getServer_ip());
			String sCurrentLine=new String();
			while(( sCurrentLine = br.readLine()) != null) {
				if(sCurrentLine.contains("Context")){
                                cc.addContext("Context", "time", "callid");
                                }
			}
			
                        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    }
}

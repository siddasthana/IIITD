/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iiitd.ivr.simulator;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author siddhartha
 */
public class temp {
    public static void main(String[] args){
String sip_url = "sip:" + "707081" + "@" + "192.168.48.214";
        try {
			File wd = new File("/bin");
			Process P = null;
			P = Runtime.getRuntime().exec("/bin/bash", null, wd);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(P
					.getOutputStream())), true);
			InputStreamReader is = new InputStreamReader(P.getInputStream());
			BufferedReader br = new BufferedReader(is);
                        pw.println("linphonec");
            try {
                //pw.println("ls /home/");
                //System.out.println(is.read());
                      //System.out.println(is.read());
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(temp.class.getName()).log(Level.SEVERE, null, ex);
            }
                        int i=0;
			 while (br.ready()) { System.out.println(br.readLine());
                         System.out.println(br.readLine());
                         i++;
                         if(i==1)
                             break;
                             }
			 
        //                int prt=getFreePort();
          //              ports.add(prt);
			pw.println("ports sip " +5096);
                        pw.println("call " + sip_url);
                        //System.out.println("call " + sip_url);
                        System.out.println(is.read());
                         while (br.ready()) { System.out.println(br.readLine()); 
                         i++;
                         if(i==20)
                             break;
                             }
                        System.out.println("Calling..");
            try {
                Thread.sleep(3000);
                pw.println("terminate");
                Thread.sleep(3000);
                pw.println("quit");
            } catch (InterruptedException ex) {
                Logger.getLogger(temp.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

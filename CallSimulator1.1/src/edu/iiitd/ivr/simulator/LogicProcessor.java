package edu.iiitd.ivr.simulator;

import edu.iiitd.ivr.simulator.model.IUM.ObjectFactory;
import edu.iiitd.ivr.simulator.model.IUM.IntricateUM;
import edu.iiitd.ivr.simulator.model.SUM.SimpleUM;
import edu.iiitd.ivr.simulator.model.*;
import java.io.*;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * This class represents the controller component of Simulator in MVC paradigm.
 *
 * @author siddhartha
 */
public class LogicProcessor extends Thread {
     
    /**
     * VoIP extension to dial.
     */
    static int extension = 707081;
    /**
     * IP address of SIP server.
     */
    static int callsimulated = 0;
    static List<Integer> ports = new ArrayList<Integer>();
//    static String server_ip = "10.19.105.177:5080";
  static String server_ip = "192.168.49.243:5080";
    static CallContext callContext = new CallContext();
    public static String userstatus;
    String statitics="Call Load";
    public String usermodel="intricate";
    String StatsDir= "/media/FA3E25CE3E25852B/Sid_svn/ICPE2013/Data/";
    public static CallContext getCallContext() {
        return callContext;
    }

    public static int getCallsimulated() {
        return callsimulated;
    }

    public static void setCallContext(CallContext callContext) {
        LogicProcessor.callContext = callContext;
    }
   

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        LogicProcessor.extension = extension;
    }

    public static String getServer_ip() {
        return server_ip;
    }

    public static void setServer_ip(String server_ip) {
        LogicProcessor.server_ip = server_ip;
    }
    /**
     * Path of log file containing call data.
     */
    String logfile = "/home/ivr/media/"
            + "Mtech.log";
    String sip_url = "";
    PrintWriter pw;
    InputStreamReader is;
    BufferedReader br;
    String level = "";
    File wd;
    Process P;
    int currentcall=0;
    /**
     * Tree structure to store data of IVR menu option in hierarchical fashion.
     */
    Tree<String> IVRmenu = new Tree<String>();
    Connection con = null;
    /**
     * Timer object to schedule call events.
     */
    Timer timer;
    /**
     * List structure to store calls in sequential order.
     */
    List<Call> callList = new ArrayList<Call>();
    IntricateUM clList = new IntricateUM();
    SimpleUM clList1 = new SimpleUM();
    /*
     * class outpt implements Runnable { public void run() { try { while
     * (is.ready()) { System.out.print(is.read()); } } catch (IOException e) {
     * // TODO Auto-generated catch block e.printStackTrace(); } } }
     */

    /**
     * A single method to load IVR menu and call events into memory. This method
     * explicitly calls loadIVRMenu() and loadCallEvents().
     */
    public void loadData() {
        //loadIVRMenu();
        //loadCallEvents();
        System.out.println("Called load data with usermodel"+ usermodel);
        if(usermodel.equals("intricate")){
        
            loadCallsIUM();
        }else if(usermodel.equals("simple")){
        callsSUM();
        }
        
        initSIP();
    }

    /**
     * Method to start simulation.
     */
    public void simulate() {
        IntricateUM.Call cl = new ObjectFactory().createCallsCall();
        timer = new Timer();
        //Iterable t = clList.getCall().iterator()
        List<IntricateUM.Call> t = clList.getCall();
        for (Iterator<IntricateUM.Call> it = clList.getCall().iterator(); it.hasNext();) {
            cl = it.next();

        }
    }

    public void run() {
        // TODO Auto-generated method stub
        // System.out.println("Calling....");
        // startCall();
        int timecorrection = 0;
        timer = new Timer();
        int callid=0;
if(this.usermodel.equals("intricate")){
for (Call e : callList) {
            callid++;
            timer.schedule(new Event(this, "call",String.valueOf(callid)), timecorrection * 1000);
            int i = 0;
            for (Integer key : e.key) {
                timer.schedule(new Event(this, e.key.get(i),String.valueOf(callid),e.Loop.get(i),e.ElementAT.get(i),e.ElementRequested.get(i)),
                        (e.time.get(i) + timecorrection) * 1000);
                i++;
            }
            i = 0;
            for (String mesg : e.userstatus) {
                timer.schedule(new Event(this, "userstatus", mesg),
                        (e.time.get(i) + timecorrection) * 1000);
                i++;
            }
            if (i > 0) {
                timer.schedule(new Event(this, "end",String.valueOf(callid)),
                        (e.time.get(i - 1) + 10 + timecorrection) * 1000);
                timecorrection = e.time.get(i - 1) + 12 + timecorrection;
            } else {
                timecorrection += 2;
            }
        }
}        
else
        {for (Call e : callList) {
            callid++;
            timer.schedule(new Event(this, "call",String.valueOf(callid)), timecorrection * 1000);
            int i = 0;
            for (Integer key : e.key) {
                timer.schedule(new Event(this, key,String.valueOf(callid),"","",""),
                        (e.time.get(i) + timecorrection) * 1000);
                i++;
            }
            i = 0;
            for (String mesg : e.userstatus) {
                timer.schedule(new Event(this, "userstatus", mesg),
                        (e.time.get(i) + timecorrection) * 1000);
                i++;
            }
            if (i > 0) {
                timer.schedule(new Event(this, "end",String.valueOf(callid)),
                        (e.time.get(i - 1) + 10 + timecorrection) * 1000);
                timecorrection = e.time.get(i - 1) + 12 + timecorrection;
            } else {
                timecorrection += 2;
            }
        }
    }
    }

    /**
     * Method to terminate call.
     */
    public void terminateCall() {
        // TODO Auto-generated method stub
        try {
          
           // Thread.sleep(1000);
            pw.println("h");
            callsimulated--;
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //pw.println("exit");
        System.out.println("ending call..");
    }

    /**
     * Reads the call log and loads the call events into memory.
     */
    private void loadCallsIUM() {
        JAXBContext jaxbContext;
        ObjectFactory objFactory;
        Unmarshaller unmarshaller;
        try {
            jaxbContext = JAXBContext.newInstance("edu.iiitd.ivr.simulator.model.IUM");
            objFactory = new ObjectFactory();
            unmarshaller = jaxbContext.createUnmarshaller();
            try {
                clList = (IntricateUM) unmarshaller.unmarshal(new FileInputStream(logfile));
                //callList=clList.getCall();
                //clList.getCall().get(0).getEvents().get(0).  
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JAXBException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //**********will be removed later
        IntricateUM.Call cl = new ObjectFactory().createCallsCall();
        //List<Calls.Call> t =  clList.getCall();
        for (Iterator<IntricateUM.Call> it = clList.getCall().iterator(); it.hasNext();) {
            cl = it.next();
            Call Currentevent = new Call();
            Currentevent.Callid = cl.getMetadata().getTimeStamp();
            IntricateUM.Call.Events ev = new ObjectFactory().createCallsCallEvents();
            for (Iterator<IntricateUM.Call.Events> eit = cl.getEvents().iterator(); eit.hasNext();) {
                ev = eit.next();
                Currentevent.time.add(Integer.parseInt(ev.getTime()));
                Currentevent.key.add(Integer.parseInt(ev.getData()));
                Currentevent.Loop.add(ev.getContextinfo().getLoops());
                Currentevent.ElementAT.add(ev.getContextinfo().getElementAT());
                Currentevent.ElementRequested.add(ev.getContextinfo().getElementRequested());
                if (ev.getContextinfo().getUserCategory().contains("unsure")) {
                    Currentevent.userstatus.add("User is not sure what to choose");
                } else {
                    Currentevent.userstatus.add("User is waiting for appropriate option");
                }
            }
            callList.add(Currentevent);
        }
        //**************
    }
    private void callsSUM(){
    JAXBContext jaxbContext;
        edu.iiitd.ivr.simulator.model.SUM.ObjectFactory objFactory;
        Unmarshaller unmarshaller;
        try {
            jaxbContext = JAXBContext.newInstance("edu.iiitd.ivr.simulator.model.SUM");
            objFactory = new edu.iiitd.ivr.simulator.model.SUM.ObjectFactory();
            unmarshaller = jaxbContext.createUnmarshaller();
            try {
                clList1 =  (SimpleUM) unmarshaller.unmarshal(new FileInputStream(logfile));
                //callList=clList.getCall();
                //clList.getCall().get(0).getEvents().get(0).  
            } catch (FileNotFoundException ex) {
                Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (JAXBException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //**********will be removed later
        //SimpleUM.Call cl = new ObjectFactory().createCallsCall();
        SimpleUM.Call cl = new edu.iiitd.ivr.simulator.model.SUM.ObjectFactory().createCallsCall();
        //List<Calls.Call> t =  clList.getCall();
        int sum=0;
        for (Iterator<SimpleUM.Call> it = clList1.getCall().iterator(); it.hasNext();) {
        sum++;
        System.out.println("Calss added "+ sum);
            cl = it.next();
            Call Currentevent = new Call();
            Currentevent.Callid = cl.getMetadata().getTimeStamp();
            SimpleUM.Call.Events ev = new edu.iiitd.ivr.simulator.model.SUM.ObjectFactory().createCallsCallEvents();
            for (Iterator<SimpleUM.Call.Events> eit = cl.getEvents().iterator(); eit.hasNext();) {
                ev = eit.next();
                Currentevent.time.add(Integer.parseInt(ev.getTime()));
                Currentevent.key.add(Integer.parseInt(ev.getData()));
                Currentevent.userstatus.add("User waiting for annoucement number "+ev.getData());
            }
            callList.add(Currentevent);
        }
        
    }
    private void loadCallEvents() {
        // TODO Auto-generated method stub

        try {
            FileInputStream fstream = new FileInputStream(logfile);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String callid = "";
            String strLine;
            Call Currentevent = new Call();
            // Read File Line By Line
            // int i = 0;
            while ((strLine = br.readLine()) != null) {
                String args[] = strLine.split(",");
                if (!callid.equals(args[0])) {
                    // Add new element to callList
                    Call temp = new Call();
                    if (!callid.equals("")) {
                        callList.add(Currentevent);
                    }
                    callid = args[0];
                    temp.Callid = callid;
                    Currentevent = temp;
                }
                if (args[4].equals("<Key>")) {
                    Currentevent.time.add(Integer.parseInt(args[2]));
                    Currentevent.key.add(Integer.parseInt(args[5]));
                }
            }
            callList.add(Currentevent);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Reads the IVR menu from database and loads it into memory in a tree data
     * structure.
     */
    public void loadIVRMenu() {
        con = new DatabaseHandler().getConnection();
        Node<String> Root = new Node<String>();
        Root.data = "0";
        int datacount = 0;
        while (!level.equals("Finish")) {
            level += "_";
            Statement st;
            try {
                st = con.createStatement();
                ResultSet res = st.executeQuery("select level, File, Tag from Node where level like '"
                        + level + "' order by level");
                // System.out.println("select File, Tag from Node where level like '"+
                // level + "'");
                datacount = 0;
                while (res.next()) {
                    datacount++;
                    if (res.getString("level") != null) {
                        int childat = level.length();
                        Node<String> temp = Root;
                        int i = 0;
                        while (i != childat) {
                            i++;
                            List<Node<String>> temp2 = temp.getChildren();
                            int k = 0;
                            while (k < temp2.size()) {

                                Node<String> node = temp2.get(k);

                                if (node.data.equals(res.getString("level").substring(0, i))) {
                                    temp = node;
                                    break;
                                }
                                k++;
                            }
                        }
                        Node<String> child = new Node<String>();
                        child.data = res.getString("level");
                        temp.addChild(child);

                    }
                }
                if (datacount == 0) {
                    level = "Finish";
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        // Retrieves the menu option at current level in IVR menu

        // Root.addChild();
        IVRmenu.setRootElement(Root);
        System.out.println(IVRmenu.toString());
    }

    /**
     * Method to start a new Call.
     */
    public void initSIP() {
        try {
            wd = new File("/bin");
            P = null;
            P = Runtime.getRuntime().exec("/bin/bash", null, wd);
            pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(P.getOutputStream())), true);
            is = new InputStreamReader(P.getInputStream());
            br = new BufferedReader(is);
            pw.println("/usr/local/src/pjproject-2.0.1/pjsip-apps/bin/pjsua-i686-pc-linux-gnu --max-call=1000 --local-port="+getFreePort());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
            /*
             * while (is.ready()) { System.out.print(is.read()); }
             */

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void startCall() {
        callsimulated++;
        
        System.out.println("call Simulated : " + callsimulated);
        this.sendCommand("m");
        sip_url = "sip:" + extension + "@" + server_ip;
        
        //    int prt=getFreePort();
        //ports.add(prt);
        //pw.println("ports sip " +prt);
        this.sendCommand(sip_url);
        System.out.println(sip_url);
        System.out.println("Calling..");
    }

    /**
     * Method to simulate DTMF key-press on IVR.
     *
     * @param
     */
    public void sendDTMF(int x) {
        String s = String.valueOf(x);
        pw.println("#");
        pw.println(s);
        // pw.flush();
        System.out.println(x);
        // pw.write();
    }

    /**
     * Method to send misc command
     *
     * @param cmdString
     * @return
     */
    public String sendCommand(String cmdString) {
        try {
            String t = "";
            while (br.ready() && ((t = br.readLine()) != null)) {
                System.out.println("[Debug]" + t);
                //System.out.println(br.ready());
                System.out.print((char)br.read());
                System.out.print((char)br.read());
                System.out.print((char)br.read());
                System.out.print((char)br.read());
            int intch;
                while ((intch = br.read()) != -1) {
  char ch = (char) intch;
  System.out.print(ch);
  //System.out.println(br.ready());
if(!br.ready()){
break;}
                }//System.out.println(br.ready());
            }
            System.out.println("Debug Complete!!");
        } catch (IOException ex) {
                System.out.println("[Error]"+ ex.getStackTrace().toString());
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        pw.println(cmdString);
        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("[Info:]" + cmdString);
        try {
            String t = "";
            if (br.ready() && (t = br.readLine()) != null) {
                //return br.readLine();
                return t;
            }
        } catch (IOException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Method to simulate Audio event on IVR.
     */
    public void sendAudio(String filepath) {
        pw.print("play " + filepath);
    }
//Test Related Variable Declaration
    String DTMFChar = "1", SequenceLength, Delay, MinDelay, MaxDelay, FinalMesg;

    void calltest() {
        
        LogicProcessor testcall = new LogicProcessor();
        testcall.createshell();
        testcall.staticload("Starting Test at : "+System.currentTimeMillis());
        testcall.initSIP();
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        testcall.startCall();
        //callsimulated++;
        testcall.staticload("Call simulated :"+callsimulated+"at "+System.currentTimeMillis());
        int i =1;
        //ArrayList<SimulatorController> cl = new ArrayList<SimulatorController>();
        while (!testcall.sendCommand("dq").contains("No current call")) {
            FinalMesg = "Currently " + callsimulated + " Calls are running";
          //  callsimulated++;
            i++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
         //   LogicProcessor call = new LogicProcessor();
            testcall.startCall();
            testcall.staticload("Call simulated :"+callsimulated+"at "+System.currentTimeMillis());
            //cl.add(call);
            if(callsimulated>1024){
                break;
            }
        }
            if(callsimulated<1024){
        FinalMesg = "Failed at " + callsimulated + " number of simultaneous calls.";
    }else{
            FinalMesg= "Tested " + callsimulated + "number of calls. Reached MAX test limit "; 
         }
            while(i>0){
                i--;
            testcall.terminateCall();
            callsimulated--;
            }
            testcall.destroyshell();
    }

    public void DTMFtest() {
        LogicProcessor testcall = new LogicProcessor();
        testcall.initSIP();
        testcall.startCall();
        int result = 1;
        while (!testcall.sendCommand("dq").contains("No current call")) {
            FinalMesg = "testing with " + result + " DTMF per second.";
            for (int i = 0; i < result; i++) {
                testcall.sendDTMF(Integer.parseInt(DTMFChar));
            }
            try {
                this.sleep(1500);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
            result++;
        }
        FinalMesg = "Failed at " + result + "DTMF per second";
    }

    void DTMF_SequenceCD() {
        LogicProcessor testcall = new LogicProcessor();
        testcall.initSIP();
        testcall.startCall();
        String seq = null;
        int sequence, i = 0;
        int cases = (int) Math.pow(10, Double.valueOf(SequenceLength));

        while (i < cases) {
            if (testcall.sendCommand("dq").contains("No current call")) {
                System.out.println("Off the hook");
                break;
            }
            i++;

            System.out.println("Atak gaya2");
            sequence = (int) (Math.random() * Math.pow(10, Double.valueOf(SequenceLength)));
            seq = String.valueOf(sequence);
            FinalMesg = "Testing with " + seq + " Sequence.";
            System.out.println(FinalMesg);
            for (int k = 0; k < seq.length(); k++) {
                try {
                    testcall.sendDTMF(Integer.parseInt(DTMFChar));
                    this.sleep(1000 * Integer.parseInt(Delay));
                } catch (InterruptedException ex) {
                    Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (i != cases) {
            FinalMesg = "Failed with " + seq + " Sequence.";
        }
    }

    void DTMF_SequenceRVD() {
        LogicProcessor testcall = new LogicProcessor();
        testcall.initSIP();
        testcall.startCall();
        int sequence, i = 0;
        String seq = null;
        int cases = (int) Math.pow(10, Double.valueOf(SequenceLength));

        while (i < cases) {
            if (testcall.sendCommand("dq").contains("No current call")) {
                break;
            }
            i++;

            sequence = (int) (Math.random() * Math.pow(10, Double.valueOf(SequenceLength)));
            seq = String.valueOf(sequence);
            FinalMesg = "Testing with " + seq + " Sequence.";
            for (int k = 0; k < seq.length(); k++) {
                try {
                    testcall.sendDTMF(Integer.parseInt(DTMFChar));
                    int RandomDelay = (int) (Integer.parseInt(MinDelay) + Math.random() * (Integer.parseInt(MaxDelay) - Integer.parseInt(MinDelay)));
                    this.sleep(1000 * RandomDelay);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        if (i != cases) {
            FinalMesg = "Failed with " + seq + " Sequence.";
        }
    }

    private int getFreePort() {
        boolean portAvailable = true;
        ServerSocket socket = null;
        int portNumber;
        if (ports.size() == 0) {
            portNumber = 5092;
        } else {
            portNumber = ports.get(ports.size());
        }
        do {
            try {
                portNumber += 2;
                portAvailable = true;
                socket = new ServerSocket(portNumber);

            } catch (IOException e) {
                portAvailable = false;
            } finally {
                // Clean up
                if (socket != null) {
                    try {
                        socket.close();
                        socket.setReuseAddress(true);
                    } catch (IOException ex) {
                        Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } while (portAvailable == false);
        return portNumber;
    }

    public void setuserstatus(String mesg) {
        this.userstatus = mesg;
    }
    
    private File wd1,wd2;
    private Process P1,P2;
    private PrintWriter pw1,pw2;
    private InputStreamReader is1;
    private BufferedReader br1;
    public void createshell(){
    try {
            wd1 = new File("/bin");
            wd2 = new File("/bin");
            P1 = null;
            P1 = Runtime.getRuntime().exec("/bin/bash", null, wd1);
            P2 = Runtime.getRuntime().exec("/bin/bash", null, wd2);
            pw1 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(P1.getOutputStream())), true);
            pw2 = new PrintWriter(new BufferedWriter(new OutputStreamWriter(P2.getOutputStream())),true);
            is1 = new InputStreamReader(P1.getInputStream());
            br1 = new BufferedReader(is1);
            pw2.println("echo `sudo nethogs wlan0` >>"+ StatsDir+"Bw.csv");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void destroyshell(){
        try {
            pw1.println("q");
            br1.close();
            is1.close();
            pw1.close();
            P1.destroy();
    
        } catch (IOException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    public void staticload(String mesg){
    System.err.println("Writting smthng");
    String fname = StatsDir+"static.csv"; 
    Date ds = new Date();
    
    pw1.println("echo `ps -C java -o %cpu,%mem,pid` "+ ds.toGMTString()+","+ds.getTime()+","+mesg+" >>"+ fname);
    pw1.flush();
    runningload(mesg);
    
    }
    public void runningload(String mesg){
    String fname = StatsDir+"run.csv";    
    Date ds = new Date();
    pw1.println("echo `ps -C pjsua-i686-pc-l -o %cpu,%mem,pid` "+ ds.toGMTString()+","+ds.getTime()+","+mesg+" >>"+ fname);
    pw1.flush();
//    bandwidth(mesg);
    }
    
    public void bandwidth(String mesg){
    String fname = StatsDir+"Bw.csv";    
    Date ds = new Date();
//    pw1.println("sudo ls");
  //  pw1.println("12345");
    //pw2.println("echo `sudo nethogs wlan0` "+ ds.toGMTString()+","+ds.getTime()+","+mesg+" >>"+ fname);
    pw2.println("q");
    pw2.println("echo "+ ds.toGMTString()+","+ds.getTime()+","+mesg+" >>"+ fname);
    pw2.println("echo `sudo nethogs wlan0` >>"+ StatsDir+"Bw.csv");
    try {
            Thread.sleep(3100);
        } catch (InterruptedException ex) {
            Logger.getLogger(LogicProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}

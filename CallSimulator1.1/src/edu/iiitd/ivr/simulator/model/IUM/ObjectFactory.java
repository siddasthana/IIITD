//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.05 at 01:46:53 PM IST 
//


package edu.iiitd.ivr.simulator.model.IUM;

import edu.iiitd.ivr.simulator.model.IUM.IntricateUM;
import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the dynamic package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: dynamic
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link IntricateUM }
     * 
     */
    public IntricateUM createCalls() {
        return new IntricateUM();
    }

    /**
     * Create an instance of {@link IntricateUM.Call }
     * 
     */
    public IntricateUM.Call createCallsCall() {
        return new IntricateUM.Call();
    }

    /**
     * Create an instance of {@link IntricateUM.Call.Events }
     * 
     */
    public IntricateUM.Call.Events createCallsCallEvents() {
        return new IntricateUM.Call.Events();
    }

    /**
     * Create an instance of {@link IntricateUM.Call.Metadata }
     * 
     */
    public IntricateUM.Call.Metadata createCallsCallMetadata() {
        return new IntricateUM.Call.Metadata();
    }

    /**
     * Create an instance of {@link IntricateUM.Call.Events.Contextinfo }
     * 
     */
    public IntricateUM.Call.Events.Contextinfo createCallsCallEventsContextinfo() {
        return new IntricateUM.Call.Events.Contextinfo();
    }

}

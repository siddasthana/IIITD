//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.09.05 at 01:46:53 PM IST 
//


package edu.iiitd.ivr.simulator.model.IUM;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Call" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="metadata">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="UniqueId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="System" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="events" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="InputType">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Audio"/>
 *                                   &lt;enumeration value="Keypress"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="contextinfo">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;sequence>
 *                                       &lt;element name="Loops" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ElementAT" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="ElementRequested" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                                       &lt;element name="UserCategory">
 *                                         &lt;simpleType>
 *                                           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                             &lt;enumeration value="Sure"/>
 *                                             &lt;enumeration value="Not Sure"/>
 *                                           &lt;/restriction>
 *                                         &lt;/simpleType>
 *                                       &lt;/element>
 *                                     &lt;/sequence>
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                             &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "call"
})
@XmlRootElement(name = "Calls")
public class IntricateUM {

    @XmlElement(name = "Call")
    protected List<IntricateUM.Call> call;

    /**
     * Gets the value of the call property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the call property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCall().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IntricateUM.Call }
     * 
     * 
     */
    public List<IntricateUM.Call> getCall() {
        if (call == null) {
            call = new ArrayList<IntricateUM.Call>();
        }
        return this.call;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="metadata">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="UniqueId" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="System" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="events" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="InputType">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Audio"/>
     *                         &lt;enumeration value="Keypress"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="contextinfo">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;sequence>
     *                             &lt;element name="Loops" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ElementAT" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="ElementRequested" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                             &lt;element name="UserCategory">
     *                               &lt;simpleType>
     *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                                   &lt;enumeration value="Sure"/>
     *                                   &lt;enumeration value="Not Sure"/>
     *                                 &lt;/restriction>
     *                               &lt;/simpleType>
     *                             &lt;/element>
     *                           &lt;/sequence>
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                   &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "metadata",
        "events"
    })
    public static class Call {

        @XmlElement(required = true)
        protected IntricateUM.Call.Metadata metadata;
        protected List<IntricateUM.Call.Events> events;

        /**
         * Gets the value of the metadata property.
         * 
         * @return
         *     possible object is
         *     {@link IntricateUM.Call.Metadata }
         *     
         */
        public IntricateUM.Call.Metadata getMetadata() {
            return metadata;
        }

        /**
         * Sets the value of the metadata property.
         * 
         * @param value
         *     allowed object is
         *     {@link IntricateUM.Call.Metadata }
         *     
         */
        public void setMetadata(IntricateUM.Call.Metadata value) {
            this.metadata = value;
        }

        /**
         * Gets the value of the events property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the events property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getEvents().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IntricateUM.Call.Events }
         * 
         * 
         */
        public List<IntricateUM.Call.Events> getEvents() {
            if (events == null) {
                events = new ArrayList<IntricateUM.Call.Events>();
            }
            return this.events;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="InputType">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Audio"/>
         *               &lt;enumeration value="Keypress"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="contextinfo">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;sequence>
         *                   &lt;element name="Loops" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ElementAT" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="ElementRequested" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *                   &lt;element name="UserCategory">
         *                     &lt;simpleType>
         *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *                         &lt;enumeration value="Sure"/>
         *                         &lt;enumeration value="Not Sure"/>
         *                       &lt;/restriction>
         *                     &lt;/simpleType>
         *                   &lt;/element>
         *                 &lt;/sequence>
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *         &lt;element name="time" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "inputType",
            "data",
            "contextinfo",
            "time"
        })
        public static class Events {

            @XmlElement(name = "InputType", required = true)
            protected String inputType;
            @XmlElement(required = true)
            protected String data;
            @XmlElement(required = true)
            protected IntricateUM.Call.Events.Contextinfo contextinfo;
            @XmlElement(required = true)
            protected String time;

            /**
             * Gets the value of the inputType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getInputType() {
                return inputType;
            }

            /**
             * Sets the value of the inputType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setInputType(String value) {
                this.inputType = value;
            }

            /**
             * Gets the value of the data property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getData() {
                return data;
            }

            /**
             * Sets the value of the data property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setData(String value) {
                this.data = value;
            }

            /**
             * Gets the value of the contextinfo property.
             * 
             * @return
             *     possible object is
             *     {@link IntricateUM.Call.Events.Contextinfo }
             *     
             */
            public IntricateUM.Call.Events.Contextinfo getContextinfo() {
                return contextinfo;
            }

            /**
             * Sets the value of the contextinfo property.
             * 
             * @param value
             *     allowed object is
             *     {@link IntricateUM.Call.Events.Contextinfo }
             *     
             */
            public void setContextinfo(IntricateUM.Call.Events.Contextinfo value) {
                this.contextinfo = value;
            }

            /**
             * Gets the value of the time property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTime() {
                return time;
            }

            /**
             * Sets the value of the time property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTime(String value) {
                this.time = value;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;sequence>
             *         &lt;element name="Loops" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ElementAT" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="ElementRequested" type="{http://www.w3.org/2001/XMLSchema}string"/>
             *         &lt;element name="UserCategory">
             *           &lt;simpleType>
             *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
             *               &lt;enumeration value="Sure"/>
             *               &lt;enumeration value="Not Sure"/>
             *             &lt;/restriction>
             *           &lt;/simpleType>
             *         &lt;/element>
             *       &lt;/sequence>
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "loops",
                "elementAT",
                "elementRequested",
                "userCategory"
            })
            public static class Contextinfo {

                @XmlElement(name = "Loops", required = true)
                protected String loops;
                @XmlElement(name = "ElementAT", required = true)
                protected String elementAT;
                @XmlElement(name = "ElementRequested", required = true)
                protected String elementRequested;
                @XmlElement(name = "UserCategory", required = true)
                protected String userCategory;

                /**
                 * Gets the value of the loops property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getLoops() {
                    return loops;
                }

                /**
                 * Sets the value of the loops property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setLoops(String value) {
                    this.loops = value;
                }

                /**
                 * Gets the value of the elementAT property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getElementAT() {
                    return elementAT;
                }

                /**
                 * Sets the value of the elementAT property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setElementAT(String value) {
                    this.elementAT = value;
                }

                /**
                 * Gets the value of the elementRequested property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getElementRequested() {
                    return elementRequested;
                }

                /**
                 * Sets the value of the elementRequested property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setElementRequested(String value) {
                    this.elementRequested = value;
                }

                /**
                 * Gets the value of the userCategory property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getUserCategory() {
                    return userCategory;
                }

                /**
                 * Sets the value of the userCategory property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setUserCategory(String value) {
                    this.userCategory = value;
                }

            }

        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="UniqueId" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="From" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="TimeStamp" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="System" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "uniqueId",
            "from",
            "timeStamp",
            "system"
        })
        public static class Metadata {

            @XmlElement(name = "UniqueId", required = true)
            protected String uniqueId;
            @XmlElement(name = "From", required = true)
            protected String from;
            @XmlElement(name = "TimeStamp", required = true)
            protected String timeStamp;
            @XmlElement(name = "System", required = true)
            protected String system;

            /**
             * Gets the value of the uniqueId property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getUniqueId() {
                return uniqueId;
            }

            /**
             * Sets the value of the uniqueId property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setUniqueId(String value) {
                this.uniqueId = value;
            }

            /**
             * Gets the value of the from property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getFrom() {
                return from;
            }

            /**
             * Sets the value of the from property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setFrom(String value) {
                this.from = value;
            }

            /**
             * Gets the value of the timeStamp property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTimeStamp() {
                return timeStamp;
            }

            /**
             * Sets the value of the timeStamp property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTimeStamp(String value) {
                this.timeStamp = value;
            }

            /**
             * Gets the value of the system property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getSystem() {
                return system;
            }

            /**
             * Sets the value of the system property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setSystem(String value) {
                this.system = value;
            }

        }

    }

}
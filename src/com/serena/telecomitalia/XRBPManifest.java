
package com.serena.telecomitalia;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


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
 *         &lt;element name="Area" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Elements">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Element" maxOccurs="unbounded" minOccurs="0">
 *                               &lt;complexType>
 *                                 &lt;simpleContent>
 *                                   &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                                     &lt;attribute name="Nbr" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *                                     &lt;attribute name="PVCS_Path" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Script" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Istanza" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                     &lt;attribute name="Eseguibile" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                                   &lt;/extension>
 *                                 &lt;/simpleContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="Status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="ManifestVersion" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="Write" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="Date" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "area"
})
@XmlRootElement(name = "XRBPManifest")
public class XRBPManifest {

    @XmlElement(name = "Area")
    protected List<XRBPManifest.Area> area;
    @XmlAttribute(name = "Status")
    protected String status;
    @XmlAttribute(name = "ManifestVersion")
    protected Float manifestVersion;
    @XmlAttribute(name = "Write")
    protected String write;
    @XmlAttribute(name = "Date")
    protected String date;

    /**
     * Gets the value of the area property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the area property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArea().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XRBPManifest.Area }
     * 
     * 
     */
    public List<XRBPManifest.Area> getArea() {
        if (area == null) {
            area = new ArrayList<XRBPManifest.Area>();
        }
        return this.area;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the manifestVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getManifestVersion() {
        return manifestVersion;
    }

    /**
     * Sets the value of the manifestVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setManifestVersion(Float value) {
        this.manifestVersion = value;
    }

    /**
     * Gets the value of the write property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWrite() {
        return write;
    }

    /**
     * Sets the value of the write property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWrite(String value) {
        this.write = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDate(String value) {
        this.date = value;
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
     *         &lt;element name="Elements">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Element" maxOccurs="unbounded" minOccurs="0">
     *                     &lt;complexType>
     *                       &lt;simpleContent>
     *                         &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *                           &lt;attribute name="Nbr" type="{http://www.w3.org/2001/XMLSchema}byte" />
     *                           &lt;attribute name="PVCS_Path" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Script" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Istanza" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                           &lt;attribute name="Eseguibile" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                         &lt;/extension>
     *                       &lt;/simpleContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="Name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "elements"
    })
    public static class Area {

        @XmlElement(name = "Elements", required = true)
        protected XRBPManifest.Area.Elements elements;
        @XmlAttribute(name = "Name")
        protected String name;

        /**
         * Gets the value of the elements property.
         * 
         * @return
         *     possible object is
         *     {@link XRBPManifest.Area.Elements }
         *     
         */
        public XRBPManifest.Area.Elements getElements() {
            return elements;
        }

        /**
         * Sets the value of the elements property.
         * 
         * @param value
         *     allowed object is
         *     {@link XRBPManifest.Area.Elements }
         *     
         */
        public void setElements(XRBPManifest.Area.Elements value) {
            this.elements = value;
        }

        /**
         * Gets the value of the name property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the value of the name property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
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
         *         &lt;element name="Element" maxOccurs="unbounded" minOccurs="0">
         *           &lt;complexType>
         *             &lt;simpleContent>
         *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
         *                 &lt;attribute name="Nbr" type="{http://www.w3.org/2001/XMLSchema}byte" />
         *                 &lt;attribute name="PVCS_Path" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Script" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Istanza" type="{http://www.w3.org/2001/XMLSchema}string" />
         *                 &lt;attribute name="Eseguibile" type="{http://www.w3.org/2001/XMLSchema}string" />
         *               &lt;/extension>
         *             &lt;/simpleContent>
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
            "element"
        })
        public static class Elements {

            @XmlElement(name = "Element")
            protected List<XRBPManifest.Area.Elements.Element> element;

            /**
             * Gets the value of the element property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the element property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getElement().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link XRBPManifest.Area.Elements.Element }
             * 
             * 
             */
            public List<XRBPManifest.Area.Elements.Element> getElement() {
                if (element == null) {
                    element = new ArrayList<XRBPManifest.Area.Elements.Element>();
                }
                return this.element;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;simpleContent>
             *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
             *       &lt;attribute name="Nbr" type="{http://www.w3.org/2001/XMLSchema}byte" />
             *       &lt;attribute name="PVCS_Path" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Script" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Istanza" type="{http://www.w3.org/2001/XMLSchema}string" />
             *       &lt;attribute name="Eseguibile" type="{http://www.w3.org/2001/XMLSchema}string" />
             *     &lt;/extension>
             *   &lt;/simpleContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "value"
            })
            public static class Element {

                @XmlValue
                protected String value;
                @XmlAttribute(name = "Nbr")
                protected Byte nbr;
                @XmlAttribute(name = "PVCS_Path")
                protected String pvcsPath;
                @XmlAttribute(name = "Script")
                protected String script;
                @XmlAttribute(name = "Istanza")
                protected String istanza;
                @XmlAttribute(name = "Eseguibile")
                protected String eseguibile;

                /**
                 * Gets the value of the value property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getValue() {
                    return value;
                }

                /**
                 * Sets the value of the value property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setValue(String value) {
                    this.value = value;
                }

                /**
                 * Gets the value of the nbr property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Byte }
                 *     
                 */
                public Byte getNbr() {
                    return nbr;
                }

                /**
                 * Sets the value of the nbr property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Byte }
                 *     
                 */
                public void setNbr(Byte value) {
                    this.nbr = value;
                }

                /**
                 * Gets the value of the pvcsPath property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getPVCSPath() {
                    return pvcsPath;
                }

                /**
                 * Sets the value of the pvcsPath property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setPVCSPath(String value) {
                    this.pvcsPath = value;
                }

                /**
                 * Gets the value of the script property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getScript() {
                    return script;
                }

                /**
                 * Sets the value of the script property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setScript(String value) {
                    this.script = value;
                }

                /**
                 * Gets the value of the istanza property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getIstanza() {
                    return istanza;
                }

                /**
                 * Sets the value of the istanza property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setIstanza(String value) {
                    this.istanza = value;
                }

                /**
                 * Gets the value of the eseguibile property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link String }
                 *     
                 */
                public String getEseguibile() {
                    return eseguibile;
                }

                /**
                 * Sets the value of the eseguibile property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link String }
                 *     
                 */
                public void setEseguibile(String value) {
                    this.eseguibile = value;
                }

            }

        }

    }

}

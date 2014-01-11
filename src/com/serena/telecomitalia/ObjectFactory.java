
package com.serena.telecomitalia;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.serena.telecomitalia package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.serena.telecomitalia
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link XRBPManifest.Area }
     * 
     */
    public XRBPManifest.Area createXRBPManifestArea() {
        return new XRBPManifest.Area();
    }

    /**
     * Create an instance of {@link XRBPManifest }
     * 
     */
    public XRBPManifest createXRBPManifest() {
        return new XRBPManifest();
    }

    /**
     * Create an instance of {@link XRBPManifest.Area.Elements }
     * 
     */
    public XRBPManifest.Area.Elements createXRBPManifestAreaElements() {
        return new XRBPManifest.Area.Elements();
    }

    /**
     * Create an instance of {@link XRBPManifest.Area.Elements.Element }
     * 
     */
    public XRBPManifest.Area.Elements.Element createXRBPManifestAreaElementsElement() {
        return new XRBPManifest.Area.Elements.Element();
    }

}

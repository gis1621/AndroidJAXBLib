/*
 * Collage.java		Date created: May 24, 2013
 * Last modified by: kadygrob
 * $Revision$	May 24, 2013
 */

package biz.kulik.android.jaxb.library.parserTest.XmlJavaTypeAdaptersTest.scene;

import biz.kulik.android.jaxb.library.Annotations.XmlAttribute;
import biz.kulik.android.jaxb.library.Annotations.XmlElement;
import biz.kulik.android.jaxb.library.Annotations.XmlElementWrapper;

import java.util.List;

/**
 * Describes a collage in a scene
 * 
 * @author kadygrob Copyright QArea Inc, 2013
 */
public class Collage {

    @XmlAttribute(name = "background")
    public String bgFileName;

    @XmlElementWrapper(name = "slots")
    @XmlElement(name = "slot")
    public List<Slot> slots;

}
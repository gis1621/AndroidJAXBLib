package com.kulik.android.jaxb.library.parserTest.TS_Roster;


import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.util.List;

/**
 * User: bender
 * Date: 16.01.13
 * Time: 14:07
 */
public class GetRosterResponse {

    @XmlElement(name = "TSCreateRoster")
    public List<DateCollectionCh> dateCollection;


}
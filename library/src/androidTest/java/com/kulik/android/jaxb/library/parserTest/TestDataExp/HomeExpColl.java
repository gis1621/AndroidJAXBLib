/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.parserTest.TestDataExp;

import com.kulik.android.jaxb.library.Annotations.XmlElement;

import java.io.Serializable;
import java.util.List;

/**
 * User: bender
 * Date: 15.02.13
 * Time: 11:00
 */
public class HomeExpColl implements Serializable {

    @XmlElement(name = "HomeExpTypeColl")
    private List<HomeExpTypeColl> homeExpTypeColl;

    public List<HomeExpTypeColl> getHomeExpTypeColl() {
        return homeExpTypeColl;
    }

    public void setHomeExpTypeColl(List<HomeExpTypeColl> homeExpTypeColl) {
        this.homeExpTypeColl = homeExpTypeColl;
    }
}
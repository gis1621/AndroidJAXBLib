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
package com.kulik.android.jaxb.library.parser.providers;

import com.kulik.android.jaxb.library.loger.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: nata
 * Date: 9/20/12
 * Time: 12:39 PM
 */
public class ElemJSONUnmarshalerImpl extends AbstractElementUnmarshaler {
    private static final String TAG = ElemJSONUnmarshalerImpl.class.getSimpleName();

    private static final String stub_wrapper = "SELF";
    private JSONObject mObject;

    public ElemJSONUnmarshalerImpl(InputStream data) {
        super(data);
    }

    public ElemJSONUnmarshalerImpl(String data) {
        super(data);
    }

    @Override
    protected void init(InputStream data) {
        String str = openFileAsString(data);
        init(str);
    }

    @Override
    protected void init(String data) {
        JSONObject json = null;
        try {
            json = new JSONObject(data);
        } catch (JSONException e) {
            Log.e(TAG, "JSONException when retriving json object from string");
        }
        mObject = json;
    }

    public ElemJSONUnmarshalerImpl(JSONObject obj) {
        super();
        mObject = obj;
    }

    public static String openFileAsString(InputStream stream) {
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader buff = new BufferedReader(isr);
        StringBuffer strBuff = new StringBuffer();
        String s;
        try {
            while ((s = buff.readLine()) != null) {
                strBuff.append(s);
            }
        } catch (IOException e) {
            Log.e(TAG, "open file as String", e);
        }
        return strBuff.toString();
    }

    @Override
    public List getChildren(String name, String ns) {
        List<ElementUnmarshaler> children = new ArrayList<ElementUnmarshaler>();
        JSONArray jarray = null;
        try {
            jarray = mObject.getJSONArray(name);
            for (int i = 0; i < jarray.length(); i++) {
                Object exp = jarray.get(i);
                if (exp instanceof JSONObject) { //TODO optimize
                    //XXX problem here if contentis string
                    children.add(new ElemJSONUnmarshalerImpl((JSONObject) exp));
                } else if (exp instanceof JSONArray) {
                    //TODO Array of Arrays
                } else if (exp instanceof String) {
                    children.add(new ElemJSONStringUnmarshalerImpl((String) exp));
                }
            }
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
        }
        return children;
    }

    @Override
    public ElementUnmarshaler getChild(String name, String ns) {
        JSONObject jobj = new JSONObject();
        try {
            jobj = mObject.getJSONObject(name);
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
            return null;
        }
        return new ElemJSONUnmarshalerImpl(jobj);
    }

    @Override
    public boolean isChildExist(String name, String ns) {
        return mObject.optJSONObject(name) != null;
    }

    @Override
    public String getValue(String name, String ns) {
        try {
            return mObject.getString(name);
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
        }
        return "";
    }

    @Override
    public String getValue() {
        try {
            return mObject.getString(stub_wrapper);
        } catch (JSONException e) {
            Log.v(TAG, "JSONException when parsing json data");
        }
        return "";
    }

    @Override
    public String getAttributeValue(String name, String ns) {
        return getValue(name, ns);
    }

}

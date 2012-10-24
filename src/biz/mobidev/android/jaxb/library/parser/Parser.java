package biz.mobidev.android.jaxb.library.parser;

import java.io.InputStream;

/**
 * User: nata
 * Date: 9/18/12
 * Time: 11:06 AM
 */
public interface Parser {
    <T> T parse(Class<T> cls, InputStream data);

    <T> T parse(Class<T> cls, String data);
}

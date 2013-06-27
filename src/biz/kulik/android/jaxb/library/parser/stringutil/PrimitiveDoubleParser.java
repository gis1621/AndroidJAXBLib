package biz.kulik.android.jaxb.library.parser.stringutil;

/**
 * User: kulik
 * Date: 6/25/13
 * Time: 7:18 PM
 */
public class PrimitiveDoubleParser extends PrimitiveParser<Double> {
    @Override
    public Double valueOf(String value) {
        try {
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
        }
        return Double.valueOf(0);
    }
}

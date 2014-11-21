package argus.filter;

import it.unimi.dsi.lang.MutableString;

/**
 * Filter class that converts diacritic words into their non-diacritic form.
 *
 * @author Eduardo Duarte (<a href="mailto:eduardo.miguel.duarte@gmail.com">eduardo.miguel.duarte@gmail.com</a>)
 * @version 1.0
 */
public class DiacriticFilter implements Filter {

    /**
     * The characters to evaluate and filter from the provided document text.
     */
    private static final char[] DIACRITICS = {
            'á', 'à', 'â', 'ã',
            'é', 'è', 'ê',
            'í', 'ì', 'î',
            'ó', 'ò', 'ô', 'õ',
            'ú', 'ù', 'û'};

    private static final char[] REPLACEMENTS = {
            'a', 'a', 'a', 'a',
            'e', 'e', 'e',
            'i', 'i', 'i',
            'o', 'o', 'o', 'o',
            'u', 'u', 'u'};

    @Override
    public void filter(MutableString documentContents) {
        documentContents.replace(DIACRITICS, REPLACEMENTS);
    }
}
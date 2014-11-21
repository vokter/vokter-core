package argus.filter;

import it.unimi.dsi.lang.MutableString;

/**
 * Simple filter class that filters some common special, non-informative
 * characters. The filtered characters are replaced by whitespaces (optimizing
 * the Tokenizer results).
 * <p/>
 * As a rule, this filter will only clear characters that do not provide much
 * information on their own, like quotation-marks and bullet-points, for example.
 * This filter, however, will NOT filter characters that provide mathematical
 * information, like +, -, =, ½, π, µ and φ.
 *
 * @author Eduardo Duarte (<a href="mailto:eduardo.miguel.duarte@gmail.com">eduardo.miguel.duarte@gmail.com</a>)
 * @version 2.0
 */
public class SpecialCharsFilter implements Filter {

    /**
     * The characters to evaluate and filter from the provided document text.
     */
    private static final char[] CHARS_TO_FILTER = {'[', ']', '(', ')',
            '_', '…', '–', '−', '.', ',', '!', '@', '#', '&',
            '/', ':', ';', '\\', '|', '\"', '\'', '”', '“', '„', '«',
            '»', '’', '‘', '′', '⏐', '•', '↔', '►', '', '', '', '', '',
            '', '', '●', '®', '¶', '♦', '→', '·', '·', '▪', '○', '', '',
            '', '', '†', '', '║', '▲', '´', '\n'};

    private static final char[] DEFAULT_REPLACEMENTS;

    static {
        int numOfChars = CHARS_TO_FILTER.length;
        DEFAULT_REPLACEMENTS = new char[numOfChars];
        for (int i = 0; i < numOfChars; i++) {
            DEFAULT_REPLACEMENTS[i] = ' ';
        }
    }

    private final char[] replacements;

    public SpecialCharsFilter() {
        this.replacements = DEFAULT_REPLACEMENTS;
    }

    public SpecialCharsFilter(char separator) {
        int numOfChars = CHARS_TO_FILTER.length;
        this.replacements = new char[numOfChars];
        for (int i = 0; i < numOfChars; i++) {
            this.replacements[i] = separator;
        }
    }

    @Override
    public void filter(MutableString documentContents) {
        // the replace implementation of mutable strings use 'indexOf' instead
        // of 'split' to perform character lookup, since char-by-char matching
        // is considerably faster than regex-pattern matching
        documentContents.replace(CHARS_TO_FILTER, replacements);
    }
}
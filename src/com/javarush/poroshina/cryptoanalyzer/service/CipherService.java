package com.javarush.poroshina.cryptoanalyzer.service;

import java.util.HashMap;

public abstract class CipherService {
    protected final char[] alphabet = new char[]{'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'к',
            'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я',
            '.', ',', '\"', ':', '!', '?', '-', ' '};

    protected final HashMap<Character, Integer> alphabetPositions = new HashMap<Character, Integer>();

    protected static final int MAX_SHIFT = 40;
    protected static final int MIN_SHIFT = 1;
}

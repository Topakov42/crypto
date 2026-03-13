package com.javarush.crypto.core;

import java.util.Map;

public class Alphabet {
    public static final Map <Character, String> TEXT_TO_CHIPHER;
    public static final Map <String , Character> CHIPHER_TO_TEXT;


    static  {
        TEXT_TO_CHIPHER = null;
        CHIPHER_TO_TEXT = null;
        //init alphabit
    }

    private Alphabet () {
        // запрет создания
    }

}

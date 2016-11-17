package com.stackoverflow.condition;

public class CaseFactory {

    public static AbstractCase getCase(boolean caseOne) {
        return caseOne ? new CaseOne() : new CaseTwo();
    }
}

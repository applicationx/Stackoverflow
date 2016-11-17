package com.stackoverflow.condition;

public abstract class AbstractCase {

    public void doLogic() {
        // Some common logic
        doSpecificLogic();
    }

    abstract void doSpecificLogic();
}

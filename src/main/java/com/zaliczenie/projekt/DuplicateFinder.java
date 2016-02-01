package com.zaliczenie.projekt;


import java.io.File;
import java.util.List;

public abstract class DuplicateFinder implements IDuplicateFinder {

    protected IDuplicateChecker checker;

    DuplicateFinder(IDuplicateChecker checker)
    {
        this.checker = checker;
    }

}

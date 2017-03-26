package com.company.task1;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Matts on 23.03.2017.
 */
public class AllowedActions extends AbstractStrings{

    public AllowedActions(){
        super(Arrays.asList("add", "delete", "modify", "clear", "hide"));
    }

}

package com.company.task1;

/**
 * Created by Matts on 23.03.2017.
 */
public class AJavaTest {


    public static void main(String[] args) {
        String networksOne = "twitter,facebook";
        String networksTwo = "facebook,youtube,blablabla";

        String andResult = new SocialMediaNetworks().and(networksOne, networksTwo);
        String orResult = new SocialMediaNetworks().or(networksTwo, networksOne);
        System.out.println(andResult + "|" + orResult);

        String actionsOne = "add,delete,qwerty";
        String actionsTwo = "delete,asdfg,update";

        andResult = new AllowedActions().and(actionsOne, actionsTwo);
        orResult = new AllowedActions().or(actionsOne, actionsTwo);
        System.out.println(andResult + "|" + orResult);
    }
}


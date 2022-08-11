package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;

public class FollowsNotFoundException extends RuntimeException {

    public FollowsNotFoundException() {
        super("doesn't follow anyone");
    }
}

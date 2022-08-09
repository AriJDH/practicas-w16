package com.bootcamp.be_java_hisp_w16_g7.exception;

public class FollowsNotFoundException extends RuntimeException{

    public FollowsNotFoundException() {
        super ("doesn't follow anyone");
    }
}

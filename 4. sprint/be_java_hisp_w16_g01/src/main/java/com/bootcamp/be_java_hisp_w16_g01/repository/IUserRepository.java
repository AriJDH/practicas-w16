package com.bootcamp.be_java_hisp_w16_g01.repository;

public interface IUserRepository {

    public void addFollower(int idUser, int idFollower);

    public void addFollowed(int idUser, int idFollowed);

    public boolean userExists(int idUser);
}

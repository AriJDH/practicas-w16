package com.meli.be_java_hisp_w16_g5.util;

import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.io.PrintWriter;

public class TestUtilGenerator {
    public static void emptyUsersFile() {

        PrintWriter writer = null;


        try {
            writer = new PrintWriter(ResourceUtils.getFile("classpath:users.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }


        writer.print("[]");
        writer.close();
    }
    public static void emptyProductsFile() {

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(ResourceUtils.getFile("classpath:product.json"));
        } catch (
                IOException e) {
            e.printStackTrace();
        }


        writer.print("[]");
        writer.close();
    }
}

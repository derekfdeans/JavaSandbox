package com.derekfdeans;

import java.io.IOException;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt").toRealPath();
        System.out.println(path);
    }
}

package Util;

import java.io.IOException;

public class FaceRecognition {
    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void faceRecognition() throws InterruptedException {
        Process pr;
        pr = null;
        try {
            if (isWindows) {
                String currentDir = System.getProperty("user.dir") + "\\src\\main\\FaceRecognition";
                String command_windows = "cd " + currentDir + " && cd ../../../../" + " && cd FaceRecognition" + " && .\\Scripts\\activate" + " && cd " + currentDir + " && python FaceRecognizer.py";
                pr = new ProcessBuilder("cmd.exe", "/c", command_windows).start();
            } else {
                String currentDir = System.getProperty("user.dir") + "/src/main/FaceRecognition";
                String command_mac = "cd " + currentDir + " && cd ../../../../" + " && cd FaceRecognition" + " && source ./bin/activate" + " && cd " + currentDir + " && python3.9 FaceRecognizer.py";
                pr = new ProcessBuilder("/bin/zsh", "-c", command_mac).start();
            }
            pr.waitFor();
            pr.exitValue();
            pr.onExit();
        } catch (IOException e) {
            System.out.println("Error open model face recognize !!");
        }
    }
    public static void main(String[] args) {
        try {
            faceRecognition();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

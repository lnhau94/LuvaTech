package Util;

import java.io.IOException;

public class FaceRecognition {
    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void faceRecognition() throws InterruptedException {
        Process pr;
        pr = null;
        try {
            if (isWindows) {
                String currentDir = System.getProperty("user.dir") + "\\python";
                String command_windows = "cd " + currentDir + " && .\\Scripts\\activate" + " && python " + currentDir + "\\FaceRecognizer.py";
                pr = new ProcessBuilder("cmd.exe", "/c", command_windows).start();
            } else {
                String currentDir = System.getProperty("user.dir") + "/python_macOs";
                String command_mac = "cd " + currentDir + " && ./bin/activate" + " && python3.9 " + currentDir + "/FaceRecognizer.py";
                pr = new ProcessBuilder("/bin/zsh", "-c", command_mac).start();
            }
            pr.waitFor();
            pr.exitValue();
            pr.onExit();
        } catch (IOException e) {
            System.out.println("Error open model face recognize !!");
        }
    }
}

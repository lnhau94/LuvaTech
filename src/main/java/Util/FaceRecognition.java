package Util;

import javafx.scene.control.Alert;

import java.io.IOException;

public class FaceRecognition {
    private static final boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
    public static void faceRecognition() throws InterruptedException {
        Process pr;
        pr = null;
        Alert myAlert = new Alert(Alert.AlertType.ERROR);
        try {
            if (isWindows) {
                String currentDir = System.getProperty("user.dir") + "\\src\\main\\FaceRecognition";
                String command_windows = "cd " + currentDir + " && cd ../../../../" + " && cd FaceRecognition" + " && .\\Scripts\\activate" + " && python FaceRecognizer.py";
                pr = new ProcessBuilder("cmd.exe", "/c", command_windows).start();
            } else {
                String currentDir = System.getProperty("user.dir") + "/src/main/FaceRecognition";
                String command_mac = "cd " + currentDir + " && cd ../../../../" + " && cd FaceRecognition" + " && source ./bin/activate" + " && python3.9 FaceRecognizer.py";
                pr = new ProcessBuilder("/bin/zsh", "-c", command_mac).start();
            }
            pr.waitFor();
            if (pr.waitFor() != 0) {
                myAlert.setHeaderText(null);
                myAlert.setContentText("Chưa có nhân viên để thực hiện nhận diện !!!");
                myAlert.showAndWait();
            }
            pr.exitValue();
            pr.onExit();
        } catch (IOException e) {
            Alert newAlert = new Alert(Alert.AlertType.ERROR);
            newAlert.setHeaderText(null);
            newAlert.setContentText("Không thể bật nhận diện bằng khuôn mặt !!!");
            newAlert.showAndWait();
            System.out.println("Error open model face recognize !!");
        }
    }
    public static void newUser() throws InterruptedException {
        Process pr;
        pr = null;
        Alert myAlert = new Alert(Alert.AlertType.ERROR);
        try {
            if (isWindows) {
                String currentDir = System.getProperty("user.dir") + "\\src\\main\\FaceRecognition";
                String command_windows = "cd " + currentDir + " && cd ../../../../" + " && cd FaceRecognition" + " && .\\Scripts\\activate" + " && python NewUser.py";
                pr = new ProcessBuilder("cmd.exe", "/c", command_windows).start();
            } else {
                String currentDir = System.getProperty("user.dir") + "/src/main/FaceRecognition";
                String command_mac = "cd " + currentDir + " && cd ../../../../" + " && cd FaceRecognition" + " && source ./bin/activate" + " && python3.9 NewUser.py";
                pr = new ProcessBuilder("/bin/zsh", "-c", command_mac).start();
            }
            pr.waitFor();
            if (pr.waitFor() != 0) {
                myAlert.setHeaderText(null);
                myAlert.setContentText("Chưa có dữ liệu của nhân viên để thực hiện lấy dữ liệu khuôn mặt !!!");
                myAlert.showAndWait();
            }
            pr.exitValue();
            pr.onExit();
        } catch (IOException e) {
            Alert newAlert = new Alert(Alert.AlertType.ERROR);
            newAlert.setHeaderText(null);
            newAlert.setContentText("Không thể lấy dữ liệu bằng khuôn mặt !!!");
            newAlert.showAndWait();
            System.out.println("Can not create new User");
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

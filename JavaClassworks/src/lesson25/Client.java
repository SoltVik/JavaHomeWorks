package lesson25;

public class Client {
    public static void main(String[] args) {
        Camera camera = new Camera();
        CameraRoll colorCameraRoll = new ColorCameraRoll();
        camera.setCameraRoll(colorCameraRoll);
        camera.doPhotograph();

        CameraRoll blackAndWhiteCameraRoll = new BlackAndWhiteCameraRoll();
        camera.setCameraRoll(blackAndWhiteCameraRoll);
        camera.doPhotograph();
    }
}

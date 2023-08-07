import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.opencv.highgui.HighGui;

public class webcamCapture {
    public static void main(String[] args) {
        // Загрузите библиотеку OpenCV
        // System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // метод не сработал: вероятно, требуется настройка пути
        nu.pattern.OpenCV.loadShared(); // аналогичный метод - сработал



        // Создайте объект VideoCapture для захвата видео с веб-камеры
        VideoCapture capture = new VideoCapture(0); // 0 - индекс вашей веб-камеры

        // Проверьте, удалось ли открыть видео поток
        if (!capture.isOpened()) {
            System.out.println("Ошибка при открытии веб-камеры.");
            return;
        }

        // Бесконечный цикл для захвата и обработки кадров
        while (true) {
            Mat frame = new Mat();
            if (capture.read(frame)) {
                // Ваш код обработки кадра
                // Например, вывод кадра на экран:
                HighGui.imshow("Webcam", frame);
                HighGui.waitKey(10);
            } else {
                System.out.println("Не удалось прочитать кадр.");
                break;
            }
        }

        // Закрыть захват видео при выходе из цикла
        capture.release();
    }
}

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(new FileTest("Z:\\Redis-x64-3.2.100").ls());

    }
}
class FileTest{
    private File file;

    public FileTest(String path) {
        this.file = new File(path);
    }

    public String ls(){
        if (file.isFile()){
            return file.getName();
        }else if (file.isDirectory()){
            String[] list = file.list();
            StringBuilder stringBuilder = new StringBuilder();
            for (String s:list){
                stringBuilder.append(s+"  ");
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public void mkdir(){
        try {
            boolean newFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

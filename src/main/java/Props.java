import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Props {
    public String pathToProperties;

    public Props(String pathToProperties) {
        this.pathToProperties = pathToProperties;
    }

    public Properties getProp(){
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(pathToProperties)){
            prop.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}

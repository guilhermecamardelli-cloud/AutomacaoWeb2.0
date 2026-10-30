package Framework.Utils;

import java.io.*;
import java.util.Properties;

public class FileOperations {

    //Arquivos fixos do projeto (url, usuario)
    private static final String DIR_PATH_PROPERTIES =
            System.getProperty("user.dir") + File.separator + "src" + File.separator +
                    "main" + File.separator + "resources" + File.separator +
                    "Properties" + File.separator;

    //Arquivos gerados durante o teste (dados do formulario) ficam na target, para nao alterar o codigo a cada execucao
    private static final String DIR_PATH_GERADOS =
            System.getProperty("user.dir") + File.separator + "target" + File.separator +
                    "Properties" + File.separator;

    //Metodo para pegar dados dos arquivos de properties (procura primeiro nos gerados)
    public static Properties getProperties(String fileName){

        Properties prop = new Properties();
        File file = new File(DIR_PATH_GERADOS + fileName + ".properties");
        if (!file.exists()) {
            file = new File(DIR_PATH_PROPERTIES + fileName + ".properties");
        }

        try (InputStream input = new FileInputStream(file)) {

            prop.load(input);

        } catch (IOException e) {

            throw new UncheckedIOException("Nao foi possivel carregar o arquivo de propriedade " + file, e);
        }

        return prop;
    }

    //Metodo para salvar os dados em arquivos de properties
    public static void setProperties(String fileName, String propKey, String propValue){

        File file = new File(DIR_PATH_GERADOS + fileName + ".properties");
        file.getParentFile().mkdirs();

        Properties prop = file.exists() ? getProperties(fileName) : new Properties();
        prop.setProperty(propKey, propValue);

        try (OutputStream output = new FileOutputStream(file)) {

            prop.store(output, null);

        } catch (IOException e) {

            throw new UncheckedIOException("Nao foi possivel salvar o arquivo de propriedade " + file, e);
        }
    }
}

package util;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Mohammad Muntakim
 */
public class ConfigReader {

    private String url;
    private String chromeDriverPath;
    private String amazon_url;
    private String dark_sky_url;
    private String hotels_url;

    public ConfigReader() {

        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            this.url = prop.getProperty("url");
            this.chromeDriverPath = prop.getProperty("chrome_driver_path");
            this.amazon_url = prop.getProperty("amazon_url");
            this.dark_sky_url = prop.getProperty("dark_sky_url");
            this.hotels_url = prop.getProperty("hotels_url");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String getUrl() {

        return url;
    }

    public String getChromeDriverPath() {

        return chromeDriverPath;
    }

    public String getAmazon_url() {
        return amazon_url;
    }

    public String getDark_sky_url() {
        return dark_sky_url;
    }

    public String getHotels_url() {
        return hotels_url;
    }
}


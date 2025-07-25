import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;
import org.json.JSONObject;

public class WeatherApp extends JFrame {
    private JTextField cityField;
    private JTextArea resultArea;
    private final String API_KEY = "5432733448e14ca39d1105651252407"; // Replace with your WeatherAPI key

    public WeatherApp() {
        setTitle("Weather App");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Enter City:");
        cityField = new JTextField(20);
        JButton getWeatherBtn = new JButton("Get Weather");
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JPanel topPanel = new JPanel();
        topPanel.add(label);
        topPanel.add(cityField);
        topPanel.add(getWeatherBtn);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        getWeatherBtn.addActionListener(e -> fetchWeather());
    }

    private void fetchWeather() {
        String city = cityField.getText().trim();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a city name.");
            return;
        }

        try {
            String urlString = "https://api.weatherapi.com/v1/current.json?key=" +
                    API_KEY + "&q=" + URLEncoder.encode(city, "UTF-8");

            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder json = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            reader.close();
            displayWeatherData(json.toString());

        } catch (Exception ex) {
            resultArea.setText("Error fetching weather data.\n" + ex.getMessage());
        }
    }

    private void displayWeatherData(String jsonString) {
        try {
            JSONObject obj = new JSONObject(jsonString);
            JSONObject location = obj.getJSONObject("location");
            JSONObject current = obj.getJSONObject("current");
            JSONObject condition = current.getJSONObject("condition");

            String cityName = location.getString("name");
            String country = location.getString("country");
            double tempC = current.getDouble("temp_c");
            double feelsLikeC = current.getDouble("feelslike_c");
            int humidity = current.getInt("humidity");
            double precip = current.getDouble("precip_mm");
            double windKph = current.getDouble("wind_kph");
            String conditionText = condition.getString("text");

            resultArea.setText(
                    "City           : " + cityName + ", " + country +
                            "\nTemperature    : " + tempC + " °C" +
                            "\nFeels Like     : " + feelsLikeC + " °C" +
                            "\nHumidity       : " + humidity + "%" +
                            "\nPrecipitation  : " + precip + " mm" +
                            "\nWind Speed     : " + windKph + " kph" +
                            "\nCondition      : " + conditionText
            );
        } catch (Exception e) {
            resultArea.setText("Failed to parse weather data.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WeatherApp().setVisible(true);
        });
    }
}

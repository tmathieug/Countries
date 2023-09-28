import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Frame {
    public static void main(String[] args){
        FrameCentered myframe = new FrameCentered();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setVisible(true);
    }
    static class FrameCentered extends JFrame{
        private final JTextField textField;
        private final JTextArea textArea;
        public FrameCentered(){
            //Configuración de la ventana
            Toolkit screen=Toolkit.getDefaultToolkit();
            Dimension screenSize = screen.getScreenSize();
            int screenHeight = screenSize.height;
            int screenWidth = screenSize.width;
            setSize(screenWidth/2,screenHeight/2);
            setLocation(screenWidth/4, screenHeight/4);
            setTitle("Búsqueda de Países");
            Image myIcon = screen.getImage("world.png");
            setIconImage(myIcon);
            //Creación del input
            JLabel label = new JLabel("Introduzca un continente para buscar:");
            textField = new JTextField(20);
            //Creación del botón
            JButton button = new JButton("Buscar");
            //Panel necesario para ver los componentes
            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(textField);
            panel.add(button);
            //Creacion de un area para mostrar la lista de países
            textArea = new JTextArea(10,30);
            textArea.setEditable(false);
            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(panel, BorderLayout.NORTH);
            getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
            //Creación de un HashMap de continentes y países
            HashMap<String, List<String>> countriesContinents = new HashMap<>();
            countriesContinents.put("africa", Arrays.asList("Argelia", "Angola", "Benín", "Botsuana", "Burkina Faso", "Burundi", "Cabo Verde", "Camerún", "Chad", "Comoras", "Congo", "Costa de Marfil", "Egipto", "Eritrea", "Esuatini", "Etiopía", "Gabón", "Gambia", "Ghana", "Guinea", "Guinea-Bisáu", "Guinea Ecuatorial", "Kenia", "Lesoto", "Liberia", "Libia", "Madagascar", "Malaui", "Malí", "Marruecos", "Mauricio", "Mauritania", "Mozambique", "Namibia", "Níger", "Nigeria", "R.D. del Congo", "Ruanda", "Sahara Occidental", "Santa Elena", "Santo Tomé y Príncipe", "Senegal", "Seychelles", "Sierra Leona", "Somalia", "Sudáfrica", "Sudán", "Sudán del Sur", "Tanzania", "Togo", "Túnez", "Uganda", "Yibuti", "Zambia", "Zimbabue"));
            countriesContinents.put("america", Arrays.asList("Antigua y Barbuda", "Argentina", "Bahamas", "Barbados", "Belice", "Bolivia", "Brasil", "Canadá", "Chile", "Colombia", "Costa Rica", "Cuba", "Dominica", "Ecuador", "El Salvador", "Estados Unidos", "Granada", "Guatemala", "Guyana", "Haití", "Honduras", "Jamaica", "México", "Nicaragua", "Panamá", "Paraguay", "Perú", "República Dominicana", "San Cristóbal y Nieves", "Santa Lucía", "San Vicente y las Granadinas", "Surinam", "Trinidad y Tobago", "Uruguay", "Venezuela"));
            countriesContinents.put("asia", Arrays.asList("Afganistán", "Arabia Saudita", "Armenia", "Azerbaiyán", "Bangladés", "Baréin", "Birmania (Myanmar)", "Brunéi", "Bután", "Camboya", "Catar", "China", "Chipre", "Corea del Norte", "Corea del Sur", "Emiratos Árabes Unidos", "Filipinas", "Georgia", "India", "Indonesia", "Irak", "Irán", "Israel", "Japón", "Jordania", "Kazajistán", "Kirguistán", "Kuwait", "Laos", "Líbano", "Malasia", "Maldivas", "Mongolia", "Nepal", "Omán", "Pakistán", "Palestina", "Singapur", "Siria", "Sri Lanka", "Tailandia", "Tayikistán", "Turkmenistán", "Turquía", "Uzbekistán", "Vietnam", "Yemen"));
            countriesContinents.put("europa", Arrays.asList("Albania", "Alemania", "Andorra", "Austria", "Bélgica", "Bielorrusia", "Bosnia y Herzegovina", "Bulgaria", "Chipre", "Croacia", "Dinamarca", "Eslovaquia", "Eslovenia", "España", "Estonia", "Finlandia", "Francia", "Grecia", "Hungría", "Irlanda", "Islandia", "Italia", "Kosovo", "Letonia", "Liechtenstein", "Lituania", "Luxemburgo", "Macedonia del Norte", "Malta", "Moldavia", "Mónaco", "Montenegro", "Noruega", "Países Bajos (Holanda)", "Polonia", "Portugal", "Reino Unido", "República Checa", "Rumania", "Rusia", "San Marino", "Serbia", "Suecia", "Suiza", "Ucrania", "Vaticano (Ciudad del Vaticano)"));
            countriesContinents.put("oceania", Arrays.asList("Australia", "Fiyi", "Islas Marshall", "Islas Salomón", "Kiribati", "Micronesia", "Nauru", "Nueva Zelanda", "Palaos", "Papúa Nueva Guinea", "Samoa", "Timor Oriental", "Tonga", "Tuvalu", "Vanuatu"));
            //Configuración del botón
            button.addActionListener(e -> {
                String inputText = textField.getText();
                String cleanedInput = inputText.toLowerCase()
                        .replace("á","a")
                        .replace("é","e")
                        .replace("í","i")
                        .replace("ó","o")
                        .replace("ú","u");
                if (countriesContinents.containsKey(cleanedInput)) {
                    List<String> countries = countriesContinents.get(cleanedInput);
                    StringBuilder message = new StringBuilder("Países en " + inputText + ":\n");
                    for (String country : countries) {
                        message.append(country).append("\n");
                    }
                    textArea.setText(message.toString());
                    textArea.setCaretPosition(0);
                } else {
                    textArea.setText("Ingrese un continente válido");
                }
            });
        }
    }
}
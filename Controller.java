package sample;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;






public class Controller {

    int ActionListener;
    int taskChoice;
    int age;
    int n;
    private Scanner scanner;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text text;

    @FXML
    private ImageView image;

    @FXML
    private Button getData1;

    @FXML
    private Button getData2;

    @FXML
    private Button getData3;

    @FXML
    private Button getData4;

    @FXML
    private Button getData5;

    @FXML
    private Button getData6;

    @FXML
    private Button getData7;

    @FXML
    private Button getData8;

    @FXML
    private Button getData9;

    @FXML
    void initialize(ActionEvent event) {

    }

    @FXML
    void initialize() {




        getData1.setOnAction(event -> {
            String choice = JOptionPane.showInputDialog(
                    null,
                    "Что бы вы хотели вывести?\nВведите 1 для 'Hello World!' или 2 для вопросов об имени и возрасте:",
                    "Выберите вывод",
                    JOptionPane.QUESTION_MESSAGE
            );

            if ("1".equals(choice)) {

                String message = "Hello World!";
                JOptionPane.showMessageDialog(null, message, "Приветствие", JOptionPane.INFORMATION_MESSAGE);
            } else if ("2".equals(choice)) {
                String ageInput = JOptionPane.showInputDialog("Пожалуйста, введите ваш возраст:");

                try {
                    age = Integer.parseInt(ageInput);

                    String nameInput = JOptionPane.showInputDialog("Пожалуйста, введите ваше имя:");
                    if (nameInput != null && !nameInput.isEmpty()) {
                        String outputOption = JOptionPane.showInputDialog(
                                null,
                                "Введите 1 для вывода в отдельное окно или 2 для вывода в консоль:",
                                "Выберите вывод",
                                JOptionPane.QUESTION_MESSAGE
                        );

                        if ("1".equals(outputOption)) {

                            String message = "Ваше имя: " + nameInput + "\nВаш возраст: " + age;
                            JOptionPane.showMessageDialog(null, message, "Информация о пользователе", JOptionPane.INFORMATION_MESSAGE);
                        } else if ("2".equals(outputOption)) {

                            System.out.println("Ваше имя: " + nameInput);
                            System.out.println("Ваш возраст: " + age);
                        } else {
                            JOptionPane.showMessageDialog(null, "Неправильный выбор вывода!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Вы не ввели имя!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Неправильный формат возраста!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }
        });





        getData2.setOnAction(event -> {
            String[] arrayTypeOptions = {"1. Одномерный массив", "2. Двумерный массив"};
            int arrayTypeChoice = JOptionPane.showOptionDialog(
                    null,
                    "Выберите тип массива:",
                    "Выбор задания",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    arrayTypeOptions,
                    arrayTypeOptions[0]
            );

            if (arrayTypeChoice == 0) {
                // Выбрано одномерное задание
                String[] taskOptions = {"1. Задание 1", "2. Задание 2"};
                int taskChoice = JOptionPane.showOptionDialog(
                        null,
                        "Выберите задание для одномерного массива:",
                        "Выбор задания",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        taskOptions,
                        taskOptions[0]
                );

                if (taskChoice == 0) {
                    Random random = new Random();
                    // Выбрано первое задание для одномерного массива
                    // Генерируем случайный массив чисел
                    int[] array = new int[10]; // Измените размер массива по вашему усмотрению
                    for (int i = 0; i < array.length; i++) {
                        array[i] = random.nextInt(100); // Генерируйте числа в нужном диапазоне
                    }

                    // Запрашиваем у пользователя числа a и b
                    int a = Integer.parseInt(JOptionPane.showInputDialog("Введите число a: "));
                    int b = Integer.parseInt(JOptionPane.showInputDialog("Введите число b: "));

                    // Создаем копию массива для сохранения исходного состояния
                    int[] originalArray = Arrays.copyOf(array, array.length);

                    // Заменяем элементы массива, удовлетворяющие условию
                    for (int i = a; i <= b; i++) {
                        if (i >= 0 && i < array.length && array[i] % 2 == 0) {
                            if (i == 0) {
                                array[i] += array[i + 1];
                            } else if (i == array.length - 1) {
                                array[i] += array[i - 1];
                            } else {
                                array[i] = array[i - 1] + array[i + 1];
                            }
                        }
                    }

                    // Выводим оба массива в отдельном окне
                    JOptionPane.showMessageDialog(null,
                            "Исходный массив: " + Arrays.toString(originalArray) +
                                    "\nНовый массив: " + Arrays.toString(array),
                            "Результат",
                            JOptionPane.INFORMATION_MESSAGE);
                } else if (taskChoice == 1) {
                    // Выбрано второе задание для одномерного массива
                    Random random = new Random();

                    // Задайте размер массива
                    int size = 10; // Измените размер массива по вашему усмотрению

                    // Создайте и заполните массив случайными числами
                    int[] array = new int[size];
                    for (int i = 0; i < size; i++) {
                        array[i] = random.nextInt(100); // Генерируйте числа в нужном диапазоне
                    }

                    // Подсчет количества четных элементов на четных позициях
                    int count = 0;
                    for (int i = 0; i < size; i += 2) {
                        if (array[i] % 2 == 0) {
                            count++;
                        }
                    }

                    // Вывод результата в отдельном окне
                    JOptionPane.showMessageDialog(null,
                            "Сгенерированный массив: " + java.util.Arrays.toString(array) +
                                    "\nКоличество четных элементов на четных позициях: " + count,
                            "Результат",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (arrayTypeChoice == 1) {
                // Выбрано двумерное задание
                String[] taskOptions = {"1. Задание 1", "2. Задание 2"};
                int taskChoice = JOptionPane.showOptionDialog(
                        null,
                        "Выберите задание для двумерного массива:",
                        "Выбор задания",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        taskOptions,
                        taskOptions[0]
                );

                if (taskChoice == 0) {
                    // Выбрано первое задание для двумерного массива
                    System.out.println("Выбрано первое задание для двумерного массива");

                    int size = Integer.parseInt(JOptionPane.showInputDialog("Введите размер магического квадрата: "));
                    int[][] magicSquare = new int[size][size]; // Исправление здесь
                    int row = 0;
                    int col = size / 2;

                    for (int num = 1; num <= size * size; num++) {
                        magicSquare[row][col] = num;
                        row--;
                        col++;

                        if (num % size == 0) {
                            row += 2;
                            col--;
                        } else {
                            if (row < 0) row = size - 1;
                            if (col == size) col = 0;
                        }
                    }

                    SwingUtilities.invokeLater(() -> {
                        JFrame frame = new JFrame("Магический квадрат");
                        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                        JPanel panel = new JPanel(new GridLayout(size, size));

                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                JLabel label = new JLabel(Integer.toString(magicSquare[i][j]));
                                label.setHorizontalAlignment(JLabel.CENTER);
                                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                                panel.add(label);
                            }
                        }

                        frame.add(panel);
                        frame.pack();
                        frame.setVisible(true);
                    });
                } else if (taskChoice == 1) {
                    // Выбрано второе задание для двумерного массива
                    String[] inputOptions = {"1. Ввести матрицу вручную", "2. Автоматическое заполнение"};
                    int inputChoice = JOptionPane.showOptionDialog(
                            null,
                            "Выберите способ заполнения матрицы:",
                            "Выбор способа",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            inputOptions,
                            inputOptions[0]
                    );

                    int size = Integer.parseInt(JOptionPane.showInputDialog("Введите размер квадратной матрицы: "));

                    // Создаем квадратную матрицу и заполняем ее
                    int[][] matrix = new int[size][size];
                    if (inputChoice == 0) {
                        // Ввод матрицы вручную
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Введите элемент матрицы [" + i + "][" + j + "]: "));
                            }
                        }
                    } else {
                        // Автоматическое заполнение случайными числами
                        for (int i = 0; i < size; i++) {
                            for (int j = 0; j < size; j++) {
                                matrix[i][j] = (int) (Math.random() * 100); // Здесь генерируйте числа в нужном диапазоне
                            }
                        }
                    }

                    // Выводим матрицу для главной диагонали
                    JFrame mainDiagonalFrame = new JFrame("Матрица (Главная диагональ)");
                    mainDiagonalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    mainDiagonalFrame.setSize(300, 300);

                    JTextArea mainDiagonalTextArea = new JTextArea();
                    mainDiagonalTextArea.setEditable(false);
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            if (i == j) {
                                mainDiagonalTextArea.append(matrix[i][j] + "\t");
                            } else {
                                mainDiagonalTextArea.append(" \t");
                            }
                        }
                        mainDiagonalTextArea.append("\n");
                    }

                    mainDiagonalFrame.add(new JScrollPane(mainDiagonalTextArea));
                    mainDiagonalFrame.setVisible(true);

                    // Выводим матрицу для побочной диагонали
                    JFrame secondaryDiagonalFrame = new JFrame("Матрица (Побочная диагональ)");
                    secondaryDiagonalFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    secondaryDiagonalFrame.setSize(300, 300);

                    JTextArea secondaryDiagonalTextArea = new JTextArea();
                    secondaryDiagonalTextArea.setEditable(false);
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            if (i + j == size - 1) {
                                secondaryDiagonalTextArea.append(matrix[i][j] + "\t");
                            } else {
                                secondaryDiagonalTextArea.append(" \t");
                            }
                        }
                        secondaryDiagonalTextArea.append("\n");
                    }

                    secondaryDiagonalFrame.add(new JScrollPane(secondaryDiagonalTextArea));
                    secondaryDiagonalFrame.setVisible(true);

                    // Выводим всю матрицу в отдельном окне
                    JFrame matrixFrame = new JFrame("Матрица (Вся матрица)");
                    matrixFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    matrixFrame.setSize(400, 400);

                    JTextArea matrixTextArea = new JTextArea();
                    matrixTextArea.setEditable(false);
                    for (int i = 0; i < size; i++) {
                        for (int j = 0; j < size; j++) {
                            matrixTextArea.append(matrix[i][j] + "\t");
                        }
                        matrixTextArea.append("\n");
                    }

                    matrixFrame.add(new JScrollPane(matrixTextArea));
                    matrixFrame.setVisible(true);
                }}});


        getData3.setOnAction(event ->{
            String[] arrayTypeOptions = {"Задание 1", "Задание 2", "Задание 3", "Задание 4", "Задние 5", "Задание 6"};

            int arrayTypeChoice = JOptionPane.showOptionDialog(
                    null,
                    "Выберите задание:",
                    "Выбор задания",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    arrayTypeOptions,
                    arrayTypeOptions[0]
            );

            if (arrayTypeChoice == 0) {
                String inputString = JOptionPane.showInputDialog("Введите строку для инверсии:");

                if (inputString != null) {
                    String reversedString = "";

                    for (int i = inputString.length() - 1; i >= 0; i--) {
                        reversedString += inputString.charAt(i);
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Исходная строка: " + inputString + "\nИнверсированная строка: " + reversedString,
                            "Результат инверсии",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }

            }
           else if (arrayTypeChoice == 1){
                JFrame frame = new JFrame("Подсчет символов");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 150);

                JPanel panel = new JPanel();
                JLabel inputLabel = new JLabel("Введите текст:");
                JTextField inputField = new JTextField(20);
                JLabel charLabel = new JLabel("Введите символ:");
                JTextField charField = new JTextField(1);
                JButton countButton = new JButton("Подсчитать");
                JLabel resultLabel = new JLabel();

                countButton.addActionListener(e -> {
                    String text = inputField.getText();
                    String charToCount = charField.getText();

                    int count = 0;
                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) == charToCount.charAt(0)) {
                            count++;
                        }
                    }

                    resultLabel.setText("Символ '" + charToCount + "' встречается " + count + " раз(а)");
                });

                panel.add(inputLabel);
                panel.add(inputField);
                panel.add(charLabel);
                panel.add(charField);
                panel.add(countButton);
                panel.add(resultLabel);

                frame.add(panel);
                frame.setVisible(true);
            }
          else  if (arrayTypeChoice == 2){
                // Ввод текста из окна
                String text = JOptionPane.showInputDialog("Введите текст:");

                // Разделение текста на слова
                String[] words = text.split("\\s+");

                // Запрос пользователя о способе вывода
                int choice = JOptionPane.showOptionDialog(
                        null,
                        "Выберите способ вывода:",
                        "Выбор вывода",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new String[]{"Консоль", "Окно"},
                        "Консоль"
                );

                if (choice == JOptionPane.YES_OPTION) {
                    // Вывод текста в консоли
                    for (String word : words) {
                        System.out.println(word);
                    }
                } else {
                    // Вывод текста в окне
                    StringBuilder resultText = new StringBuilder("Слова из текста:\n");
                    for (String word : words) {
                        resultText.append(word).append("\n");
                    }
                    JOptionPane.showMessageDialog(null, resultText.toString());
            }}
            else if (arrayTypeChoice == 3){
                SwingUtilities.invokeLater(() -> {
                    JFrame frame = new JFrame("Дата и время");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setSize(400, 100);
                    frame.setLayout(new FlowLayout());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

                    Calendar currentCalendar = Calendar.getInstance();
                    Date currentDate = currentCalendar.getTime();
                    JLabel currentLabel = new JLabel("Текущая дата и время: " + dateFormat.format(currentDate));

                    Calendar futureCalendar = Calendar.getInstance();
                    futureCalendar.add(Calendar.SECOND, 1000000);
                    Date futureDate = futureCalendar.getTime();
                    JLabel futureLabel = new JLabel("Дата и время через 1 000 000 секунд: " + dateFormat.format(futureDate));

                    frame.add(currentLabel);
                    frame.add(futureLabel);

                    frame.setVisible(true);
                });
            }
           else if (arrayTypeChoice == 4){
                // Устанавливаем начальную и конечную даты интервала времени
                Calendar startDate = Calendar.getInstance();
                startDate.set(2023, Calendar.JANUARY, 1); // Начальная дата
                Calendar endDate = Calendar.getInstance();
                endDate.set(2023, Calendar.DECEMBER, 31); // Конечная дата

                // Создаем экземпляр класса Random для генерации случайной даты в интервале
                Random random = new Random();

                // Генерируем случайную дату в заданном интервале времени
                long startTimeInMillis = startDate.getTimeInMillis();
                long endTimeInMillis = endDate.getTimeInMillis();
                long randomTimeInMillis = startTimeInMillis + (long) (random.nextDouble() * (endTimeInMillis - startTimeInMillis));
                Calendar randomDate = Calendar.getInstance();
                randomDate.setTimeInMillis(randomTimeInMillis);

                // Определяем день недели для сгенерированной даты
                int dayOfWeek = randomDate.get(Calendar.DAY_OF_WEEK);

                // Преобразуем числовое значение дня недели в строку
                String[] daysOfWeek = {"Воскресенье", "Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота"};
                String dayOfWeekStr = daysOfWeek[dayOfWeek - 1]; // -1, так как нумерация начинается с воскресенья

                // Выводим результат

                JOptionPane.showMessageDialog(null, "Случайная дата: " + randomDate.getTime() + "\nДень недели: " + dayOfWeekStr);


            }
           else if (arrayTypeChoice == 5){
                JFrame frame = new JFrame("Выбор даты");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 200);

                JPanel panel = new JPanel(new BorderLayout());

                // Группа Radio-кнопок для выбора режима ввода
                JPanel radioPanel = new JPanel();
                JRadioButton randomButton = new JRadioButton("Случайная дата");
                JRadioButton manualButton = new JRadioButton("Ввести вручную");
                ButtonGroup group = new ButtonGroup();
                group.add(randomButton);
                group.add(manualButton);
                radioPanel.add(randomButton);
                radioPanel.add(manualButton);
                panel.add(radioPanel, BorderLayout.NORTH);

                // Панель для ввода даты
                JPanel inputPanel = new JPanel(new GridLayout(3, 2));
                JTextField yearField = new JTextField(4);
                JTextField monthField = new JTextField(2);
                JTextField dayField = new JTextField(2);
                inputPanel.add(new JLabel("Год:"));
                inputPanel.add(yearField);
                inputPanel.add(new JLabel("Месяц (1-12):"));
                inputPanel.add(monthField);
                inputPanel.add(new JLabel("День месяца:"));
                inputPanel.add(dayField);
                panel.add(inputPanel, BorderLayout.CENTER);

                // Кнопка для показа результата
                JButton submitButton = new JButton("Показать формат");
                panel.add(submitButton, BorderLayout.SOUTH);

                // Обработчик выбора режима ввода
                randomButton.addActionListener(e -> {
                    yearField.setEnabled(false);
                    monthField.setEnabled(false);
                    dayField.setEnabled(false);
                });

                manualButton.addActionListener(e -> {
                    yearField.setEnabled(true);
                    monthField.setEnabled(true);
                    dayField.setEnabled(true);
                });

                // Обработчик нажатия кнопки
                submitButton.addActionListener(e -> {
                    if (randomButton.isSelected()) {
                        // Генерация случайной даты
                        Random random = new Random();
                        int year = 1900 + random.nextInt(100); // Год от 1900 до 1999
                        int month = 1 + random.nextInt(12); // Месяц от 1 до 12
                        int day = 1 + random.nextInt(31); // День от 1 до 31
                        String formattedDate = year + ", " + month + ", " + day;
                        JOptionPane.showMessageDialog(null, "Дата в формате год, месяц, день месяца: " + formattedDate);
                    } else if (manualButton.isSelected()) {
                        try {
                            int year = Integer.parseInt(yearField.getText());
                            int month = Integer.parseInt(monthField.getText());
                            int day = Integer.parseInt(dayField.getText());

                            boolean isValidDate = year >= 1 && month >= 1 && month <= 12 && day >= 1 && day <= 31;

                            if (isValidDate) {
                                String formattedDate = year + ", " + month + ", " + day;
                                JOptionPane.showMessageDialog(null, "Дата в формате год, месяц, день месяца: " + formattedDate);
                            } else {
                                JOptionPane.showMessageDialog(null, "Введенная дата некорректна.");
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Пожалуйста, введите числовые значения.");
                        }
                    }
                });

                // По умолчанию выбран режим случайной даты
                randomButton.setSelected(true);
                yearField.setEnabled(false);
                monthField.setEnabled(false);
                dayField.setEnabled(false);

                frame.add(panel);
                frame.setVisible(true);
            }
        });
        getData4.setOnAction(event -> {
            String[] arrayTypeOptions = {"Задание 1", "Задание 2"};

            int arrayTypeChoice = JOptionPane.showOptionDialog(
                    null,
                    "Выберите задание:",
                    "Выбор задания",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    arrayTypeOptions,
                    arrayTypeOptions[0]
            );

            if (arrayTypeChoice == 0) {


                Garage garage = new Garage();
                JFrame frame = new JFrame("Гараж");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(new GridLayout(4, 1));

                JPanel addButtonPanel = new JPanel();
                JPanel showButtonPanel = new JPanel();
                JPanel removeButtonPanel = new JPanel();
                JPanel exitButtonPanel = new JPanel();

                JButton addButton = new JButton("Добавить машину");
                JButton showButton = new JButton("Вывести информацию о машинах");
                JButton removeButton = new JButton("Удалить машину");
                JButton exitButton = new JButton("Выход");

                addButtonPanel.add(addButton);
                showButtonPanel.add(showButton);
                removeButtonPanel.add(removeButton);
                exitButtonPanel.add(exitButton);

                frame.add(addButtonPanel);
                frame.add(showButtonPanel);
                frame.add(removeButtonPanel);
                frame.add(exitButtonPanel);

                addButton.addActionListener(e -> {
                    String model = JOptionPane.showInputDialog("Введите модель машины:");
                    String yearStr = JOptionPane.showInputDialog("Введите год выпуска:");
                    int year = Integer.parseInt(yearStr);
                    garage.addCar(new Model(model));
                    garage.addCar(new YearOfManufacture(year));
                    JOptionPane.showMessageDialog(null, "Машина добавлена в гараж.");
                });

                showButton.addActionListener(e -> {
                    List<Cars> allCars = garage.filterCarsByType(Cars.class);
                    StringBuilder carsInfo = new StringBuilder("Информация о машинах:\n");
                    for (Cars car : allCars) {
                        if (car instanceof Model) {
                            carsInfo.append("Модель: ").append(((Model) car).getModelName()).append("\n");
                        } else if (car instanceof YearOfManufacture) {
                            carsInfo.append("Год выпуска: ").append(((YearOfManufacture) car).getYear()).append("\n");
                        }
                    }
                    JOptionPane.showMessageDialog(null, carsInfo.toString());

                });

                removeButton.addActionListener(e -> {
                    String modelToRemove = JOptionPane.showInputDialog("Введите модель машины, которую хотите удалить:");
                    garage.removeCar(new Model(modelToRemove));
                    JOptionPane.showMessageDialog(null, "Машина удалена из гаража.");
                });

                exitButton.addActionListener(e -> System.exit(0));

                frame.setVisible(true);
            }







            else  if (arrayTypeChoice == 1){
                int taskChoice = Integer.parseInt(JOptionPane.showInputDialog(
                        "Выберите способ ввода данных:\n" +
                                "1. Автоматический ввод\n" +
                                "2. Ввод вручную"
                ));

                Aircraft[] aircrafts;
                if (taskChoice == 1) {
                    // Автоматический ввод
                    aircrafts = new Aircraft[]{
                            new Airplane(),
                            new Airplane(),
                            new Helicopter(),
                            new Airplane(),
                            new Helicopter()
                    };
                } else if (taskChoice == 2) {
                    // Ввод вручную
                    int numAircrafts = Integer.parseInt(JOptionPane.showInputDialog("Введите количество летательных аппаратов:"));
                    aircrafts = new Aircraft[numAircrafts];
                    for (int i = 0; i < numAircrafts; i++) {
                        String aircraftType = JOptionPane.showInputDialog("Введите тип летательного аппарата (1 - Самолет, 2 - Вертолет):");
                        if (aircraftType.equals("1")) {
                            aircrafts[i] = new Airplane();
                        } else if (aircraftType.equals("2")) {
                            aircrafts[i] = new Helicopter();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Неверный выбор.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Airline airline = new Airline(aircrafts);

                int airplaneCount = airline.countAirplanes();
                int helicopterCount = airline.countHelicopters();

                JOptionPane.showMessageDialog(null,
                        "Количество самолетов: " + airplaneCount + "\n" +
                                "Количество вертолетов: " + helicopterCount,
                        "Информация о летательных аппаратах",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        getData5.setOnAction(event ->{
            JOptionPane.showMessageDialog(null, "В случае не вывода JavaDoc документа, ужно зайти ввв файл Controller.java, и ввести путь к файлу Main.html, который лежит в архиве", "Сообшение для корректной работы", JOptionPane.ERROR_MESSAGE );
            // Путь к HTML-файлу
            String filePath = "E:\\VseLabyNew\\src\\sample\\jvadoc\\sample\\Main.html";

            // Создаем объект Desktop
            Desktop desktop = Desktop.getDesktop();

            try {
                // Проверяем поддерживается ли открытие файлов на данной платформе
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    // Создаем объект File для HTML-файла
                    File htmlFile = new File(filePath);

                    // Открываем HTML-файл в браузере по умолчанию
                    desktop.open(htmlFile);
                } else {
                    System.out.println("Открытие файлов не поддерживается на данной платформе.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        getData6.setOnAction(event ->{
            // Показать диалоговое окно для выбора способа ввода
            String[] inputOptions = {"Ввести данные вручную", "Заполнить случайными значениями"};
            int inputChoice = JOptionPane.showOptionDialog(
                    null,
                    "Выберите способ ввода данных",
                    "Выбор ввода данных",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    inputOptions,
                    inputOptions[0]
            );

            // Переменные для хранения данных о фигурах
            String triangleColor;
            double triangleBase;
            double triangleHeight;
            String squareColor;
            double squareSide;
            String circleColor;
            double circleRadius;

            if (inputChoice == 0) {
                // Ввод данных вручную

                // Ввод цвета и размеров треугольника с клавиатуры
                triangleColor = JOptionPane.showInputDialog("Введите цвет треугольника:");
                triangleBase = Double.parseDouble(JOptionPane.showInputDialog("Введите основание треугольника:"));
                triangleHeight = Double.parseDouble(JOptionPane.showInputDialog("Введите высоту треугольника:"));

                // Ввод цвета и размеров квадрата с клавиатуры
                squareColor = JOptionPane.showInputDialog("Введите цвет квадрата:");
                squareSide = Double.parseDouble(JOptionPane.showInputDialog("Введите длину стороны квадрата:"));

                // Ввод цвета и размеров круга с клавиатуры
                circleColor = JOptionPane.showInputDialog("Введите цвет круга:");
                circleRadius = Double.parseDouble(JOptionPane.showInputDialog("Введите радиус круга:"));
            } else {
                // Автоматическое заполнение случайными значениями

                // Массив из случайных названий цветов
                String[] colorNames = {
                        "Красный", "Синий", "Зеленый", "Желтый", "Оранжевый",
                        "Фиолетовый", "Розовый", "Серый", "Черный", "Белый"
                };

                Random random = new Random();

                // Случайный индекс в массиве colorNames для выбора случайного названия цвета
                int randomIndex = random.nextInt(colorNames.length);
                triangleColor = colorNames[randomIndex];
                triangleBase = Math.random() * 10 + 1;
                triangleHeight = Math.random() * 10 + 1;

                randomIndex = random.nextInt(colorNames.length);
                squareColor = colorNames[randomIndex];
                squareSide = Math.random() * 10 + 1;

                randomIndex = random.nextInt(colorNames.length);
                circleColor = colorNames[randomIndex];
                circleRadius = Math.random() * 10 + 1;
            }

            // Создание объектов геометрических фигур с введенными данными
            Triangle triangle = new Triangle(triangleColor, triangleBase, triangleHeight);
            Square square = new Square(squareColor, squareSide);
            Circle circle = new Circle(circleColor, circleRadius);

            // Вычисление площади треугольника и вывод информации с заголовком
            triangle.calculateArea();
            triangle.displayInfo("Площадь треугольника");

            // Вывод информации о квадрате и круге с заголовками
            square.displayInfo("Площадь квадрата");
            circle.displayInfo("Площадь круга");



            // Показать диалоговое окно для выбора операции
            String[] options = {"Сложение", "Вычитание", "Умножение", "Деление"};
            int selectedOption = JOptionPane.showOptionDialog(
                    null,
                    "Выберите операцию",
                    "Выбор операции",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            double result = 0;

            // Выполнение выбранной операции
            if (selectedOption == 0) {
                // Сложение
                result = square.area + circle.area;
            } else if (selectedOption == 1) {
                // Вычитание
                result = square.area - circle.area;
            } else if (selectedOption == 2) {
                // Умножение
                result = square.area * circle.area;
            } else if (selectedOption == 3) {
                // Деление (проверка деления на ноль)
                if (circle.area != 0) {
                    result = square.area / circle.area;
                } else {
                    JOptionPane.showMessageDialog(null, "Деление на ноль невозможно!");
                    return;
                }
            }

            // Вывести результат операции
            JOptionPane.showMessageDialog(null, "Результат операции: " + result);
        });
        getData7.setOnAction(event ->{
            String[] arrayTypeOptions = {"Задание 1(после вывода окна поятните для изменения размера чтобы увидеть текст)", "Задание 2"};

            int arrayTypeChoice = JOptionPane.showOptionDialog(
                    null,
                    "Выберите задание:",
                    "Выбор задания",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    arrayTypeOptions,
                    arrayTypeOptions[0]
            );

            if (arrayTypeChoice == 0) {
                // Создаем главное окно (JFrame)
                JFrame frame = new JFrame("Сообщение");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Завершение приложения при закрытии окна
                frame.setSize(800, 600); // Устанавливаем размер окна
                frame.setVisible(true); // Делаем окно видимым

                // Создаем панель (JPanel) для размещения компонентов
                JPanel panel = new JPanel();
                BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
                panel.setLayout(boxLayout);

                // Создаем текстовую область (JTextArea) с начальным текстом
                JTextArea messageTextArea = new JTextArea(
                        "1. JFrame:\n" +
                                "   • Класс для создания главного окна приложения.\n" +
                                "   • Метод setDefaultCloseOperation(int operation) устанавливает операцию, которая выполняется при закрытии окна. JFrame.EXIT_ON_CLOSE означает завершение приложения при закрытии окна.\n" +
                                "   • Метод setSize(int width, height) устанавливает размер окна.\n" +
                                "   • Метод setVisible(boolean visible) делает окно видимым.\n" +
                                "   • Метод pack() упаковывает окно для оптимального размера, основываясь на содержимом.\n" +
                                "   • Метод setMinimumSize(Dimension minimumSize) устанавливает минимальный размер окна.\n" +
                                "2. JPanel:\n" +
                                "   • Класс для создания панелей, которые могут содержать другие компоненты.\n" +
                                "   • Метод setLayout(LayoutManager layout) устанавливает менеджер компоновки для панели.\n" +
                                "3. JButton:\n" +
                                "   • Класс для создания кнопок.\n" +
                                "   • Метод JButton(String text) создает кнопку с указанным текстом.\n" +
                                "4. JLabel:\n" +
                                "   • Класс для создания меток (надписей).\n" +
                                "   • Метод JLabel(String text) создает метку с указанным текстом.\n" +
                                "5. JCheckBox:\n" +
                                "   • Класс для создания флажков (чекбоксов).\n" +
                                "   • Метод JCheckBox(String text) создает флажок с указанным текстом.\n" +
                                "6. JRadioButton:\n" +
                                "   • Класс для создания радиокнопок.\n" +
                                "   • Метод JRadioButton(String text) создает радиокнопку с указанным текстом.\n" +
                                "7. ButtonGroup:\n" +
                                "   • Класс для группировки радиокнопок, чтобы они работали как единое целое.\n" +
                                "8. JTextArea:\n" +
                                "   • Класс для создания многострочных текстовых полей.\n" +
                                "9. JTextField:\n" +
                                "   • Класс для создания однострочных текстовых полей.\n" +
                                "10. JScrollPane:\n" +
                                "    • Класс, который обеспечивает прокрутку для других компонентов, таких как JTextArea или JList.\n" +
                                "11. JList:\n" +
                                "    • Класс для создания списка элементов.\n" +
                                "12. JComboBox:\n" +
                                "    • Класс для создания выпадающего списка.\n" +
                                "13. JTable:\n" +
                                "    • Класс для создания таблиц.\n" +
                                "14. BoxLayout:\n" +
                                "    • Менеджер компоновки, который управляет расположением компонентов по вертикали или горизонтали.\n" +
                                "15. GridLayout:\n" +
                                "    • Менеджер компоновки, который размещает компоненты в виде сетки с указанным числом строк и столбцов.\n" +
                                "16. FlowLayout:\n" +
                                "    • Менеджер компоновки, который размещает компоненты последовательно в направлении, определенном ориентацией контейнера.\n" +
                                "17. BoxLayout:\n" +
                                "    • Менеджер компоновки, который управляет расположением компонентов по вертикали или горизонтали.");

                messageTextArea.setEditable(false); // Делаем текстовую область только для чтения

                // Добавляем текстовую область на панель
                panel.add(messageTextArea);

                // Создаем панель прокрутки и добавляем текстовую область в нее
                JScrollPane scrollPane = new JScrollPane(messageTextArea);
                panel.add(scrollPane);

                // Добавляем панель на главное окно
                frame.add(panel);
            }
            else if (arrayTypeChoice == 1){
                JFrame frame = new JFrame("Меню на Java");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 200);

                JPanel leftPanel = new JPanel(new GridLayout(9, 1));
                JPanel rightPanel = new JPanel(new GridLayout(9, 1));
                JPanel centerPanel = new JPanel(new GridLayout(9, 1));

                Map<JButton, String> buttonSelections = new HashMap<>();
                List<JRadioButton> selectedRadioButtons = new ArrayList<>();

                for (int i = 1; i <= 9; i++) {
                    JButton leftButton = new JButton("Кнопка " + i);
                    leftButton.addActionListener(e -> {
                        buttonSelections.put((JButton) e.getSource(), ((JButton) e.getSource()).getText());
                    });
                    leftPanel.add(leftButton);

                    JRadioButton radioButton = new JRadioButton("Пункт " + i);
                    radioButton.addActionListener(e -> {
                        if (radioButton.isSelected()) {
                            selectedRadioButtons.add(radioButton);
                        } else {
                            selectedRadioButtons.remove(radioButton);
                        }
                    });
                    rightPanel.add(radioButton);
                }

                JButton selectButtonForButtons = new JButton("Выбрать кнопку");
                selectButtonForButtons.addActionListener(e -> {
                    StringBuilder selectedButtons = new StringBuilder();
                    for (String button : buttonSelections.values()) {
                        selectedButtons.append(button).append(", ");
                    }
                    if (selectedButtons.length() > 0) {
                        selectedButtons.setLength(selectedButtons.length() - 2);
                    } else {
                        selectedButtons.append("Ничего не выбрано");
                    }
                    JOptionPane.showMessageDialog(frame, "Выбраны кнопки: " + selectedButtons.toString());
                });
                centerPanel.add(selectButtonForButtons);

                JButton selectButtonForRadioButtons = new JButton("Выбрать пункт");
                selectButtonForRadioButtons.addActionListener(e -> {
                    StringBuilder selectedRadioButtonsText = new StringBuilder();
                    for (JRadioButton radioButton : selectedRadioButtons) {
                        selectedRadioButtonsText.append(radioButton.getText()).append(", ");
                    }
                    if (selectedRadioButtonsText.length() > 0) {
                        selectedRadioButtonsText.setLength(selectedRadioButtonsText.length() - 2);
                    } else {
                        selectedRadioButtonsText.append("Ничего не выбрано");
                    }
                    JOptionPane.showMessageDialog(frame, "Выбраны пункты: " + selectedRadioButtonsText.toString());
                });
                centerPanel.add(selectButtonForRadioButtons);

                frame.add(leftPanel, BorderLayout.WEST);
                frame.add(centerPanel, BorderLayout.CENTER);
                frame.add(rightPanel, BorderLayout.EAST);

                frame.setVisible(true);
            }


        });
        getData8.setOnAction(event ->{
            String[] arrayTypeOptions = {"Задание 1(после вывода окна поятните для изменения размера чтобы увидеть текст)", "Задание 2"};

            int arrayTypeChoice = JOptionPane.showOptionDialog(
                    null,
                    "Выберите задание:",
                    "Выбор задания",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    arrayTypeOptions,
                    arrayTypeOptions[0]
            );
            if (arrayTypeChoice == 0) {  // Создаем главное окно (JFrame)
                JFrame frame = new JFrame("Сообщение");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Завершение приложения при закрытии окна
                frame.setSize(800, 600); // Устанавливаем размер окна
                frame.setVisible(true); // Делаем окно видимым

                // Создаем панель (JPanel) для размещения компонентов
                JPanel panel = new JPanel();
                BoxLayout boxLayout = new BoxLayout(panel, BoxLayout.Y_AXIS);
                panel.setLayout(boxLayout);

                // Создаем текстовую область (JTextArea) с начальным текстом
                JTextArea messageTextArea = new JTextArea(
                        "Слушатель ChangeListener реагирует на изменение состояния объекта. Каждый\n" +
                                "       элемент управления по-своему определяет понятие «изменение состояния».\n" +
                                "       Например, для панели со вкладками JTabbedPane это переход на другую\n" +
                                "       вкладку, для ползунка JSlider — изменение его положения, кнопка JButton\n" +
                                "       рассматривает как смену состояния щелчок на ней. Таким образом, хотя\n" +
                                "       событие это достаточно общее, необходимо уточнять его специфику для\n" +
                                "       каждого конкретного компонента.\n" +
                                "Слушатель MouseWheelListener оповещается при вращении колесика мыши в\n" +
                                "       тот момент, когда данный компонент находится в фокусе.");

                messageTextArea.setEditable(false); // Делаем текстовую область только для чтения

                // Добавляем текстовую область на панель
                panel.add(messageTextArea);

                // Создаем панель прокрутки и добавляем текстовую область в нее
                JScrollPane scrollPane = new JScrollPane(messageTextArea);
                panel.add(scrollPane);

                // Добавляем панель на главное окно
                frame.add(panel);}

            else if (arrayTypeChoice == 1){

                    new MyFrame();


        }});
        getData9.setOnAction(event -> {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new DrawingApp();
                }
            });
        });

    }}


class Aircraft {
    public Aircraft() {
    }
}

class Airplane extends Aircraft {
    public Airplane() {
    }
}

class Helicopter extends Aircraft {
    public Helicopter() {
    }
}

class Airline {
    private Aircraft[] aircrafts;

    public Airline(Aircraft[] aircrafts) {
        this.aircrafts = aircrafts;
    }

    public int countAirplanes() {
        int count = 0;
        for (Aircraft aircraft : aircrafts) {
            if (aircraft instanceof Airplane) {
                count++;
            }
        }
        return count;
    }

    public int countHelicopters() {
        int count = 0;
        for (Aircraft aircraft : aircrafts) {
            if (aircraft instanceof Helicopter) {
                count++;
            }
        }
        return count;
    }
}

// Базовый класс - Машины
class Cars {

    // Конструктор по умолчанию
    public Cars() {

    }
}

// Производный класс - Модель
class Model extends Cars {
    private String modelName;

    public Model(String modelName) {
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }
}

// Производный класс - Год выпуска
class YearOfManufacture extends Cars {
    private int year;

    public YearOfManufacture(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}

// Класс Гараж
class Garage {
    private List<Cars> carsList;

    public Garage() {
        carsList = new ArrayList<>();
    }

    // Добавление машины в гараж
    public void addCar(Cars car) {
        carsList.add(car);
    }

    // Удаление машины из гаража
    public void removeCar(Cars car) {
        carsList.remove(car);
    }

    // Фильтрация машин по типу (классу)
    public List<Cars> filterCarsByType(Class<? extends Cars> carType) {
        return carsList.stream()
                .filter(carType::isInstance)
                .collect(Collectors.toList());
    }

    // Вывод информации о машинах в отдельном окне
    public void showCarsInfo(List<Cars> cars) {
        StringBuilder message = new StringBuilder("Информация о машинах:\n");
        for (Cars car : cars) {
            if (car instanceof Model) {
                message.append("Модель: ").append(((Model) car).getModelName()).append("\n");
            } else if (car instanceof YearOfManufacture) {
                message.append("Год выпуска: ").append(((YearOfManufacture) car).getYear()).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Информация о машинах", JOptionPane.INFORMATION_MESSAGE);
    }

}

// Абстрактный класс Figure
abstract class Figure {
     String color;
     double area;
    private static String[] generateRandomColors(int count) {
        String[] colors = new String[count];
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
            colors[i] = String.format("#%02x%02x%02x", randomColor.getRed(), randomColor.getGreen(), randomColor.getBlue());
        }

        return colors;
    }
    public Figure(String color, double area) {
        this.color = color;
        this.area = area;
    }

    public abstract void displayInfo();
}

// Классы для геометрических фигур
class Triangle extends Figure {
    private double base;
    private double height;
    public void displayInfo(String title) {
        JOptionPane.showMessageDialog(null, "Треугольник: Цвет = " + color + ", Площадь = " + area, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public Triangle(String color, double base, double height) {
        super(color, 0); // Площадь треугольника будет вычислена позже
        this.base = base;
        this.height = height;
    }

    @Override
    public void displayInfo() {
        JOptionPane.showMessageDialog(null, "Треугольник: Цвет = " + super.color + ", Площадь = " + super.area);
    }

    // Метод для вычисления площади треугольника
    public void calculateArea() {
        super.area = 0.5 * base * height;
    }
}

class Square extends Figure {
    private double side;
    public void displayInfo(String title) {
        JOptionPane.showMessageDialog(null, "Квадрат: Цвет = " + color + ", Площадь = " + area, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public Square(String color, double side) {
        super(color, side * side);
        this.side = side;
    }

    @Override
    public void displayInfo() {
        JOptionPane.showMessageDialog(null, "Квадрат: Цвет = " + super.color + ", Площадь = " + super.area);
    }
}

class Circle extends Figure {
    private double radius;

    public void displayInfo(String title) {
        JOptionPane.showMessageDialog(null, "Круг: Цвет = " + color + ", Площадь = " + area, title, JOptionPane.INFORMATION_MESSAGE);
    }
    public Circle(String color, double radius) {
        super(color, Math.PI * radius * radius);
        this.radius = radius;
    }

    @Override
    public void displayInfo() {
        JOptionPane.showMessageDialog(null, "Круг: Цвет = " + super.color + ", Площадь = " + super.area);
    }
}

// Интерфейс для операций над площадями
interface AreaOperation {
    double performOperation(double area1, double area2);
}

// Класс, выполняющий операции над площадями фигур
class AreaCalculator implements AreaOperation {
    @Override
    public double performOperation(double area1, double area2) {
        return area1 * area2; // Пример операции, можно заменить на другую
    }
}

 class MyFrame extends JFrame {
    public MyFrame() {
        super("Меню на Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JPanel leftPanel = new JPanel(new GridLayout(9, 1));
        JPanel rightPanel = new JPanel(new GridLayout(9, 1));
        JPanel centerPanel = new JPanel(new GridLayout(9, 1));

        Map<JButton, String> buttonSelections = new HashMap<>();
        List<JRadioButton> selectedRadioButtons = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            JButton leftButton = new JButton("Кнопка " + i);
            leftButton.addActionListener(e -> {
                buttonSelections.put((JButton) e.getSource(), ((JButton) e.getSource()).getText());
            });
            leftPanel.add(leftButton);

            JRadioButton radioButton = new JRadioButton("Пункт " + i);
            radioButton.addActionListener(e -> {
                if (radioButton.isSelected()) {
                    selectedRadioButtons.add(radioButton);
                } else {
                    selectedRadioButtons.remove(radioButton);
                }
            });
            rightPanel.add(radioButton);
        }

        JButton selectButtonForButtons = new JButton("Выбрать кнопку");
        selectButtonForButtons.addActionListener(e -> {
            StringBuilder selectedButtons = new StringBuilder();
            for (String button : buttonSelections.values()) {
                selectedButtons.append(button).append(", ");
            }
            if (selectedButtons.length() > 0) {
                selectedButtons.setLength(selectedButtons.length() - 2);
            } else {
                selectedButtons.append("Ничего не выбрано");
            }
            JOptionPane.showMessageDialog(this, "Выбраны кнопки: " + selectedButtons.toString());
        });
        centerPanel.add(selectButtonForButtons);

        JButton selectButtonForRadioButtons = new JButton("Выбрать пункт");
        selectButtonForRadioButtons.addActionListener(e -> {
            StringBuilder selectedRadioButtonsText = new StringBuilder();
            for (JRadioButton radioButton : selectedRadioButtons) {
                selectedRadioButtonsText.append(radioButton.getText()).append(", ");
            }
            if (selectedRadioButtonsText.length() > 0) {
                selectedRadioButtonsText.setLength(selectedRadioButtonsText.length() - 2);
            } else {
                selectedRadioButtonsText.append("Ничего не выбрано");
            }
            JOptionPane.showMessageDialog(this, "Выбраны пункты: " + selectedRadioButtonsText.toString());
        });
        centerPanel.add(selectButtonForRadioButtons);

        // Добавление слушателя для кнопки, вывод текста в отдельном окне
        JTextField textField = new JTextField(20);
        JButton textButton = new JButton("Вывести текст в поле");
        textButton.addActionListener(e -> {
            String text = textField.getText();
            JOptionPane.showMessageDialog(this, "Введенный текст: " + text);
        });
        JPanel textPanel = new JPanel();
        textPanel.add(textField);
        textPanel.add(textButton);
        centerPanel.add(textPanel);

        // Добавление метки с изменением цвета фона при наведении
        JLabel mouseLabel = new JLabel("Наведите курсор мыши на эту метку");
        mouseLabel.setOpaque(true);
        mouseLabel.setBackground(Color.WHITE);
        mouseLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseLabel.setText("Курсор мыши наведен!");
                mouseLabel.setBackground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseLabel.setText("Наведите курсор мыши на эту метку");
                mouseLabel.setBackground(Color.WHITE);
            }
        });
        centerPanel.add(mouseLabel);

        // Добавление слушателя для изменения размера окна с помощью JSlider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        JLabel sliderLabel = new JLabel("Значение ползунка: 0");
        slider.addChangeListener(e -> {
            int sliderValue = slider.getValue();
            sliderLabel.setText("Значение ползунка: " + sliderValue);
            setSize(600 + sliderValue, 400 + sliderValue);
        });
        JPanel sliderPanel = new JPanel();
        sliderPanel.add(slider);
        sliderPanel.add(sliderLabel);
        centerPanel.add(sliderPanel);

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        setVisible(true);
    }}




 class DrawingApp {
    private JFrame frame;
    private JPanel drawingPanel;
    private JPanel shapePanel;
    private JComboBox<String> shapeComboBox;
    private JComboBox<String> colorComboBox;
    private String selectedShape = "Круг"; // Фигура по умолчанию
    private Color selectedColor = Color.BLUE; // Цвет по умолчанию
    private List<ShapeData> shapesData = new ArrayList<>();
    private ShapeData currentShapeData;

    public DrawingApp() {
        frame = new JFrame("Программа для рисования");
        frame.setLayout(new BorderLayout());

        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Рисование всех фигур
                for (ShapeData shapeData : shapesData) {
                    g.setColor(shapeData.getColor());
                    int x = shapeData.getX();
                    int y = shapeData.getY();
                    int width = shapeData.getWidth();
                    int height = shapeData.getHeight();
                    if (shapeData.getShapeType().equals("Круг")) {
                        g.fillOval(x, y, width, height);
                    } else if (shapeData.getShapeType().equals("Прямоугольник")) {
                        g.fillRect(x, y, width, height);
                    } else if (shapeData.getShapeType().equals("Треугольник")) {
                        int[] xPoints = {x, x + width, x + width / 2};
                        int[] yPoints = {y + height, y + height, y};
                        g.fillPolygon(xPoints, yPoints, 3);
                    } else if (shapeData.getShapeType().equals("Эллипс")) {
                        g.fillOval(x, y, width, height);
                    } else if (shapeData.getShapeType().equals("Линия")) {
                        g.drawLine(x, y, x + width, y + height);
                    } else if (shapeData.getShapeType().equals("Звезда")) {
                        int[] xPoints = {x, x + width / 2, x + width, x + width / 4, x + width * 3 / 4};
                        int[] yPoints = {y + height / 2, y + height, y + height / 2, y, y};
                        g.fillPolygon(xPoints, yPoints, 5);
                    }
                    // Добавьте другие фигуры здесь, например, шестиугольники, пятиугольники, овалы и так далее.
                }
            }
        };

        drawingPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX();
                int y = e.getY();
                currentShapeData = new ShapeData(selectedShape, selectedColor, x, y);
                shapesData.add(currentShapeData);
                drawingPanel.repaint();
            }
        });

        drawingPanel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (currentShapeData != null) {
                    int x = e.getX();
                    int y = e.getY();
                    currentShapeData.setWidth(x - currentShapeData.getX());
                    currentShapeData.setHeight(y - currentShapeData.getY());
                    drawingPanel.repaint();
                }
            }
        });

        shapePanel = new JPanel();
        shapeComboBox = new JComboBox<>(new String[]{"Круг", "Прямоугольник", "Треугольник", "Эллипс", "Линия", "Звезда"});
        colorComboBox = new JComboBox<>(new String[]{"Синий", "Красный", "Зеленый", "Желтый", "Оранжевый", "Розовый", "Фиолетовый", "Голубой", "Пурпурный", "Черный"});

        shapeComboBox.addActionListener(e -> selectedShape = (String) shapeComboBox.getSelectedItem());

        colorComboBox.addActionListener(e -> {
            String selectedColorStr = (String) colorComboBox.getSelectedItem();
            selectedColor = getColorByName(selectedColorStr);
        });

        shapePanel.add(new JLabel("Выберите фигуру:"));
        shapePanel.add(shapeComboBox);
        shapePanel.add(new JLabel("Выберите цвет:"));
        shapePanel.add(colorComboBox);

        frame.add(drawingPanel, BorderLayout.CENTER);
        frame.add(shapePanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ShapeData {
        private String shapeType;
        private Color color;
        private int x;
        private int y;
        private int width;
        private int height;

        public ShapeData(String shapeType, Color color, int x, int y) {
            this.shapeType = shapeType;
            this.color = color;
            this.x = x;
            this.y = y;
            this.width = 0;
            this.height = 0;
        }

        public String getShapeType() {
            return shapeType;
        }

        public Color getColor() {
            return color;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

     private Color getColorByName(String colorName) {
         switch (colorName) {
             case "Синий":
                 return Color.BLUE;
             case "Красный":
                 return Color.RED;
             case "Зеленый":
                 return Color.GREEN;
             case "Желтый":
                 return Color.YELLOW;
             case "Оранжевый":
                 return Color.ORANGE;
             case "Розовый":
                 return Color.PINK;
             case "Фиолетовый":
                 return new Color(128, 0, 128); // Фиолетовый
             case "Голубой":
                 return Color.CYAN;
             case "Пурпурный":
                 return Color.MAGENTA;
             case "Черный":
                 return Color.BLACK;
             default:
                 return Color.BLUE; // Цвет по умолчанию
        }}}

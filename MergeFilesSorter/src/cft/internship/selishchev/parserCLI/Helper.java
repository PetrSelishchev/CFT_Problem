package cft.internship.selishchev.parserCLI;

public class Helper {
    public static void help() {
        System.out.printf("Параметры программы задаются при запуске через аргументы командной строки, по порядку:%n" +
                "1. режим сортировки (-a или -d), необязательный, по умолчанию сортируем по возрастанию;%n" +
                "2. тип данных (-s или -i), обязательный;%n" +
                "3. имя выходного файла, обязательное;%n" +
                "4. остальные параметры – имена входных файлов, не менее одного.%n" +
                "Примеры запуска из командной строки cmd для Windows 10 :%n" +
                "C:\\path\\to\\your\\directory>java -jar CFT_Problem.jar -i -a out.txt in.txt (для целых чисел по возрастанию)%n" +
                "C:\\path\\to\\your\\directory>java -jar CFT_Problem.jar -s out.txt in1.txt in2.txt in3.txt (для строк по возрастанию)%n" +
                "C:\\path\\to\\your\\directory>java -jar CFT_Problem.jar -d -s out.txt in1.txt in2.txt (для строк по убыванию)%n"
                );
    }

    public static void getHelpCommand() {
        System.out.printf("Пример запуска справки из командной строки для Windows 10:" +
                " C:\\path\\to\\your\\directory>java -jar CFT_Problem.jar -help ");

          }
}

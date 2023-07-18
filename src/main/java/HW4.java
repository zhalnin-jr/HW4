import java.util.ArrayList;
import java.util.Scanner;

public class HW4 {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> firstName = new ArrayList<>();
        ArrayList<String> secondName = new ArrayList<>();
        ArrayList<String> lastName = new ArrayList<>();
        ArrayList<Integer> age = new ArrayList<>();
        ArrayList<String> sex = new ArrayList<>();
        boolean flag = true;

        while (flag) {
            System.out.println("""
          Выберите действие: \s
          1 - выход
          2 - просмотреть все контакты
          3 - записать новый контакт
          4 - сортировка по возрасту
          5 - сортировка по полу""");
            switch (scanner.nextLine()) {
                case "1" : flag = false;
                break;
                case "2" : {
                    System.out.println("=".repeat(120));
                    for (int i = 0; i < count; i++) {
                        System.out.printf("%d %s %s %s %d %s\n",
                                id.get(i), firstName.get(i), secondName.get(i),
                                lastName.get(i), age.get(i), sex.get(i));
                    }
                    System.out.println("=".repeat(120));
                }
                break;
                case "3" : {
                    id.add(count++);
                    System.out.print("Введите имя: ");
                    firstName.add(scanner.nextLine());
                    System.out.print("Введите отчество: ");
                    secondName.add(scanner.nextLine());
                    System.out.print("Введите фамилию: ");
                    lastName.add(scanner.nextLine());
                    System.out.print("Введите возраст: ");
                    age.add(scanner.hasNextInt() ? scanner.nextInt() : -1);
                    scanner.nextLine();
                    System.out.print("Введите пол w - женский, m - мужской: ");
                    sex.add(scanner.nextLine().equals("w") ? "woman" : "man");
                }
                case "4" : {
                    int tmp;
                    for (int j = 0; j < age.size(); j++) {
                        for (int i = 0; i < age.size() - 1; i++) {
                            if (age.get(i + 1) > age.get(i)) {
                                tmp = age.get(i + 1);
                                age.set(i + 1, age.get(i));
                                age.set(i, tmp);
                                tmp = id.get(i + 1);
                                id.set(i + 1, id.get(i));
                                id.set(i, tmp);
                            }
                        }
                    }

                    firstName = HW4.changeIdStr(id, firstName);
                    secondName = HW4.changeIdStr(id, secondName);
                    lastName = HW4.changeIdStr(id, lastName);
                    sex = HW4.changeIdStr(id, sex);
                }
                case "5" : {
                    int tmp;
                    String tmps;
                    for (int j = 0; j < sex.size(); j++) {
                        for (int i = 0; i < sex.size() - 1; i++) {
                            if (sex.get(i + 1).equals("woman") & sex.get(i).equals("man")) {
                                tmps = sex.get(i + 1);
                                sex.set(i + 1, sex.get(i));
                                sex.set(i, tmps);
                                tmp = id.get(i + 1);
                                id.set(i + 1, id.get(i));
                                id.set(i, tmp);
                            }
                        }
                    }
                    firstName = HW4.changeIdStr(id, firstName);
                    secondName = HW4.changeIdStr(id, secondName);
                    lastName = HW4.changeIdStr(id, lastName);
                    age = HW4.changeIdInt(id, age);
                }
            }

        }
        scanner.close();
    }

    static ArrayList<String> changeIdStr(ArrayList<Integer> id, ArrayList<String> arrStr) {
        ArrayList<String> sorted = new ArrayList<>();
        for (Integer integer : id) {
            sorted.add(arrStr.get(integer));
        }
        return sorted;
    }

    static ArrayList<Integer> changeIdInt(ArrayList<Integer> id,
                                          ArrayList<Integer> arrStr) {
        ArrayList<Integer> sorted = new ArrayList<>();
        for (Integer integer : id) {
            sorted.add(arrStr.get(integer));
        }
        return sorted;
    }
}
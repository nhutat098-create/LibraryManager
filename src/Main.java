import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static BookManager manager = new BookManager();

    public static void main(String[] args) {
        while (true) {
            showmenu();
            try {
                int choice = readInt("Moi chon: ");

                switch (choice) {
                    case 1 -> hiends(manager.allbook());
                    case 2 -> add();
                    case 3 -> findid();
                    case 4 -> update();
                    case 5 -> delete();
                    case 0 -> {
                        System.out.println("bye");
                        return;
                    }
                    default -> System.out.println("lua chon khong hop le");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap SO!");
            } catch (IllegalArgumentException e) {
                System.out.println("Loi du lieu: " + e.getMessage());
            } catch (ArithmeticException e) {
                System.out.println("Gia tri vuot gioi han cho phep");
            } catch (java.util.NoSuchElementException e) {
                break;                              // het du lieu nhap thi thoat
            }
        }
    }

    // ===== Doc du lieu: luon doc ca dong, khong bi troi dong =====
    private static String readText(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int readInt(String prompt) {
        return Integer.parseInt(readText(prompt));
    }

    private static long readLong(String prompt) {
        return Long.parseLong(readText(prompt));
    }

    private static void showmenu() {
        System.out.println("\n=========== BOOK ==============");
        System.out.println("1. Danh sach");
        System.out.println("2. Them sach");
        System.out.println("3. Tim sach theo ID");
        System.out.println("4. Cap nhat sach");
        System.out.println("5. Xoa sach");
        System.out.println("0. Thoat");
        System.out.println("===============================");
    }

    private static void hiends(List<book> books) {
        if (books.isEmpty()) {
            System.out.println("danh sach rong");
            return;
        }
        for (book x : books) {
            System.out.println(x);
        }
    }

    private static void add() {
        String title = readText("Nhap title: ");
        long gia = readLong("Nhap gia: ");
        int quantity = readInt("Nhap so luong: ");

        book sach = manager.add(title, gia, quantity);
        System.out.println("Them sach thanh cong. ID: " + sach.getId());
    }

    private static void findid() {
        int id = readInt("Nhap id: ");
        book sach = manager.findID(id);

        if (sach == null) {
            System.out.println("Khong tim thay sach");
        } else {
            System.out.println(sach);
        }
    }

    private static void update() {
        int id = readInt("Nhap id can sua: ");
        book sach = manager.findID(id);

        if (sach == null) {
            System.out.println("Khong tim thay sach");
            return;
        }

        System.out.println(sach);
        String title = readText("Nhap title moi: ");
        long gia = readLong("Nhap gia moi: ");
        int quantity = readInt("Nhap so luong moi: ");

        manager.update(id, title, gia, quantity);
        System.out.println("Cap nhat thanh cong");
    }

    private static void delete() {
        int id = readInt("Nhap id can xoa: ");
        book sach = manager.findID(id);

        if (sach == null) {
            System.out.println("Khong tim thay sach");
            return;
        }

        System.out.println(sach);
        String chon = readText("Ban co muon xoa khong (y/n): ");

        if (chon.equalsIgnoreCase("y")) {
            manager.delete(id);
            System.out.println("Da xoa thanh cong");
        } else {
            System.out.println("Da huy");
        }
    }
}
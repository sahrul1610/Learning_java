package menu;

import java.util.InputMismatchException;
import java.util.Scanner;
import model.EmployeeManager;
import model.Placement;
import perent.Employee;
import model.EmployeeGeneral;
import chlid.Programmer;
import chlid.Analyst;
import chlid.ProjectLeader;
import interfaces.Menu;

public class AddEmployeeMenu implements Menu {
    private EmployeeManager employeeManager;

    public AddEmployeeMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nTambah Data Karyawan");
        System.out.println("Pilih jenis pekerjaan:");
        System.out.println("1. Employee General");
        System.out.println("2. Programmer");
        System.out.println("3. Analyst");
        System.out.println("4. Project Leader");

        int choice;
        while (true) {
            try {
                System.out.print("Masukkan pilihan: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Buang karakter newline

                switch (choice) {
                    case 1:
                        addEmployeeGeneral(scanner);
                        return;
                    case 2:
                        addProgrammer(scanner);
                        return;
                    case 3:
                        addAnalyst(scanner);
                        return;
                    case 4:
                        addProjectLeader(scanner);
                        return;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.nextLine(); 
            }
        }
    }

    private void addEmployeeGeneral(Scanner scanner) {
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Alamat: ");
        String address = scanner.nextLine();
        int age = 0;
        while (true) {
            try {
                System.out.print("Umur: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Umur harus lebih besar dari 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan umur yang valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Deskripsi Pekerjaan: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Penempatan: ");
        String placementCity = scanner.nextLine();
        Placement placement = new Placement(placementCity);

        String employeeId = generateEmployeeId("Emp");
        employeeManager.addEmployee(new EmployeeGeneral(name, address, age, employeeId, jobDesc, placement));
        System.out.println("\n Employee data add successfully.");
    }

    private void addProgrammer(Scanner scanner) {
        // Input data untuk Programmer
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Alamat: ");
        String address = scanner.nextLine();
        int age = 0;
        while (true) {
            try {
                System.out.print("Umur: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Umur harus lebih besar dari 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan umur yang valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Deskripsi Pekerjaan: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Penempatan: ");
        String placementCity = scanner.nextLine();
        Placement placement = new Placement(placementCity);
        System.out.print("Bahasa Pemrograman: ");
        String programmingLanguage = scanner.nextLine();
        int experiences = 0;
        while (true) {
            try {
                System.out.print("Pengalaman: ");
                experiences = Integer.parseInt(scanner.nextLine());
                if (experiences < 0) {
                    throw new IllegalArgumentException("Pengalaman tidak dapat negatif.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan pengalaman yang valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        // Generate employeeId
        String employeeId = generateEmployeeId("Prog");

        // Buat objek Programmer dan tambahkan ke EmployeeManager
        employeeManager.addEmployee(
                new Programmer(employeeId, name, address, age, jobDesc, placement, programmingLanguage, experiences));
        System.out.println("\n Employee data add successfully.");
    }

    private void addAnalyst(Scanner scanner) {
        // Input data untuk Analyst
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Alamat: ");
        String address = scanner.nextLine();
        int age = 0;
        while (true) {
            try {
                System.out.print("Umur: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Umur harus lebih besar dari 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan umur yang valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Deskripsi Pekerjaan: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Penempatan: ");
        String placementCity = scanner.nextLine();
        Placement placement = new Placement(placementCity);
        String employeeId = generateEmployeeId("AL");
        employeeManager.addEmployee(new Analyst(employeeId, name, address, age, jobDesc, placement));
        System.out.println("\n Employee data add successfully.");
    }

    private void addProjectLeader(Scanner scanner) {
        System.out.print("Nama: ");
        String name = scanner.nextLine();
        System.out.print("Alamat: ");
        String address = scanner.nextLine();
        int age = 0;
        while (true) {
            try {
                System.out.print("Umur: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age <= 0) {
                    throw new IllegalArgumentException("Umur harus lebih besar dari 0.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan umur yang valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Deskripsi Pekerjaan: ");
        String jobDesc = scanner.nextLine();
        System.out.print("Penempatan: ");
        String placementCity = scanner.nextLine();
        Placement placement = new Placement(placementCity);
        int totalProjects = 0;
        while (true) {
            try {
                System.out.print("Total Proyek yang Dikelola: ");
                totalProjects = Integer.parseInt(scanner.nextLine());
                if (totalProjects < 0) {
                    throw new IllegalArgumentException("Total proyek tidak dapat negatif.");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan total proyek yang valid.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String employeeId = generateEmployeeId("PL");
        employeeManager
                .addEmployee(new ProjectLeader(employeeId, name, address, age, jobDesc, placement, totalProjects));
        System.out.println("\n Employee data add successfully.");
    }

    private String generateEmployeeId(String prefix) {
        int count = 1;
        for (Employee employee : employeeManager.getAllEmployees()) {
            if (employee.getEmployeeId().startsWith(prefix)) {
                count++;
            }
        }
        return prefix + "-" + String.format("%03d", count);
    }
}
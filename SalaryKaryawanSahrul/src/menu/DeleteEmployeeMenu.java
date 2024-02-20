package menu;


import java.util.Scanner;
import interfaces.Menu;
import model.EmployeeManager;

public class DeleteEmployeeMenu implements Menu {
    private EmployeeManager employeeManager;

    public DeleteEmployeeMenu(EmployeeManager employeeManager) {
        this.employeeManager = employeeManager;
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nHapus Data Karyawan");
        System.out.print("Masukkan ID karyawan yang ingin dihapus: ");
        String employeeIdToDelete = scanner.nextLine();

        boolean isDeleted = employeeManager.deleteEmployee(employeeIdToDelete);
        if (isDeleted) {
            System.out.println("Karyawan dengan ID " + employeeIdToDelete + " berhasil dihapus.");
        } else {
            System.out.println("Karyawan dengan ID " + employeeIdToDelete + " tidak ditemukan.");
        }

    }
}


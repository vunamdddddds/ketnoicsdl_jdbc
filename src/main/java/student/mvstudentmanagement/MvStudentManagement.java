/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package student.mvstudentmanagement;

import javax.swing.SwingUtilities;

/**
 *
 * @author VUDUYKHUONG
 */
public class MvStudentManagement {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        SwingUtilities.invokeLater(() -> new StudentForm().setVisible(true));
    }
}

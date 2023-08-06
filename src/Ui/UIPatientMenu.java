package Ui;

import com.sun.jdi.IntegerValue;
import model.Doctor;

import javax.print.Doc;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import static Ui.UIMenu.showPatientMenu;

public class UIPatientMenu {

    public static void showPatienMenu(){

        System.out.println("\n\n");
        System.out.println("welcome Patient " + UIMenu.patientLogged.getNombre() );


        int response = 0;
        do{
            System.out.println("Seleciona la opcion a Consultar");
            System.out.println("1. Book an Appointments");
            System.out.println("2. My Appointment list");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyAppointments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }


        }while (response != 0);
    }

    private static void showBookAppointmentMenu(){
        int response = 0;
        do{
            System.out.println(":: book an appointment");
            System.out.println(":: select a Month");

            Map<Integer,Map<Integer,Doctor>> doctors = new TreeMap<>();
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments
                        = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k ++;
                    System.out.println(k+ ". "+ availableAppointments.get(j).getFecha());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k),doctorAppointments);
                }

            }
                Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("","");

            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getNombre() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getFecha() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getHora());

            System.out.println("Confirm your appointment: \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentsDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getFecha(),
                        doctorSelected.getAvailableAppointments().get(indexDate).getHora());

                showPatientMenu();
            }

        }while (response!= 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println("::My Appointments");
            if (UIMenu.patientLogged.getAppointmentsDoctors().size() == 0){
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentsDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentsDoctors().get(i).getFecha() +
                        " Time: " + UIMenu.patientLogged.getAppointmentsDoctors().get(i).getHora() +
                        "\n Doctor: " + UIMenu.patientLogged.getAppointmentsDoctors().get(i).getDoctor().getNombre()
                );
            }
            System.out.println("0. Return");
        }while(response != 0);
    }
}

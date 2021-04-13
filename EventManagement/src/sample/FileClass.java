package sample;

import javax.security.auth.Subject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class FileClass extends LoginPageController {
    String FileName ;

    FileClass (String FileName) {
        this.FileName = FileName ;
    }

    void writeToFileClass (ArrayList<ClassRoutine> listClass) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Database//"+ name + "//Class.txt")) ;
            for (int i=0; i<listClass.size(); i++) {
                ClassRoutine dataClass = listClass.get(i) ;
                bw.write(dataClass.getSubject() +"_" + dataClass.getTime()+ "_" + dataClass.getDay() + "\n") ;
            }
            bw.close();
        }catch (Exception e) {}
    }

    void DeleteFileClass (String subject) {
        ArrayList<ClassRoutine> listC = new ArrayList<>() ;
        //int i = 0 ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Database//" + name + "//Class.txt")) ;
            String line, data[] ;

            while ((line = reader.readLine()) != null) {
                data = line.split("_") ;
                if (!data[0].equalsIgnoreCase(subject))
                    listC.add(new ClassRoutine(data[0], data[2], data[1])) ;
            }
        }catch (Exception e) {}

        writeToFileClass(listC);
    }
    void writeToFileExam (ArrayList<ExamRoutine> listExam) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Database//" + name + "//Exam.txt")) ;
            for (int i = 0; i<listExam.size(); i++) {
                ExamRoutine data = listExam.get(i) ;
                bw.write(data.getSubject()+ "_" + data.getTime() + "_" + data.getDay() + "\n");
            }
            bw.close();
        }catch(Exception e) {}
    }
    void DeleteFileExam (String subject) {
        ArrayList<ExamRoutine> listE = new ArrayList<>() ;
        //int i = 0 ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Database//" + name + "//Exam.txt")) ;
            String line, data[] ;

            while ((line = reader.readLine()) != null) {
                data = line.split("_") ;
                if (!data[0].equalsIgnoreCase(subject))
                    listE.add(new ExamRoutine(data[0], data[1], data[2])) ;
            }
        }catch (Exception e) {}

        writeToFileExam(listE);
    }

    void writeToFileOthers (ArrayList<OthersClass> listOthers) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("Database//" + name + "//Others.txt")) ;
            for (int i = 0; i<listOthers.size(); i++) {
                OthersClass data = listOthers.get(i) ;
                bw.write(data.getEventName()+ "_" + data.getEventDate() + "_" + data.getEventTime() + "\n");
            }
            bw.close();
        }catch(Exception e) {}
    }

    void DeleteFileOthers (String subject) {
        ArrayList<OthersClass> listO = new ArrayList<>() ;
        //int i = 0 ;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Database//" + name + "//Others.txt")) ;
            String line, data[] ;

            while ((line = reader.readLine()) != null) {
                data = line.split("_") ;
                if (!data[0].equalsIgnoreCase(subject))
                    listO.add(new OthersClass(data[0], data[1], data[2])) ;
            }
        }catch (Exception e) {}

        writeToFileOthers(listO);
    }

}

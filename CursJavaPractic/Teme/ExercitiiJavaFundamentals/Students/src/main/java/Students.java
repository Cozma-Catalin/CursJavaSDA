import java.io.Serializable;

public class Students extends Person implements Examinator, ExaminatorInfo, ExaminatorFiz, Comparable<Students>, Serializable {

    private int mathGrade;
    private int infoGrade;
    private int phisGrade;
    private boolean admisPoli;
    private boolean admisFacFiz;
    private boolean admisFacInfo;
    private int medie;

    public Students(String firstName, String lastName, int mathGrade, int infoGrade, int phisGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mathGrade = mathGrade;
        this.infoGrade = infoGrade;
        this.phisGrade = phisGrade;
    }

    public void computeAverage() throws BadGradesException, PerfectGrades, OutOfRange {
        int medie = (this.mathGrade + this.infoGrade + this.phisGrade) / 3;
        if (medie < 6) {
            admisPoli = false;
            throw new BadGradesException("Studentul este repetent.");
        } else if (medie > 6 && medie < 9) {
            this.admisPoli = false;
        } else if (medie == 10) {
            this.admisPoli = true;
            throw new PerfectGrades("Sef de promotie.");
        } else if (medie < 1 || medie > 10) {
            throw new OutOfRange("Notele nu sunt posibile.");
        }
    }


    @Override
    public void computeInfoAverage() throws PerfectGrades {
        int medie = (this.mathGrade + this.infoGrade) / 2;
        if (medie > 6 && medie < 10) {
            admisFacInfo = true;
        } else if (medie == 10) {
            admisFacInfo = true;
            throw new PerfectGrades("Sef de promotie.");
        } else {
            admisFacInfo = false;
        }
    }

    @Override
    public void computeFizAverage() throws PerfectGrades {
        int medie = (this.mathGrade + phisGrade) / 2;
        if (medie > 6 && medie < 10) {
            admisFacFiz = true;
        } else if (medie == 10) {
            admisFacFiz = true;
            throw new PerfectGrades("Sef de promotie.");
        } else {
            admisFacFiz = false;
        }
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public int getInfoGrade() {
        return infoGrade;
    }

    public int getPhisGrade() {
        return phisGrade;
    }

    public boolean isAdmisPoli() {
        return admisPoli;
    }

    public boolean isAdmisFacFiz() {
        return admisFacFiz;
    }

    public boolean isAdmisFacInfo() {
        return admisFacInfo;
    }

    public int getMedie() {
        this.medie = (this.mathGrade + this.infoGrade + this.phisGrade) / 3;
        return this.medie;
    }

    @Override
    public int compareTo(Students students) {
        if (this.medie > students.getMedie()) {
            return 1;
        } else if (this.medie == students.getMedie()) {
            return 0;
        }
        return -1;

    }

    @Override
    public String toString() {
        return "Studentul " + getLastName() + " " + getFirstName() + ", are urmatoarele note : mate= " + mathGrade + ", info=" + infoGrade + ", fizica=" + phisGrade + ", avand media=" + medie + ".Admis la urm facultati: admisPoli=" + admisPoli + ", admisFacFiz=" + admisFacFiz + ", admisFacInfo=" + admisFacInfo + ".";
    }

}

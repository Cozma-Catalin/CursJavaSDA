public class Main {
    public static void main(String[] args) {
        //sa se exemplifice folosirea singleton intr o familie
        //familie cu 5 membri
        //clasa abstracta person
        //clasa family-->singleton
        //clasa parinti(mama,tata)-->singleton
        //clasa copii-->(baiat si fata)

        Family family = Family.getInstance();
        Mom mom = Mom.getMomInstance();
        Dad dad = Dad.getDadInstance();
        Kid son = new Son("Marian", "Ghioaga", "12");
        Kid daughter = new Daughter("Marina", "Ghioaga", "23");
        Kid daughter2 = new Daughter("Adriana","Ghioaga","28");
        family.getFamilyMembers().add(mom);
        family.getFamilyMembers().add(dad);
        family.getFamilyMembers().add(son);
        family.getFamilyMembers().add(daughter);
        family.getFamilyMembers().add(daughter2);

        for (Person person : family.getFamilyMembers()) {
            System.out.println(person);
        }
    }
}

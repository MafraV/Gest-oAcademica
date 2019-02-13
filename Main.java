import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Lab lab = new Lab();
        int op = 0;

        System.out.print("\nWelcome Manager!\n\n");

        while(op != 9)
        {
            System.out.print("What do you want to do?\n\n");
            System.out.print("1 - Add a Collaborator to the Lab;\n");
            System.out.print("2 - Create a Project (Need a Teacher Registered);\n");
            System.out.print("3 - Create a Publication (Need a Collaborator Registered);\n");
            System.out.print("4 - Create a Guidance (Need a Teacher and a Student Registered);\n");
            System.out.print("5 - Manage a Project;\n");
            System.out.print("6 - Consultation by Collaborator;\n");
            System.out.print("7 - Consultation by Project;\n");
            System.out.print("8 - Generate Report;\n");
            System.out.print("9 - Turn Off the System (Stop Program).\n");
            op = lab.readInteger(op);

            if(op == 1)
            {
                lab.add_collaborator();
            }

            if(op == 2)
            {
                lab.create_project();
            }

            if(op == 3)
            {
                lab.create_publication();
            }

            if(op == 4)
            {
                lab.create_guidance();
            }

            if(op == 5)
            {
                lab.manage_project();
            }

            if(op == 6)
            {
                lab.print_collaborator();
            }

            if(op == 7)
            {
                lab.print_project();
            }

            if(op == 8)
            {
                lab.report();
            }

            if(op > 9 || op < 1)
            {
                System.out.print("\nInvalid Command!\n\n");
            }
        }
    }
}

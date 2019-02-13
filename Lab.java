import java.util.*;

public class Lab {

    private Map<String, Collaborator> Collaborators = new HashMap<String, Collaborator>();
    private ArrayList<String> Collaborators_email = new ArrayList<String>();
    private Map<String, Project> Projects = new HashMap<String, Project>();
    private Map<String, Publication> Publications = new HashMap<String, Publication>();
    private Map<String, Guidance> Guidances = new HashMap<String, Guidance>();
    private Scanner input = new Scanner(System.in);


    private int reop;

    public void add_collaborator()
    {
        int readd = 1;
        int type = 0;
        while(readd == 1)
        {
            System.out.print("Please, enter the new Collaborator's full name: ");
            reop = 1;
            String name = input.nextLine();



            while((Collaborators.containsKey(name)) && (reop != 2))
            {
                System.out.print("\nName already registered!\n");
                reop = this.tryAgain();

                if(reop == 1)
                {
                    System.out.print("Please, enter the new Collaborator's full name: ");
                    name = input.nextLine();
                }
            }

            if(reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            System.out.print("Please, enter the new Collaborator's email: ");
            String email = input.nextLine();

            reop = 1;
            while((Collaborators_email.contains(email)) && (reop != 2))
            {
                System.out.print("\nE-mail already registered!\n");
                reop = this.tryAgain();

                if(reop == 1)
                {
                    System.out.print("Please, enter the new Collaborator's email: ");
                    email = input.nextLine();
                }
            }

            if(reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            System.out.print("Please, enter what the Collaborator is:\n");
            System.out.print("1 - A Graduation Student;\n");
            System.out.print("2 - A Mastering Student;\n");
            System.out.print("3 - A PhD Student;\n");
            System.out.print("4 - A Teacher;\n");
            System.out.print("5 - A Researcher.\n");
            type = this.readInteger(type);

            Collaborator collaborator = new Collaborator(name, email, type);
            Collaborators.put(name, collaborator);
            Collaborators_email.add(email);

            System.out.print("\nCollaborator Added!\n");
            System.out.print("\nWant to add other Collaborator?\n");
            System.out.print("Press 1 to Yes or 2 to No.\n");
            readd = this.readInteger(readd);
        }

        System.out.print("\nReturning to the main menu!\n\n");
    }

    public void create_project()
    {
       int recreate = 1;
       int day = 0, month = 0, year = 0, end_day = 0, end_month = 0, end_year = 0;
        float financed_amount = 0;
       while(recreate == 1)
       {
           System.out.print("\nPlease, enter the Project Title: ");
           String title = input.nextLine();
           reop = 1;
           while((Projects.containsKey(title)) && (reop != 2))
           {
               System.out.print("\nTitle already registered!\n");
               reop = this.tryAgain();

               if(reop == 1)
               {
                   System.out.print("\nPlease, enter the Project Title: ");
                   title = input.nextLine();
               }
           }

           if(reop == 2)
           {
               System.out.print("\nReturning to the main menu!\n\n");
               return;
           }

           System.out.print("Please, enter the Project's Objective: ");
           String objective = input.nextLine();

           System.out.print("Please, enter the Project's Description: ");
           String description = input.nextLine();

           System.out.print("Please, enter the Project's Funding Agency: ");
           String funding_agency = input.nextLine();

           System.out.print("Please, enter the Project's Financed Amount (in Reais): ");
           financed_amount = this.readFloat(financed_amount);

           System.out.print("Please, enter the Project's start date (numbers and spaces only): ");
           day = this.readInteger(day);
           month = this.readInteger(month);
           year = this.readInteger(year);

           while(((day > 31) || (month > 12) || (year > 2018) || (year < 0)) && reop == 1)
           {
               System.out.print("\nInvalid date!\n");
               reop = this.tryAgain();

               if(reop == 1)
               {
                   System.out.print("Please, enter the Project's start date (numbers and spaces only): ");
                   day = this.readInteger(day);
                   month = this.readInteger(month);
                   year = this.readInteger(year);
               }
           }

           if(reop == 2)
           {
               System.out.print("\nReturning to the main menu!\n\n");
               return;
           }

           System.out.print("Please, enter the Project's probably end date (numbers and spaces only): ");
           end_day = this.readInteger(end_day);
           end_month = this.readInteger(end_month);
           end_year = this.readInteger(end_year);

           while(((end_day > 31) || (end_month > 12) || (end_year < 0) || (end_year < year) || ((end_year == year) && (end_month < month)) || ((end_year == year) && (end_month == month) && (end_day < day))) && (reop == 1))
           {
               System.out.print("\nInvalid end date!\n");
               reop = this.tryAgain();

               if(reop == 1)
               {
                   System.out.print("Please, enter the Project's probably end date (numbers and spaces only): ");
                   end_day = this.readInteger(end_day);
                   end_month = this.readInteger(end_month);
                   end_year = this.readInteger(end_year);
               }
           }

           if(reop == 2)
           {
               System.out.print("\nReturning to the main menu!\n\n");
               return;
           }

           System.out.print("Please, enter the name of the Teacher who will participate in the project: ");
           String teacher_name = input.nextLine();

           while((!Collaborators.containsKey(teacher_name)) && (reop == 1))
           {
               System.out.print("\nCollaborator not registered!\n");
               reop = this.tryAgain();

               if(reop == 1)
               {
                   System.out.print("Please, enter the name of the Teacher who will participate in the project: ");
                   teacher_name = input.nextLine();
               }
           }

           if(reop == 2)
           {
               System.out.print("\nReturning to the main menu!\n\n");
               return;
           }

           Collaborator teacher = Collaborators.get(teacher_name);

           while((!Objects.equals("Teacher", teacher.getType())) && (reop == 1))
           {
               System.out.print("\nCollaborator isn't a Teacher!\n");
               reop = this.tryAgain();

               if(reop == 1)
               {
                   System.out.print("Please, enter the name of the Teacher who will participate in the project: ");
                   teacher_name = input.nextLine();
               }

               teacher = Collaborators.get(teacher_name);
           }

           if(reop == 2)
           {
               System.out.print("\nReturning to the main menu!\n\n");
               return;
           }

           Project project = new Project(title, objective, description, funding_agency, financed_amount, day, month, year, end_day, end_month, end_year, teacher);
           Projects.put(title, project);
           teacher.addProject(project);

           System.out.print("\nProject Created!\n");
           System.out.print("\nWant to create other Project?\n");
           System.out.print("Press 1 to Yes or 2 to No.\n");
           recreate = this.readInteger(recreate);
       }

        System.out.print("\nReturning to the main menu!\n\n");
    }

    public void create_publication()
    {
        int recreate = 1;
        int year = 0;
        while(recreate == 1) {
            System.out.print("Please, enter the Publication title: ");
            reop = 1;
            String title = input.nextLine();

            while ((Publications.containsKey(title)) && (reop != 2))
            {
                System.out.print("\nPublication already exist!\n");
                reop = this.tryAgain();

                if (reop == 1)
                {
                    System.out.print("Please, enter the Publication title: ");
                    title = input.nextLine();
                }
            }

            if (reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            System.out.print("Please, enter the Conference Name: ");
            String conference = input.nextLine();

            System.out.print("Please, enter the Publication's year: ");
            year = this.readInteger(year);

            while(year > 2018 && reop == 1)
            {
                System.out.print("\nInvalid year!\n");
                reop = this.tryAgain();

                if(reop == 1)
                {
                    System.out.print("Please, enter the Publication's year: ");
                    year = this.readInteger(year);
                }
            }

            if(reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            String author_name;
            int readd = 1;
            ArrayList<String> author_names = new ArrayList<String>();
            ArrayList<Collaborator> authors = new ArrayList<Collaborator>();

            while(readd == 1)
            {
                System.out.print("Please, enter the name of one of the authors: ");
                author_name = input.nextLine();

                while((author_names.contains(author_name) || !Collaborators.containsKey(author_name)) && reop == 1)
                {
                    System.out.print("\nCollaborator is already a author or isn't registered in the lab!\n");
                    reop = this.tryAgain();

                    if(reop == 1)
                    {
                        System.out.print("Please, enter the name of one of the authors (one at least): ");
                        author_name = input.nextLine();
                    }
                }

                if(reop == 2)
                {
                    break;
                }

                author_names.add(author_name);
                authors.add(Collaborators.get(author_name));
                System.out.print("\nAuthor registered!\n");
                System.out.print("\nWant to register other author?\n");
                System.out.print("Press 1 to Yes or 2 to No.\n");
                readd = this.readInteger(readd);
            }

            if(authors.isEmpty())
            {
                return;
            }

            System.out.print("Want to add any other information about the Publication?\n");
            System.out.print("Press 1 to Yes or 2 to No.\n");
            readd = this.readInteger(readd);
            ArrayList<String> info = new ArrayList<String>();
            String infor;

            while(readd == 1)
            {
                System.out.print("Please, enter the information: ");
                infor = input.nextLine();

                while(info.contains(infor) && reop == 1)
                {
                    System.out.print("\nInformation already stated!\n");
                    reop = this.tryAgain();

                    if(reop == 1)
                    {
                        System.out.print("Please, enter the information: ");
                        infor = input.nextLine();
                    }
                }

                if(reop == 2) break;

                info.add(infor);
                System.out.print("\nInformation added!\n");
                System.out.print("\nWant to add other information?\n");
                System.out.print("Press 1 to Yes or 2 to No.\n");
                readd = this.readInteger(readd);
            }

            Publication publication = new Publication(title, conference, year, authors, info);
            Publications.put(title, publication);
            int i;
            Collaborator author;
            for(i=0; i<authors.size(); i++)
            {
                author = authors.get(i);
                author.addPublication(publication);
            }

            System.out.print("\nPublication Created!\n");
            System.out.print("\nWant to create other publication?\n");
            System.out.print("Press 1 to Yes or 2 to No.\n");
            recreate = this.readInteger(recreate);
        }

        System.out.print("\nReturning to the main menu!\n\n");
    }

    public void create_guidance()
    {
        int recreate = 1;
        while(recreate == 1)
        {
            System.out.print("Please, enter the Guidance title: ");
            reop = 1;
            String title = input.nextLine();

            while ((Guidances.containsKey(title)) && (reop != 2))
            {
                System.out.print("\nGuidance already exist!\n");
                reop = this.tryAgain();

                if (reop == 1)
                {
                    System.out.print("Please, enter the Guidance title: ");
                    title = input.nextLine();
                }
            }

            if (reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            System.out.print("Please, enter the Advisor's (Teacher) name: ");
            String teacher_name = input.nextLine();

            while(!Collaborators.containsKey(teacher_name) && reop == 1)
            {
                System.out.print("\nCollaborator not found!\n");
                reop = this.tryAgain();

                if(reop == 1)
                {
                    System.out.print("Please, enter the Advisor's (Teacher) name: ");
                    teacher_name = input.nextLine();
                }
            }

            if(reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            Collaborator teacher = Collaborators.get(teacher_name);

            if(!Objects.equals(teacher.getType(), "Teacher"))
            {
                System.out.print("\nCollaborator isn't a teacher!\n");
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            System.out.print("Please, enter the Student's name: ");
            String student_name = input.nextLine();

            while(!Collaborators.containsKey(student_name) && reop == 1)
            {
                System.out.print("\nCollaborator not found!\n");
                reop = this.tryAgain();

                if(reop == 1)
                {
                    System.out.print("Please, enter the Student's name: ");
                    student_name = input.nextLine();
                }
            }

            if(reop == 2)
            {
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            Collaborator student = Collaborators.get(student_name);

            if(Objects.equals(student.getType(), "Teacher") || (Objects.equals(student.getType(), "Researcher")))
            {
                System.out.print("\nCollaborator isn't a student!\n");
                System.out.print("\nReturning to the main menu!\n\n");
                return;
            }

            Guidance guidance = new Guidance(teacher, student, title);
            Guidances.put(title, guidance);
            teacher.addGuidance(guidance);
            student.addGuidance(guidance);

            System.out.print("\nGuidance Created!\n");
            System.out.print("\nWant to create other Guidance?\n");
            System.out.print("Press 1 to Yes or 2 to No.\n");
            recreate = this.readInteger(recreate);
        }

        System.out.print("\nReturning to the main menu!\n\n");
    }

    public void manage_project()
    {
        reop = 1;
        System.out.print("Please, enter the Project's title: ");
        String project_title = input.nextLine();

        while((!Projects.containsKey(project_title)) && reop == 1)
        {
            System.out.print("\nProject not found!\n");
            reop = this.tryAgain();

            if(reop == 1)
            {
                System.out.print("Please, enter the Project's title: ");
                project_title = input.nextLine();
            }
        }

        if(reop == 2)
        {
            System.out.print("\nReturning to the main menu!\n\n");
            return;
        }

        Project project = Projects.get(project_title);

        if(Objects.equals(project.getStats(), "Concluido"))
        {
            System.out.print("\nProject Already Finished!\n");
            System.out.print("\nReturning to the main menu!\n\n");
            return;
        }

        int op = 0;

        while(op != 6)
        {
            System.out.print("\nWhat do you want to do?\n\n");
            System.out.print("1 - Add a Collaborator to the project;\n");
            System.out.print("2 - Start Project;\n");
            System.out.print("3 - Associate Publication to the project;\n");
            System.out.print("4 - Associate Guidance to the project;\n");
            System.out.print("5 - Finish Project;\n");
            System.out.print("6 - Return to the main menu.\n");
            op = this.readInteger(op);

            if(op == 1)
            {
                int readd = 1;
                while(readd == 1)
                {
                    System.out.print("Please, enter the Collaborator name: ");
                    String name = input.nextLine();
                    reop = 1;


                    while(!Collaborators.containsKey(name) && reop == 1)
                    {
                        System.out.print("\nCollaborator not found!\n");
                        reop = this.tryAgain();

                        if(reop == 1)
                        {
                            System.out.print("Please, enter the Collaborator name: ");
                            name = input.nextLine();
                        }
                    }

                    if(reop == 2) break;

                    Collaborator collaborator = Collaborators.get(name);

                    while(project.getCollaborators().contains(collaborator) && reop == 1)
                    {
                        System.out.print("\nCollaborator already allocated to this Project!\n");
                        reop = this.tryAgain();

                        if(reop == 1)
                        {
                            System.out.print("Please, enter the Collaborator name: ");
                            name = input.nextLine();
                        }

                        collaborator = Collaborators.get(name);
                    }

                    if(reop == 2) break;

                    int test = project.addCollaborator(collaborator);

                    if(test == 1)
                    {
                        System.out.print("\nCollaborator Allocated!\n");
                        System.out.print("\nWant to add other Collaborator?\n");
                        System.out.print("Press 1 to Yes or 2 to No.\n");
                        readd = this.readInteger(readd);
                    }

                    else readd = 2;
                }
                System.out.print("\nReturning to the Project menu!\n");
            }

            if(op == 2)
            {
                project.startProject();
                System.out.print("\nDone!\n");
                System.out.print("\nReturning to the Project menu!\n");
            }

            if(op == 3)
            {
                int readd = 1;
                while(readd == 1)
                {
                    reop = 1;
                    if(!Objects.equals(project.getStats(), "Em andamento"))
                    {
                        System.out.print("\nPublications only can be associated to a In Progress Project!\n");
                        readd = 2;
                    }

                    else
                    {
                        System.out.print("Please, enter the Publication title: ");
                        String title = input.nextLine();

                        while(!Publications.containsKey(title) && reop == 1)
                        {
                            System.out.print("\nPublication not found!\n");
                            reop = this.tryAgain();

                            if(reop == 1)
                            {
                                System.out.print("Please, enter the Publication title: ");
                                title = input.nextLine();
                            }
                        }

                        if(reop == 2) break;

                        Publication publication = Publications.get(title);

                        if((publication.getYear() > project.getEnd_year()) || (publication.getYear() < project.getStart_year()))
                        {
                            System.out.print("\nDates don't match!\n");
                            break;
                        }

                        project.addPublication(publication);

                        System.out.print("\nPublication associated!\n");
                        System.out.print("\nWant to associate other Publication?\n");
                        System.out.print("Press 1 to Yes or 2 to No\n");
                        readd = this.readInteger(readd);
                    }

                    System.out.print("\nReturning to the Project menu!\n");

                }
            }

            if(op == 4)
            {
                int readd = 1;
                while(readd == 1)
                {
                    reop = 1;
                    if(!Objects.equals(project.getStats(), "Em andamento"))
                    {
                        System.out.print("\nGuidance only can be associated to a In Progress Project!\n");
                        readd = 2;
                    }

                    else
                    {
                        System.out.print("Please, enter the Guidance title: ");
                        String title = input.nextLine();

                        while(!Guidances.containsKey(title) && reop == 1)
                        {
                            System.out.print("\nGuidance not found!\n");
                            reop = this.tryAgain();

                            if(reop == 1)
                            {
                                System.out.print("Please, enter the Guidance title: ");
                                title = input.nextLine();
                            }
                        }

                        if(reop == 2) break;

                        Guidance guidance = Guidances.get(title);

                        project.addGuidance(guidance);

                        System.out.print("\nGuidance associated!\n");
                        System.out.print("\nWant to associate other Guidance?\n");
                        System.out.print("Press 1 to Yes or 2 to No\n");
                        readd = this.readInteger(readd);
                    }

                    System.out.print("\nReturning to the Project menu!\n");

                }
            }

            if(op == 5)
            {
                int test = project.endProject();
                if(test == 1)
                {
                    System.out.print("\nProject Finished!\n");
                    System.out.print("\nReturning to the Main Menu!\n\n");
                    op = 6;
                }
            }
        }
    }

    public void report()
    {
        System.out.print("\nThe Lab has:\n" + Collaborators.size() + " Collaborator(s);\n");
        int p_e, p_a, p_c, i;
        p_e = p_a = p_c = 0;

        Set projectsKeySet = Projects.keySet();
        Object projectNames[] = projectsKeySet.toArray();

        for(i=0; i<Projects.size(); i++)
        {
            Object projectName = projectNames[i];

            if(Objects.equals(Projects.get(projectName).getStats(), "Em elaboração")) p_e++;
            else if(Objects.equals(Projects.get(projectName).getStats(), "Em andamento")) p_a++;
            else if(Objects.equals(Projects.get(projectName).getStats(), "Concluido")) p_c++;
        }
        System.out.print(p_e + " Project(s) under development;\n");
        System.out.print(p_a + " Project(s) in progress;\n");
        System.out.print(p_c + " Finished Project(s);\n");
        int sum = p_e + p_a + p_c;
        System.out.print(sum + " Project(s) in general;\n");
        System.out.print(Publications.size() + " Publication(s);\n");
        System.out.print(Guidances.size() + " Guidance(s).\n");
        System.out.print("\nReturning to the main menu!\n\n");

    }

    public void print_collaborator()
    {
        System.out.print("Please, enter the Collaborator name: ");
        reop = 1;
        String collaborator_name = input.nextLine();

        while(!(Collaborators.containsKey(collaborator_name)) && (reop != 2))
        {
            System.out.print("\nCollaborator not found!!\n");
            reop = this.tryAgain();

            if(reop == 1)
            {
                System.out.print("Please, enter the new Collaborator's full name: ");
                collaborator_name = input.nextLine();
            }
        }

        if(reop == 2)
        {
            System.out.print("\nReturning to the main menu!\n\n");
            return;
        }

        Collaborator coll = Collaborators.get(collaborator_name);

        coll.print();
    }

    public void print_project()
    {
        System.out.print("Please, enter the Project title: ");
        reop = 1;
        String project_title = input.nextLine();

        while(!(Projects.containsKey(project_title)) && (reop != 2))
        {
            System.out.print("\nProject not found!!\n");
            reop = this.tryAgain();

            if(reop == 1)
            {
                System.out.print("Please, enter the Project title: ");
                project_title = input.nextLine();
            }
        }

        if(reop == 2)
        {
            System.out.print("\nReturning to the main menu!\n\n");
            return;
        }

        Project proj = Projects.get(project_title);

        proj.print();
    }

    public int tryAgain()
    {
        int x = 0;
        System.out.print("\nWant to try again?\n");
        System.out.print("Press 1 to Yes or 2 to No.\n");
        return readInteger(x);
    }

    public int readInteger(int x)
    {
        boolean correctInput = false;

        while(!correctInput)
        {
            try{
                x = Integer.parseInt(input.nextLine());


                correctInput = true;
            }

            catch(Exception e){

                System.out.print("\nInput isn't a Number!" + "\n" + "Please, try again:\n\n");
            }
        }

        return x;
    }

    public float readFloat(Float x)
    {
        boolean correctInput = false;

        while(!correctInput)
        {
            try{
                x = Float.parseFloat(input.nextLine());


                correctInput = true;
            }

            catch(Exception e){

                System.out.print("\nInput isn't a Number!" + "\n" + "Please, try again:\n\n");
            }
        }

        return x;
    }
}

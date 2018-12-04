import java.util.ArrayList;

public class Collaborator {

    private String name;
    private String email;
    private ArrayList<Project> Finished_Projects = new ArrayList<Project>();
    private ArrayList<Project> Ongoing_Projects = new ArrayList<Project>();
    private ArrayList<Publication>  Publications = new ArrayList<Publication>();
    private ArrayList<Guidance> Guidances = new ArrayList<Guidance>();
    private String type;

    public Collaborator(String name, String email, int type)
    {
        this.name = name;
        this.email = email;
        if(type == 1) this.type = "StudentG";
        else if(type == 2) this.type = "StudentM";
        else if(type == 3) this.type = "StudentD";
        else if(type == 4) this.type = "Teacher";
        else this.type = "Researcher";
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getType()
    {
        return this.type;
    }

    public ArrayList<Project> getFP()
    {
        return this.Finished_Projects;
    }

    public ArrayList<Project> getOGP()
    {
        return this.Ongoing_Projects;
    }

    public ArrayList<Publication> getP()
    {
        return this.Publications;
    }

    public void addProject(Project x)
    {
        Ongoing_Projects.add(x);
    }

    public void endProject(Project x)
    {
        Ongoing_Projects.remove(x);
        Finished_Projects.add(x);
    }

    public void addPublication(Publication x)
    {
        Publications.add(x);
    }

    public void addGuidance(Guidance x)
    {
        Guidances.add(x);
    }

    public void Print_Order_Projects()
    {
        ArrayList<Project> Aux = new ArrayList<Project>();
        ArrayList<Project> Ordered = new ArrayList<Project>();
        Project maior;
        int i;

        if(Finished_Projects.isEmpty())
        {
            System.out.print("No Finished Projects\n");
        }

        else
        {
            for(i=0; i<Finished_Projects.size(); i++)
            {
                Aux.add(Finished_Projects.get(i));
            }

            while(!Aux.isEmpty())
            {
                maior = Aux.get(0);
                for(i=0; i<Aux.size(); i++)
                {
                    if(Aux.get(i).getEnd_year() > maior.getEnd_year())
                    {
                        maior = Aux.get(i);
                    }

                    else if((Aux.get(i).getEnd_year() == maior.getEnd_year()) && (Aux.get(i).getEnd_month() > maior.getEnd_month()))
                    {
                        maior = Aux.get(i);
                    }

                    else if((Aux.get(i).getEnd_year() == maior.getEnd_year()) && (Aux.get(i).getEnd_month() == maior.getEnd_month()) && (Aux.get(i).getEnd_day() > maior.getEnd_day()))
                    {
                        maior = Aux.get(i);
                    }
                }

                Ordered.add(maior);
                Aux.remove(maior);
            }

            System.out.print("Collaborated (Finished Projects):\n");

            for(i=0; i<Ordered.size(); i++)
            {
                System.out.print(Ordered.get(i).getTitle() + "\n");
            }
        }

        if(Ongoing_Projects.isEmpty())
        {
            System.out.print("No Ongoing Projects\n");
        }

        else
        {
            Aux.clear();
            Ordered.clear();

            for(i=0; i<Ongoing_Projects.size(); i++)
            {
                Aux.add(Ongoing_Projects.get(i));
            }

            while(!Aux.isEmpty())
            {
                maior = Aux.get(0);
                for(i=0; i<Aux.size(); i++)
                {
                    if(Aux.get(i).getEnd_year() > maior.getEnd_year())
                    {
                        maior = Aux.get(i);
                    }

                    else if((Aux.get(i).getEnd_year() == maior.getEnd_year()) && (Aux.get(i).getEnd_month() > maior.getEnd_month()))
                    {
                        maior = Aux.get(i);
                    }

                    else if((Aux.get(i).getEnd_year() == maior.getEnd_year()) && (Aux.get(i).getEnd_month() == maior.getEnd_month()) && (Aux.get(i).getEnd_day() > maior.getEnd_day()))
                    {
                        maior = Aux.get(i);
                    }
                }

                Ordered.add(maior);
                Aux.remove(maior);
            }

            System.out.print("Collaborated (Ongoing Projects):\n");

            for(i=0; i<Ordered.size(); i++)
            {
                System.out.print(Ordered.get(i).getTitle() + "\n");
            }
        }
    }

    public void print_order_pub()
    {
        ArrayList<Publication> Aux = new ArrayList<Publication>();
        ArrayList<Publication> Ordered = new ArrayList<Publication>();
        Publication maior;

        if(Publications.isEmpty())
        {
            System.out.print("No Publications\n");
        }

        else
        {
            int i;
            for(i=0; i<Publications.size(); i++)
            {
                Aux.add(Publications.get(i));
            }

            while(!Aux.isEmpty())
            {
                maior = Aux.get(0);

                for(i=0; i<Aux.size(); i++)
                {
                    if(Aux.get(i).getYear() > maior.getYear())
                    {
                        maior = Aux.get(i);
                    }
                }

                Ordered.add(maior);
                Aux.remove(maior);
            }

            System.out.print("Publications:\n");

            for(i=0; i<Ordered.size(); i++)
            {
                System.out.print(Ordered.get(i).getTitle() + "\n");
            }
            System.out.print("\n");

        }
    }

    public void print()
    {
        System.out.print("\nName: " + this.name + "\n");
        System.out.print("E-mail: " + this.email + "\n");
        this.Print_Order_Projects();
        this.print_order_pub();

        System.out.print("\nReturning to the Main Menu!\n\n");
    }
}

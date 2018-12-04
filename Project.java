import java.util.ArrayList;
import java.util.Objects;

public class Project {

    private ArrayList<Collaborator> Collaborators = new ArrayList<Collaborator>();
    private ArrayList<Publication>  Publications = new ArrayList<Publication>();
    private ArrayList<Guidance> Guidances = new ArrayList<Guidance>();
    private String title;
    private int start_day;
    private int start_month;
    private int start_year;
    private int end_day;
    private int end_month;
    private int end_year;
    private String funding_agency;
    private float financed_amount;
    private String objective;
    private String description;
    private String stats;

    public Project(String title, String objective, String description, String funding_agency, float financed_amount, int start_day, int start_month, int start_year, int end_day, int end_month, int end_year, Collaborator teacher)
    {
        this.title = title;
        this.objective = objective;
        this.description = description;
        this.funding_agency = funding_agency;
        this.financed_amount = financed_amount;
        this.start_day = start_day;
        this.start_month = start_month;
        this.start_year = start_year;
        this.end_day = end_day;
        this.end_month = end_month;
        this.end_year = end_year;
        Collaborators.add(teacher);
        stats = "Em elaboração";
    }

    public void startProject()
    {
        stats = "Em andamento";
    }

    public int endProject()
    {
        if(Publications.isEmpty())
        {
            System.out.print("\nProject need to have at last one Publication to be finished.\n");
            return 0;
        }

        else
        {
            int i;
            for(i=0; i<Collaborators.size(); i++)
            {
                Collaborators.get(i).endProject(this);
            }
            stats = "Concluido";
            return 1;
        }
    }

    public void addPublication(Publication x)
    {
        Publications.add(x);
        x.setProject(this);
    }

    public void addGuidance(Guidance x)
    {
        Guidances.add(x);
        x.setProject(this);
    }

    public int addCollaborator(Collaborator x)
    {
        if(Objects.equals(stats, "Em elaboração"))
        {
            if((Objects.equals(x.getType(), "StudentG")) && (x.getOGP().size() == 2))
            {
                System.out.print("\nStudent have reached the maximum projects number.\n");
                return -1;
            }
            else
            {
                Collaborators.add(x);
                x.addProject(this);
                return 1;
            }
        }

        else if(Objects.equals(stats, "Concluido"))
        {
            System.out.print("\nYou can't add a collaborator on a finished project.\n");
            return -1;
        }

        else
        {
            System.out.print("\nYou can't add a collaborator on a started project.\n");
            return -1;
        }
    }

    public ArrayList<Guidance> getGuidances()
    {
        return Guidances;
    }

    public ArrayList<Collaborator> getCollaborators()
    {
        return Collaborators;
    }

    public String getStats()
    {
        return stats;
    }

    public int getStart_year()
    {
        return  start_year;
    }

    public int getEnd_day() {return end_day;}

    public int getEnd_month() {return end_month;}

    public int getEnd_year() { return  end_year; }

    public String getTitle(){ return title;}

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
        }
    }

    public void print()
    {
        int i;

        System.out.print("\nTitle: " + this.title + "\n");
        System.out.print("Description: " + this.description + "\n");
        System.out.print("Objective: " + this.objective + "\n");
        System.out.print("Funding Agency: " + this.funding_agency + "\n");
        System.out.print("Financed Amount: R$ " + this.financed_amount + "\n");
        System.out.print("Stats: " + this.stats + "\n");
        System.out.print("Start date: " + this.start_day + " / " + this.start_month + " / " + this.start_year + "\n");
        System.out.print("End date: " + this.end_day + " / " + this.end_month + " / " + this.end_year + "\n");
        System.out.print("Collaborators:\n");

        for(i=0; i<Collaborators.size(); i++)
        {
            System.out.print(Collaborators.get(i).getName() + "\n");
        }
        this.print_order_pub();

        if(Guidances.isEmpty())
        {
            System.out.print("No Guidances\n");
        }

        else
        {
            System.out.print("Guidances:\n");
            for(i=0; i<Guidances.size(); i++ )
            {
                System.out.print(Guidances.get(i).getTitle() + "\n");
            }
        }

        System.out.print("\nReturning to the main menu!\n\n");
    }
}

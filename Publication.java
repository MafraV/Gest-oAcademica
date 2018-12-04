import java.util.ArrayList;

public class Publication {

    private ArrayList<Collaborator> Authors = new ArrayList<Collaborator>();
    private ArrayList<String> Info = new ArrayList<String>();
    private String title;
    private String conference_name;
    private int publication_year;
    private Project associated_project;
    private ArrayList<String> Informations = new ArrayList<String>();

    public Publication(String title, String conference_name, int publication_year, ArrayList<Collaborator> authors, ArrayList<String> info)
    {
        this.title = title;
        this.conference_name = conference_name;
        this.publication_year = publication_year;
        int i;
        for(i=0; i<authors.size(); i++)
        {
            this.Authors.add(authors.get(i));
        }

        if(!info.isEmpty())
        {
            for(i=0; i<info.size(); i++)
            {
                this.Info.add(info.get(i));
            }
        }
    }

    public void setProject(Project x)
    {
        this.associated_project = x;
    }

    public int getYear()
    {
        return publication_year;
    }

    public String getTitle()
    {
        return title;
    }

}

import java.util.ArrayList;

public class Guidance {

    Collaborator Teachers;
    Collaborator Student;
    private ArrayList<String> Informations = new ArrayList<String>();
    private Project associated_project;
    private String title;

    public Guidance(Collaborator teacher, Collaborator student, String title)
    {
        this.Teachers = teacher;
        this.Student = student;
        this.title = title;
    }

    public void setProject(Project x)
    {
        this.associated_project = x;
    }

    public String getTitle()
    {
        return title;
    }
}

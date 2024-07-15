package Database;

import java.io.File;

public class Creating_Folder
{
    static String path = "C:\\Users\\dell\\Desktop\\My_Folder";
    static File file = new File(path);
    public static void creatingFolder()
    {
        boolean create = file.mkdir();
        if (create)
            System.out.println("Folder created Successfully :)");
        else
            System.out.println("Error..!!");
    }
    public static void deletingFolder()
    {
        boolean delete  = file.delete();
        if (delete)
            System.out.println("Folder deleted Successfully :)");
        else
            System.out.println("Error..!!");
    }
    public static void main(String[] args)
    {

    }
}
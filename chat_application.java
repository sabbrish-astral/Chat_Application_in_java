import java.util.*;
class chat_application
{
    public static List<String> user_names=new ArrayList<>();
    public static List<String> block=new ArrayList<>();
    public static List<String> KHOLI=new ArrayList<>();
    public static List<String> DHAWAN=new ArrayList<>();
    public static List<String> ROHIT=new ArrayList<>();
    public static List<String> DHONI=new ArrayList<>();
    public static List<String> BUMRAH=new ArrayList<>();
    public static void add_users(String name)
    {
        user_names.add(name);
    }
    public static void delete_user(String name)
    {
        user_names.remove(name);
    }
    public static void block(String n1,String n2)
    {
        if(n1.equals("KHOLI"))
            KHOLI.add(n2);
        if(n1.equals("DHAWAN"))
            KHOLI.add(n2);
        if(n1.equals("ROHIT"))
            KHOLI.add(n2);
        if(n1.equals("DHONI"))
            KHOLI.add(n2);
        if(n1.equals("BUMRAH"))
            KHOLI.add(n2);
    }
    public static void unblock(String n1,String n2)
    {
        if(n1.equals("KHOLI"))
            KHOLI.remove(n2);
        if(n1.equals("DHAWAN"))
            KHOLI.remove(n2);
        if(n1.equals("ROHIT"))
            KHOLI.remove(n2);
        if(n1.equals("DHONI"))
            KHOLI.remove(n2);
        if(n1.equals("BUMRAH"))
            KHOLI.remove(n2);
    }
    public static void show(String n1)
    {
        if(n1.equals("KHOLI"))
        {
            for(int i=0;i<KHOLI.size();i++)
            {
                System.out.print(KHOLI.get(i)+" ");
            }
        }
        if(n1.equals("DHAWAN"))
        {
            for(int i=0;i<DHAWAN.size();i++)
            {
                System.out.print(DHAWAN.get(i)+" ");
            }
        }
        if(n1.equals("ROHIT"))
        {
            for(int i=0;i<ROHIT.size();i++)
            {
                System.out.print(ROHIT.get(i)+" ");
            }
        }
        if(n1.equals("DHONI"))
        {
            for(int i=0;i<DHONI.size();i++)
            {
                System.out.print(DHONI.get(i)+" ");
            }
        }
        if(n1.equals("BUMRAH"))
        {
            for(int i=0;i<BUMRAH.size();i++)
            {
                System.out.print(BUMRAH.get(i)+" ");
            }
        }
    }
    // public static void KHOLI(String name)
    // {
    //     user_names.add(name);
    // }
    public static void display()
    {
        for(int i=0;i<user_names.size();i++)
        {
            if(!block.contains(user_names.get(i)))
                System.out.println(user_names.get(i));
        }
    }
    public static void main(String[]args)
    {
        Scanner x=new Scanner(System.in);
        boolean loop=true;
        while(loop)
        {
        System.out.printf("1)Add user\n2)Delete user\n3)Block_Unblock Name\n4)Display Name\n");
        int no=x.nextInt();
        switch(no)
        {
            case 1:
                System.out.println("Add User Name:");
                String name=x.next();
                add_users(name);
                break;
            case 2:
                System.out.println("Delete User Name:");
                String name1=x.next();
                delete_user(name1);
                break;
            case 3:
                System.out.println("Block_Unblock & Dispaly operation:");
                System.out.printf("1)Block\n2)Unblock\n3)list of block_unblock\n");
                int N=x.nextInt();
                switch(N)
                {
                    case 1:
                        System.out.println("Enter the two users\n");
                        String Name1=x.next();
                        String Name2=x.next();
                        block(Name1,Name2);
                        break;
                    case 2:
                        System.out.println("Enter the two users\n");
                        String b1=x.next();
                        String b2=x.next();
                        unblock(b1,b2);
                        break;
                    case 3:
                        System.out.println("Enter the user name to display\n");
                        String c1=x.next();
                        show(c1);
                        break;
                }
                break;  
            case 4:
                System.out.println("Displayed user names:");
                display();
                break;
            case 5:
                System.out.println("Exit:");
                loop=false;
                break;
        }
        System.out.println();
        }
        x.close();
    }
}
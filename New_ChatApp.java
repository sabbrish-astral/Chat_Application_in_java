import java.util.*;
public class New_ChatApp {
    public static HashMap<String,ArrayList<String>> map=new HashMap<>();
    public static HashMap<String,HashMap<String,ArrayList<String>>> map1=new HashMap<>();
    public static Scanner x=new Scanner(System.in);


    public static void  add(String str)
    {
        ArrayList<String>s=new ArrayList<>();
        map.put(str,s);
    }


    public static void  delete(String str)  
    {
        if(map.containsKey(str))
        {
            map.remove(str);
        }
        else
            System.out.print("Entered User is not in Chat_Application for __Removing__");
    
    }


    public static void block(String s1,String s2)
    {
        // if(map.containsKey(s2))
        // {
        //     map.get(s1).add(s2);
        // }
        // else
        //     System.out.print("Entered User is not in Chat_Application for __Blocking__");
        if(map.containsKey(s1) && map.containsKey(s2))
        {
            if (!s1.equals(s2)) {
                map.get(s1).add(s2);
            }
            else {
                System.out.println("You cannot block yourself.");
            }
        }
        else {
            System.out.println("One or both users not found for __Blocking__");
        }
    }


    public static void unblock(String s1,String s2)
    {
        if(map.containsKey(s1))
        {
            map.get(s1).remove(s2);
        }
        else
            System.out.print("Entered User_List is not in Chat_Application for __UnBlocking__");
    }


    public static void display()
    {
        for(Map.Entry<String,ArrayList<String>>i:map.entrySet())
        {
            System.out.println(i.getKey());
        }
    }


    public static void block_list(String str)
    {
        if(map.containsKey(str)) {
            System.out.println("Blocked Users of " + str + ": " + map.get(str));
        } 
        else {
        System.out.println("User not found.");
        }
    }


    public static void chat(String s1,String s2)
    {
        ArrayList<String>lst1=new ArrayList<>();
        ArrayList<String>lst2=new ArrayList<>();
        if(!map1.containsKey(s1))
        {
            HashMap<String,ArrayList<String>>inner=new HashMap<>();
            inner.put(s2,lst1);
            map1.put(s1,inner);
            //Alternative Method in Single Line see Below
           // map1.computeIfAbsent(s1, k -> new HashMap<>()).put(s2, lst);
        }
        else if(!map1.get(s1).containsKey(s2)){
            map1.get(s1).put(s2,lst1);
        }
        if(!map1.containsKey(s2))
        {
            HashMap<String,ArrayList<String>>inner=new HashMap<>();
            inner.put(s1,lst2);
            map1.put(s2,inner);
            //Alternative Method in Single Line see Below
           // map1.computeIfAbsent(s2, k -> new HashMap<>()).put(s1, lst);
        }
        else if(!map1.get(s2).containsKey(s1))
        {
            map1.get(s2).put(s1,lst2);
        }
        System.out.println("Write the Message to stop typing enter Stop_Entry");
        x.nextLine();
        while(true)
        {
            String str=x.nextLine();
            if(!str.equals("Stop_Entry"))
            {
                map1.get(s1).get(s2).add("FROM USER "+s1+" TO "+s2+": "+str);
                map1.get(s2).get(s1).add("FROM USER "+s1+" TO "+s2+": "+str);
            }
            else
                break;
        }
    }

    public static void display(String s1,String s2)
    {
        if(map1.containsKey(s1) && map1.get(s1).containsKey(s2))
        {
            ArrayList<String> messages=map1.get(s1).get(s2);
            System.out.println("Chat Between "+s1+" and "+s2+" :");
            for(String i:messages)
            {
                System.out.println(i);
            }
        }
        else
        {
            System.out.println("No such chat is available between "+s1+" and "+s2);
        }
    }


    public static void main(String[] args) {
        boolean exit=true;
        System.out.println("Welcome to ChatAppliction");
        String str,str1;
        while (exit) {
            System.out.println("\nSelect the below");
            System.out.printf("1)Add User\n2)Delete User\n3)Block User\n4)UnBlock User\n5)Display_Users\n6)User BlockList\n7)Chat_Application\n8)Exit\n");
            int no=x.nextInt();
            switch (no) {
                case 1:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    add(str);
                    break;
                case 2:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    delete(str);
                    break;
                case 3:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    System.out.println("Enter Block_User Name:");
                    str1=x.next();
                    block(str,str1);
                    break;
                case 4:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    System.out.println("Enter User Name for UnBlocking:");
                    str1=x.next();
                    unblock(str,str1);
                    break;
                case 5:
                    System.out.println("_Displaying_Users_..........");
                    display();
                    break;
                case 6:
                    System.out.println("Enter User Name:");
                    str=x.next();
                    block_list(str);
                    break;
                case 7:
                    System.out.println("U are Entering into Chat_Application...........");
                    System.out.println("Choose the Below Functions:");
                    System.out.printf("1)Chat With Others\n2)Display Chats\n");
                    int n=x.nextInt();
                    switch (n) {
                        case 1:
                            System.out.println("Enter User Name:");
                            str=x.next();
                            System.out.println("Sender User Name:");
                            str1=x.next();
                            chat(str,str1);
                            break;
                        case 2:
                            System.out.println("Enter User Name:");
                            str=x.next();
                            System.out.println("Chat of User Name:");
                            str1=x.next();
                            display(str,str1);
                            break;
                    }
                    break;
                case 8:
                    exit=false;
                    break;
            }
        }
    }
}
import java.util.*;

public class TrainDetails {
    String no, name, source, dest;
    int dist;

    public TrainDetails(){

    }

    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Train Number: ");
        no = sc.nextLine();
        System.out.print("Enter the Train Name: ");
        name = sc.nextLine();
        System.out.print("Enter the Source: ");
        source = sc.nextLine();
        System.out.print("Enter the Destination: ");
        dest = sc.nextLine();
        System.out.print("Enter the Distance: ");
        dist = sc.nextInt();
        sc.close();
    }

    public void print(){
        System.out.println("Number: "+no+"\tName: "+name+"\tSource: "+source+"\tDestination: "+dest+"\tDistance: "+dist);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        List<TrainDetails> list = new ArrayList<>();
        System.out.print("Enter the number of trains: ");
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            TrainDetails ob = new TrainDetails();
            ob.input();
            list.add(ob);
        }
        System.out.println("1. Source");
        System.out.println("2. Distance");
        System.out.println("3. Train No");
        System.out.println("4. Train Name");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                Collections.sort(list, new SourceComparator());
                break;
            case 2:
                Collections.sort(list, new DistanceComparator());
                break;
            case 3:
                Collections.sort(list, new NumberComparator());
                break;
            case 4:
                Collections.sort(list, new NameComparator());
                break;
            default:
                System.out.println("Wrong choice");
        }
        for(TrainDetails ob: list){
            ob.print();
        }
        sc.close();
    }
}

class NameComparator implements Comparator<TrainDetails>{
    public int compare(TrainDetails t1, TrainDetails t2){
        return t1.name.compareTo(t2.name);
    }
}

class NumberComparator implements Comparator<TrainDetails>{
    public int compare(TrainDetails t1, TrainDetails t2){
        return t1.no.compareTo(t2.no);
    }
}

class SourceComparator implements Comparator<TrainDetails>{
    public int compare(TrainDetails t1, TrainDetails t2){
        return t1.source.compareTo(t2.source);
    }
}

class DistanceComparator implements Comparator<TrainDetails>{
    public int compare(TrainDetails t1, TrainDetails t2){
        if(t1.dist>t2.dist){
            return 1;
        }
        if(t1.dist<t2.dist){
            return -1;
        }
        return 0;
    }
}
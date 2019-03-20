import java.util.ArrayList;
import java.util.Scanner;
class data{
    private Scanner s=new Scanner(System.in);
    public int pId;
    public int pBt;
    public int pAt;
    public int pCt;
    public int theBt;
    public void getProcesses(){
        System.out.println("Enter the Process Id,Process Arrival Time &Process Burst Time");
        pId=s.nextInt();
        pAt=s.nextInt();
        pBt=s.nextInt();
    }
}
public class RoundRobin {
        private static int n=6;
        private static int tab=0;//number of CPU executions;
        private static void initialiseDataArray(data ex[]){
            for(int i=1;i<=n;i++){
                ex[i]=new data();
            }
        }

        private static void processData(data ex[]){//get the process data
            for(int i=1;i<=n;i++){
                ex[i].getProcesses();//'ex' can be for any object array of the class 'data';this line collects the attributes
                ex[i].theBt=ex[i].pBt;
            }
        }
        private static ArrayList<Integer> sac=new ArrayList<Integer>();//is the queue;
        private static void collector(data ex[]){
            sac.add(0,0);
            for(int i=1;i<=n ;i++){
                    sac.add(i, ex[i].pId);//will contain the id of the process;
            }
        }
        private static void completionTime(data ex[]) {
            boolean flag=false;
            int ff=0;
            int count;
            tab=0;
            collector(ex);
            System.out.println(sac.size()-1);
            for (int h = 1;h<=(sac.size()-1); h++){
                count = sac.get(h);//id of the current process;
                for(int k=1;k<=2;k++){
                    System.out.println("\nthe total burst time "+ex[count].theBt);
                    ff = ff + 1;
                    ex[count].theBt = (ex[count].theBt - 1);//Decrementing the Burst Time of the ith process whose pId is ex[i].pId;
                    tab = tab + 1;
                    System.out.println(ex[count].pId + " th process used CPU by one unit");
                    System.out.println("\n\n "+ex[count].theBt+" more cycles for "+ex[count].pId);
                    if (ex[count].theBt == 0) {
                        ff = 0;
                        ex[count].pCt = tab;
                        System.out.println("\n\nCompletion Time of " + ex[count].pId + " is " + ex[count].pCt);
                        flag = true;
                    }
                    if(flag){//breaking the k for loop
                        flag=false;
                        break;
                    }
                }
                if (ff == 2) {
                    if(ex[count].theBt>0) {
                        sac.add(count);
                    }
                    ff = 0;
                }
            }
//                if (flag) {
//                    tab++;//CPU is saying that we just used one of its cycles or he was idle;
//                    System.out.println("Free spin yuk You wasted my time");
//                    flag = true;
//
        }
        public static void main(String [] args){
            data taba[]=new data[100];
            initialiseDataArray(taba);
            processData(taba);
            completionTime(taba);
        }
}
/*All Rights Reserved
Nongjaimayum Annas khan
Husband of Ph Tabasum Sahani
*/


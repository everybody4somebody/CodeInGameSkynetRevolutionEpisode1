import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        boolean[][] links = new boolean[N][N];
        
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            links[N1][N2] = true;
            links[N2][N1] = true;
        }
        
        int[] exits = new int[E];
        
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            exits[i] = EI;
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            Queue<Integer> searchQueue = new LinkedList<>();
            boolean[] queuedVal = new boolean[N];
            
            for(int i = 0; i < exits.length; i++){
                searchQueue.add(exits[i]);
                queuedVal[exits[i]] = true;
                //System.err.println(exits[i]);
            }
            
            
            while(!searchQueue.isEmpty()){
                int checkVal = searchQueue.remove();
               // System.err.println("Queue item: " + checkVal);
                for(int i = 0; i < links.length; i++){
                    //System.err.println("Link: " + i + " " + links[checkVal][i]);
                    if(links[checkVal][i]){
                        //System.err.println("Queued: " + queuedVal[i]);
                        if(!queuedVal[i]){
                            searchQueue.add(i);
                            queuedVal[i] = true;
                        }
                        if(i == SI){
                            System.out.println(checkVal + " " + i);
                            links[i][checkVal] = false;
                            links[checkVal][i] = false;
                            searchQueue.clear();
                            break;
                        }
                    }
                }
                
            }
        }
    }
}

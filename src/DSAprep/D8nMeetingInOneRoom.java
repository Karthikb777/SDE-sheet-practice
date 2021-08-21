package DSAprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*       n meeting in one room and activity selection problem (both are the same):
*           greedy algorithm:
*               sort all the meetings in the order of their ending times.
*               for every meeting, if the starting time of the meeting
*               is greater than the ending time of the previous meeting
*                   then that meeting will take place
*                   so add the meeting index to a list and update the currMeetingEndTime as the current meeting's end time
*               finally, print the list containing the meeting indices
*
*           TC - O(n) for adding all the meetings to a list
*              + O(nlogn) for sorting the list
*              + O(n) for getting the meeting result
*
*           SC - O(n)
* */

//  meeting class
class meeting implements Comparable<meeting> {
    int start;
    int end;
    int index;

    public meeting(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

//    comparable to compare 2 meetings by their end times
//    if the end times are the same, we compare the indices,
//    the meeting with the smaller index will come first in the list
    @Override
    public int compareTo(meeting that) {
        if (this.end < that.end) return -1;
        else if (this.end > that.end) return 1;
        else if (this.index < that.index) return -1;
        return 1;
    }
}


public class D8nMeetingInOneRoom {

    public static void noOfMeetings(int[][] arr) {
//        list to store all the meetings
        List<meeting> meet = new ArrayList();
//        list to store all the meeting indices
        List<Integer> meetings = new ArrayList();
//        var to keep track of the end time of the current meeting being held
        int currMeetingEndLimit = 0;

//        add all the meetings to an arraylist
        for (int i = 0; i < arr.length; i++) {
            meet.add(new meeting(arr[i][0], arr[i][1], i+1));
        }

//        sort the list elements by their finishing time.
        Collections.sort(meet);

//        for every meeting, check if the starting time of the current meeting
//        is less than the ending time of the previous meeting

//        first add the first meeting to the list coz the meeting room is empty
        meetings.add(meet.get(0).index);
        currMeetingEndLimit = meet.get(0).end;

        for (int i = 1; i < meet.size(); i++) {
            if (meet.get(i).start > currMeetingEndLimit) {
                currMeetingEndLimit = meet.get(i).end;
                meetings.add(meet.get(i).index);
            }
        }

//        print the index of the meetings that will take place in the room
        System.out.print("indices of the meetings that will take place in the room: ");
        for (int i : meetings) {
            System.out.print(i + "  ");
        }
    }

    public static void main(String[] args) {
        int[][] meetings = {
            {1, 2},
            {0, 6},
            {3, 4},
            {8, 9},
            {5, 7},
            {8, 9},
        };
        noOfMeetings(meetings);

    }
}

//    testing code for sorting
//System.out.println("after sorting: ");
//        for (meeting m: meet) {
//            System.out.print(m.start + " " + m.end + " " + m.index + "  ");
//        }
//        System.out.println();

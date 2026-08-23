package com.company.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class courseReq {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] req:prerequisites){
            adjList.get(req[1]).add(req[0]);
            indegree[req[0]]++;
        }
        int nodesVisited = 0;
        Queue<Integer>queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            int node = queue.poll();
            List<Integer>neighbors = adjList.get(node);
            nodesVisited++;
            for(int neighbor:neighbors){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.add(neighbor);
                }
            }
        }
        return nodesVisited == numCourses;
    }
}

//#condition StronglyConnected
//@package gpl;
//@
//@ 
//@/**
//@ * GPL Example
//@ * Runtime variability and monolithic implementation
//@ * @author Roberto E. Lopez-Herrejon
//@ * ETS-LOGTI
//@ */
//@public class FinishTimeWorkSpace extends WorkSpace {
//@    int finishCounter;
//@
//@    public FinishTimeWorkSpace() {
//@        finishCounter = 1;
//@    }
//@
//@    public void preVisitAction(Vertex v) {
//@        if (!v.visited)
//@            finishCounter++;
//@    }
//@
//@    public void postVisitAction(Vertex v) {
//@        v.finishTime = finishCounter++;
//@    } // of postVisit
//@}
//@

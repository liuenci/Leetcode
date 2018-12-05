package com.cier.solution.StackAndQueue;

import java.util.Queue;

// 猫狗队列
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(Queue<PetEnterQueue> dogQ, Queue<PetEnterQueue> catQ) {
        this.dogQ = dogQ;
        this.catQ = catQ;
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getPetType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("error, not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()){
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()){
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("error, queue is empty");
        }
    }
    public Dog pollDog(){
        if (!isDogQueueEmpty()){
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("Dog queue is empty");
        }
    }
    public Cat pollCat(){
        if (!isCatQueueEmpty()){
            return (Cat) catQ.poll().getPet();
        }else {
            throw new RuntimeException("Cat queue is empty");
        }
    }
    public boolean isEmpty(){
        return dogQ.isEmpty() && catQ.isEmpty();
    }
    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }
    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }

}

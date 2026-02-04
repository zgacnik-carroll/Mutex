# Mutex Spinlock Demonstration

## Overview

This project demonstrates a simple **mutex (mutual exclusion)** lock implemented in Java using the keywords:

- `synchronized`
- `volatile`
- `final`

The mutex is tested using multiple threads that compete for the lock using a **spin-loop**. Only one thread is allowed to enter the critical section at a time.

---

## Files Included

- `Mutex.java`  
  Implements a simple spinlock-style mutex.

- `MutexTestSpinLoop.java`  
  Creates multiple threads that attempt to acquire and release the mutex.

---

## Requirements

- **Java JDK 21**.
- A Java-compatible IDE (IntelliJ IDEA, Eclipse, VS Code) or the command line.

---

## How to Run

### Using the Command Line

1. Clone this repository within your desired directory.
2. Navigate to that directory and run the following commands:

```bash
cd Mutex
```
```bash
javac Mutex.java MutexTestSpinLoop.java
```
```bash
java MutexTestSpinLoop.java
```
---

## Expected Output

Once you have run all of the above commands, you should see
output similar to the following:

```bash
Thread[0] Running
Thread[2] Running
Thread[3] Running
Thread[1] Running
Thread[4] Running
Thread[0] Acquired
Thread[0] Released
Thread[2] Acquired
Thread[2] Released
Thread[3] Acquired
Thread[3] Released
Thread[4] Acquired
Thread[4] Released
Thread[1] Acquired
Thread[1] Released
```
This is a direct copied and pasted version of output I received
on my own computer. Your output may vary (and **WILL** vary with each execution)
but the point of the output is to view only one thread being acquired
and released at a time. I will go into more detail on this concept
within the next section below.

### What does this mean?

This program illustrates the **mutual exclusion problem**
in operating systems, where multiple concurrent threads compete
for access to a shared critical section of code. The `Mutex`
makes sure that only one thread can enter the critical section
at a time, preventing race conditions.

The test program demonstrates a **spinlock**, which is a
synchronization mechanism in which threads repeatedly check
(busy-wait) until the lock becomes available. Spinlocks are
typically studied in operating systems because they can be
efficient for short critical sections and avoid the overhead of
context switching, but can waste CPU resources under high
contention.

As a result, the `Mutex` code written ensures that only one thread
can be acquired and released at a time, preventing race conditions
and CPU resource waste.
## Project Notes


#### Project Summary

Simulate a supermarket where customers enter according to some random interval, stop for a random interval of time, get in line to check out and then when it is their turn, check out for a random interval of time. 

### Classes

* Customer class (written)
* Customer factory (written)
* Cashiers (Threaded)
  * This needs to be written


### Data Structures

* ArrayList of Customers
* Queue to hold Customers as they wait for checkout
* Use a ConcurrentLinkedQueue, which is Thread safe


### Key Terms

* Thread - A piece of code, a class, an object, etc. that runs on its own processor thread
* Serializable - a function or data structure that is Thread safe
  * It locks access and unlocks access as different threads interact with it

### End Result


* Run simulation for a given number of ms
* A list of stats
    * Total customers
    * Total number of Cashiers used
    * Average shop time per customer
    * Average process time per customer
    * Average wait time int the Queue per customer
      * Not implemented
        * Time stamps must be added when they
          * enter the queue
          * exit the queue
    * Average down-time per cashier(stretch goal)
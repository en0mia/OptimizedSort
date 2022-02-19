<div align="center">

<h3 align="center">OptimizedSort</h3>

  <p align="center">
    A fast and reliable Java micro-library which chooses the sorting algorithm that best fits your needs and sorts the parameter.
    <br />
  </p>
</div>

<!-- ABOUT THE PROJECT -->
## About The Project

While I was studying for my Algorithms course I started implementing a Java library which allows you to sort an array of items in the best way.

I implemented it thinking about different necessities and it went out that the time complexity is not everything.
Sometimes you could have different necessities like **stable** or **in-place** sortings.
This library chooses the algorithm that best fits your necessities.

<p align="right">(<a href="#top">back to top</a>)</p>

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

* Download the latest JAR release [here](https://github.com/en0mia/OptimizedSort/releases) or pack the sources by yourself.

### Installation

Add the JAR library to the dependencies of your your project.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->
## Usage

First, create a class which implements **Comparable**:
```java
public class Player implements Comparable<Player> {
  String name;
  int points;

  public Player(String name, int points) {
    this.name = name;
    this.points = points;
  }

  @Override
  public int compareTo(Player o) {
    return this.points - o.points;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
```

Then, if you want to sort your array of object:
```java
Player []players = new Player[]{
                new Player("Simone", 100),
                new Player("John", 20),
                new Player("Joe", 1),
                new Player("Robert", 7),
                new Player("Aldo", 2),
        };

        Sort<Player> sort = new Sort<>(players);

        // Sort the array
        players = sort.sort();

        // Print out the results
        for (Player p : players) {
            System.out.println(p);
        }
```

You can also configure the algorithm by yourself...
```java
// Use Selection Sort
sort.setAlgorithm("selection");
// Use Heap Sort
sort.setAlgorithm("heap");
// Use Insertion Sort
sort.setAlgorithm("insertion");
// Use Merge Sort
sort.setAlgorithm("merge");
// Use Quick Sort
sort.setAlgorithm("quick");
// Use Shell Sort
sort.setAlgorithm("shell");
```
... or you can let the library choose the best one using the parameters

```java
// InPlace: TRUE
// Stable: TRUE
Sort<Player> sort = new Sort<>(players, true, true);
```



<p align="right">(<a href="#top">back to top</a>)</p>

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Simone Nicol - [@en0mia](https://twitter.com/en0mia)

Project Link: [https://github.com/en0mia/OptimizedSort](https://github.com/en0mia/OptimizedSort)

<p align="right">(<a href="#top">back to top</a>)</p>
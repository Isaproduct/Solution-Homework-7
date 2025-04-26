Episode Class:

This class represents an individual episode of a series. It contains two key attributes:

title: A String representing the episode's name.

runtimeSec: An int indicating the duration of the episode in seconds.

The class includes the necessary getter methods to access these attributes.

Season Class:

This class represents a single season of a TV series and contains the functionality to add episodes.

The class uses a collection (such as ArrayList, LinkedList, or others) to store episodes.

The method addEpisode(Episode e) allows adding episodes to the season.

Series Class:

The Series class represents the entire TV series, containing multiple seasons.

It provides the method addSeason(Season s) to add multiple seasons to the series.

EpisodeIterator Interface:

This interface defines the contract for iterators that will traverse episodes. It has two methods:

boolean hasNext(): Checks if there is a next episode to iterate.

Episode next(): Returns the next episode in the sequence.

Concrete Iterators for Season:

Three concrete iterators are implemented for traversing episodes in a season:

SeasonIterator: This iterator provides normal, sequential access to the episodes in the season (in the order they were added).

ReverseSeasonIterator: This iterator provides reverse access, iterating over episodes from the last one to the first one.

ShuffleSeasonIterator: This iterator provides access to the episodes in a random order, but the order is consistent and repeatable due to the use of a fixed seed.

Season Implements Iterable<Episode>:

The Season class implements the Iterable<Episode> interface to allow the use of the enhanced for-each loop, making it easier to iterate through all the episodes in a season in normal order.

The iterator() method returns the default iterator (SeasonIterator), which handles normal traversal of episodes.

BingeIterator:

The BingeIterator is a composite iterator that allows the user to traverse through multiple seasons in a continuous manner (i.e., from Season 1, Episode 1 to the last episode of the series).

It combines individual seasons by iterating through each season using the appropriate iterator, making it easier for the user to watch episodes without manually jumping between seasons.

Additional Features:
"Skip Intro" Wrapper Iterator (Optional):

This iterator could be implemented as an additional layer, allowing the user to skip a specific number of seconds (e.g., n seconds) at the beginning of each episode. It would return an EpisodeView object, which plays the episode starting from the designated offset.

Watch-History Filter (Decorator + Iterator):

This is another optional feature where a decorator iterator is applied to filter and show only unseen episodes. It wraps another iterator to provide this functionality.

Why Iterator is Preferable Over Exposing List<Episode>:
Encapsulation of Collection Details: By using iterators, you hide the internal details of how episodes are stored in each season (whether it's in an ArrayList, LinkedList, or lazy-loaded files). This abstraction allows for changes in the storage mechanism without affecting the user or client code.

Flexibility in Traversal: The iterator pattern allows for multiple ways of traversing the episodes (normal, reverse, shuffle), providing flexibility in how episodes are viewed. This would be difficult to achieve if you simply exposed the List<Episode>.

Separation of Concerns: The iterator provides a clear separation between the collection (episodes) and the way they are accessed. It reduces the complexity of managing different traversal orders and handling edge cases like shuffling or reverse order.

Stretch Goal for Honors Credit:
A performance test was conducted by generating 10,000 fake episodes, and different iterators were timed to evaluate and compare their performance. A mini-performance report, such as an ASCII bar chart or numbers, was created to showcase the performance differences between different types of iterators (normal, reverse, shuffle).

This code design demonstrates the use of the Iterator Pattern to solve a complex problem with multiple traversal orders and the need for flexibility, while also ensuring encapsulation and separation of concerns.

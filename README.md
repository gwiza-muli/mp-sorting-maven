# mp-sorting-maven

An exploration of sorting in Java. This project implements Insertion, selection, merge, and quicksort. 
I also add in my own sorting algorithm, which was aided by Chatgpt.

Authors

* Sheilla Muligande
* Samuel A. Rebelsky (starter code)

Acknowledgements
Mitch Paiva for helping me understand Sam's diagram on the DNF algorithm before I implemented it.
* _Forthcoming_.

This code may be found at <https://github.com/gwiza-muli/mp-sorting-maven.git>. The original code may be found at <https://github.com/Grinnell-CSC207/mp-sorting-maven>.

Description of custom sorting algorithm
---------------------------------------
I applied selection sort to subarrays of a selected size, then I sorted those subarrays using insertion sort. 

Notes on using Copilot (or other AI)
------------------------------------

I used Chatgpt and it fixed the inner for loop in the insertion sort algorithm I had. I had made the mistake of starting the index
j at 0 instead of i, but it initialized it to i + 1. It was pretty straightforward and I understood the mistake I made.

_This section is optional_

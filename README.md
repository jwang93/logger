Secretary
=========

##Appian Indie Time Project 

##### Problem 
(from my experience working on Android) What if you don't want to log through LogCat? There are five different types of logs: v, d, i, w, e. Many of those log statements need to be in the code. For example, some of them handle exceptions. Thus, it's not the best practice to flood LogCat with log statements, as you'll have to pick them out before you commit. 

##### Solution 
Create an alternative for logging, specifically bulk logging. Allow this logging to go to a text file that can be easily saved and read externally. Maybe even allow some processing on this file? 
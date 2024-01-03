# InterStopwatch App

Overview
The InterStopwatch app is a simple stopwatch application developed for Android using Java and the Android Studio framework. It provides basic stopwatch functionalities such as start, stop, lap, and reset, along with a display of elapsed time and a list of lap times.

Features

•	Start/Stop Button: Initiates and stops the stopwatch.
•	Lap Button: Records lap times and displays them in a list.
•	Reset Button: Resets the stopwatch and clears lap times.
•	Lap Time List: Displays a list of recorded lap times.
•	Real-time Display: The elapsed time is displayed in the format HH:MM:SS.


Implementation Details

Stopwatch Logic
The stopwatch logic is implemented using a combination of Handler and Runnable for real-time updates. The elapsed time is calculated in hours, minutes, seconds, and milliseconds.
Lap Times
Lap times are recorded and displayed in a ListView. The lap button triggers the recording of the current elapsed time.
User Interface (UI)
The UI is implemented using the Android XML layout file. It includes a TextView for displaying the elapsed time, several FloatingActionButtons for controlling the stopwatch, and a ListView for lap times.

How to Use
1.	Start: Click the play button to start the stopwatch.
2.	Stop: Click the pause button to stop the stopwatch.
3.	Lap: Click the flag icon to record a lap time.
4.	Reset: Click the stop icon to reset the stopwatch and clear lap time.

   
Dependencies

•	AndroidX Library
•	Google Material Components Library


Acknowledgments

The app was created as a Internship project.

Author
Sumit Gohil 

Feel free to contribute, report issues, or suggest improvements. Happy timekeeping!

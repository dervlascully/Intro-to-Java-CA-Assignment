# Intro-to-Java-CA-Assignment

2nd Year Semester 1 Intro to Java Assignment (Autumn 2019).

Grade Recieved: A+

See pdf report

***********

Task:
For this assignment, you should answer the sample exam question present on Moodle (see sample exam question pdf) three times such that you would expect:
1. the first solution receive a B grade or higher, 
2. the second solution receive a C grade,
3. the third solution receive a D grade.
All parts of all three solutions must


• compile
• be free of arithmetic errors, intentional logical errors, and infinite loops
• be complete, i.e. an answer must be provided to parts a, b, c, and d. You cannot differentiate the quality of the solution based on part e.


To substantiate your claim on the quality of the solutions, prepare and execute ONE set of JUnit tests that evidences the rank order of your solutions. All three solutions should be tested with the same set of unit tests.
You can have three JUnit test .java files, if needed. However, all methods with a @Test annotation must be the same.

**********

The task for the assignment was to create a set of JUnit tests to test solutions to the sample exam question. We also had to answer the sample exam question three times; once at a D standard, once at a C standard and once at a B and above. The number of JUnit tests that each of these sample answers fails should then approximately reflect the grade (for example, the D answer should fail more tests than the C answer, and the C should fail more than the B). I decided to take it one step further and have my program calculate the exact percentage and grade based on the tests passed/failed. I first divided up all of the marks of the entire question taking into account every requirement mentioned (marks for each section were outlined but marks within the sections I had to further divide up myself based on the requirements outlined). The entire question is worth 25 marks. I wrote JUnit tests to test each requirement outlined in the question. If a test failed then the marks for that requirement were deducted from the 25. Once all tests were run the program calculated the percentage and grade based on the marks after deduction. 

Based on the way in which I divided up the marks, I worked out what I would need to get right/wrong to get an A grade, a C grade and a D grade in the question. I did out the 3 solutions and ran them through my series of JUnit tests. As I had hoped, my program deduced that the 1st was an A grade, the 2nd a C grade and the 3rd a D grade, indicating that my program seemed to be running correctly, accurately calculating the exact grade of sample answers to the exam question.

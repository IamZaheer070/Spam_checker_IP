IP Address Analysis and Spam Detection Project

This project is a Java-based application designed to analyze IP addresses from a log file, identify potential spammers using the Spamhaus Block List (SBL), and count the number of accesses by each IP address.

Project Overview

1. File I/O Operations
File Reading: The program reads a log file (log.txt) containing IP addresses and their associated log entries. The IP address is extracted from each entry, and the rest of the log data is processed separately.
Counting IP Occurrences: The program counts how many times each IP address appears in the log file by reading the file and matching each line against the stored IP addresses.

2. Spam Detection
Spamhaus Block List Check: The program checks whether an IP address is listed in the Spamhaus Block List (SBL). If the IP is flagged as a spammer, the program outputs a message indicating that the IP is known as a spammer.

3. Array and Sorting Operations
IP Access Count Storage: The number of accesses for each IP address is stored in an array.
Sorting: The array is sorted in descending order to prioritize IP addresses with the highest number of accesses.

4. Performance Considerations
Error Handling: The program includes error handling for file input/output operations and network operations, ensuring robust and reliable execution.
Optimization: The program has been structured to minimize unnecessary file reading and to ensure efficient counting and sorting operations.
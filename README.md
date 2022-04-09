
# Cron Expression Parser 
This is a Java Application which parses a basic cron string and expands each field to show the times at which it will run. 


## CRON Expression 

Considering the standard cron format with five time fields (minute, hour, day of month, month, and day of week) plus a command. This application does not handle the special time strings such as "@yearly".

#### Allowed Special Characters in cron expression

| Special Character | Description                |
| :-------- | :------------------------- |
| `*` | any value|
| `,` | value list separator|
| `/` | step values|
| `-` | range of values|

## Steps To Run  
- Download the project into any workspace
- Open any java IDE and import as maven project 
- Run the maven project (Jar file will be created)
- Run the following command in command line (Terminal) and pass the cron string as a single argument


```
java -jar /path/to/jar/file/expression.parser-0.0.1-SNAPSHOT.jar ＂<cron Expression>＂`
```
- The output is formatted as a table with the field name taking the first 14 columns and the times as a space-separated list following it. 

## Example

```
- For example, the following input argument: 
*/15 0 1,15 * 1-5 /usr/bin/find

- Should yield the following output

minute          0 15 30 45 
hour            0 
day of month    1 15 
month           1 2 3 4 5 6 7 8 9 10 11 12 
day of week     1 2 3 4 5 
command         /usr/bin/find


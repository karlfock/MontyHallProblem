:: pass number of executions as argument to the script
@set numberOfExecutions=%1
@cd "%~dp0" 

@java -cp target\classes se.claremont.montyhallproblem.Main %numberOfExecutions%

@pause
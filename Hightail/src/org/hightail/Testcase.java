package org.hightail;

import java.io.*;
import java.util.Calendar;
import java.util.concurrent.Callable;
import org.hightail.diff.OutputDiff;

public class Testcase implements Callable<ExecutionResult> {
    public static final int DEFAULT_TIME_LIMIT = 3;
    
    protected int index = 0;
    protected String input;
    protected String expectedOutput;
    protected String programOutput = "";
    protected String programError = "";
    protected int timeLimit = DEFAULT_TIME_LIMIT;
    protected ExecutionResult executionResult = new ExecutionResult();
    protected Process executionProcess;
    private String pathToExecFile;
    
    public Testcase() {
        this.input = "";
        this.expectedOutput = "";
    }
    
    public String getInput() {
        return input;
    }
    
    public void setInput(String input) {
        this.input = input;
    }
    
    public String getExpectedOutput() {
        return expectedOutput;
    }
    
    public void setExpectedOutput(String expectedOutput) {
        this.expectedOutput = expectedOutput;
    }
    
    public String getProgramOutput() {
        return programOutput;
    }
    
    public void setProgramOutput(String programOutput) {
        this.programOutput = programOutput;
    }
    
    public ExecutionResult getExecutionResult() {
        return executionResult;
    }
    
    public void setExecutionResultCode(ExecutionResultCode result) {
        emptyResultsOfTestCase();
        this.executionResult.setResult(result);
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }
    
    public int getTimeLimit() {
        return timeLimit;
    }
    
    public Testcase(String input, String expectedOutput) {
        this(input, expectedOutput, DEFAULT_TIME_LIMIT);
    }
    
    public Testcase(String input, String expectedOutput, int timeLimit) {
        this.input = input;
        this.expectedOutput = expectedOutput;
        this.timeLimit = timeLimit;
    }
    
    public void save() {
        // testcase has been changed by user, so results are obsolete
        emptyResultsOfTestCase();
    }
    
    public void emptyResultsOfTestCase() {
        programOutput = "";
        executionResult = new ExecutionResult();
    }
    
    public void killTest() {
        try {
            executionProcess.exitValue();
        } catch (IllegalThreadStateException ex) {
            executionProcess.destroy();
        }
    }
    
    @Override
    public ExecutionResult call() {
        emptyResultsOfTestCase();
        try {
            String line;
            BufferedReader br;
            StringBuilder sb;
            executionResult.setResult(ExecutionResultCode.RUNNING);
            
            double startTime = Calendar.getInstance().getTimeInMillis();
            // TODO: measure CPU time of executionProcess instead
            
            executionProcess = Runtime.getRuntime().exec(pathToExecFile);
            
            OutputStream stdin = executionProcess.getOutputStream();
            InputStream stderr = executionProcess.getErrorStream();
            InputStream stdout = executionProcess.getInputStream();
            
            // writing input
            stdin.write(input.getBytes());
            stdin.flush();
            stdin.close();
            
            // reading stdout
            br = new BufferedReader(new InputStreamReader(stdout));
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            programOutput = sb.toString();
            br.close();
            
            // reading stderr
            br = new BufferedReader(new InputStreamReader(stderr));
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            programError = sb.toString();
            br.close();
            
            int execRes = executionProcess.waitFor();
            double endTime = Calendar.getInstance().getTimeInMillis();
            executionResult.setTime((endTime - startTime) / 1000.0);
            
            if (execRes == 0) {
                String res = OutputDiff.diff(expectedOutput, programOutput);
                if (res.equals("OK")) {
                    executionResult.setResult(ExecutionResultCode.OK);
                } else {
                    executionResult.setResult(ExecutionResultCode.WA);
                    executionResult.setMsg(res);
                }
            } else if (executionResult.getResult() == ExecutionResultCode.RUNNING) {
                executionResult.setResult(ExecutionResultCode.RUNTIME);
            }
            
            
            
        } catch (InterruptedException | IOException ex) {
            // time out or abort or something else
        }
        return executionResult;
    }
    
    void setPathToExecFile(String pathToExecFile) {
        this.pathToExecFile = pathToExecFile;
    }
}
